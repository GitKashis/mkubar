package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class TrackerDB {

    private final DataSource dataSource;
    /**
     * Url DB.
     */
    private String url;

    /**
     * User name for DB.
     */
    private String userName;

    /**
     * User password for DB.
     */
    private String userPassword;

    /**
     * Shgfj.
     */
    private boolean dbExist = false;

    /**
     * Properties.
     */
    private Properties properties = new Properties();

    /**
     * Field Class Loader.
     */
    private ClassLoader classLoader = TrackerDB.class.getClassLoader();

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(TrackerDB.class);

    /**
     * Constructor.
     */
    public TrackerDB() throws IOException, ClassNotFoundException {

        this.dataSource = new DataSource();
//        if (!dbExist) {
//            this.createTablesInDB();
//        }
    }


    /**
     * Check table in date base and create table if not exist.
     */
//    private void createTablesInDB() {
//        String[] query = null;
//        try (InputStream fo = classLoader.getResourceAsStream("src\\main\\java\\ru\\job4j\\tracker\\resources\\up_000_001.sql")) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fo));
//            StringBuilder sqlQuery = new StringBuilder();
//            boolean next = true;
//            do {
//                String readFio = reader.readLine();
//                if (readFio != null) {
//                    sqlQuery.append(readFio);
//                } else {
//                    next = false;
//                }
//            } while (next);
//            query = sqlQuery.toString().split(";");
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//        }
//        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
//            Statement st = conn.createStatement();
//            if (query != null) {
//                for (String aQuery : query) {
//                    st.execute(aQuery);
//                }
//            }
//            st.close();
//        } catch (SQLException e) {
//            logger.error(e.getMessage(), e);
//        }
//        this.properties.setProperty("db.exist", "true");
//    }

    /**
     * Add new Items in DB.
     *
     * @param item need add
     * @return count rows changed
     */
    public int addItem(Item item) throws SQLException, ClassNotFoundException, IOException {
        int result = -1;
        Connection conn = dataSource.getConnection();
            PreparedStatement ps;
            ps = conn.prepareStatement("INSERT INTO tracker(rid_items, fname, fdesc, item_id) VALUES (?, ?, ?, ?)");
            if (item.getClass() == Bug.class) {
                ps.setInt(1, 1);
            }
            if (item.getClass() == Task.class) {
                ps.setInt(1, 2);
            }
            ps.setString(2, item.getName());
            ps.setString(3, item.getDesc());
            ps.setInt(4, Integer.parseInt(item.getId()));
            result = ps.executeUpdate();
            ps.close();
        return result;
    }

    /**
     * Find all items in DB.
     *
     * @return Map items.
     */
    public Map<Integer, Item> findAll() {
        Map<Integer, Item> map = null;
        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT tr.item_id, it.fname AS type_item, tr.fname AS name_item, tr.fdesc, tr.fcommit, tr.fdate FROM tracker AS tr LEFT JOIN items AS it ON tr.rid_items = it.iid");
            map = this.getMapItem(rs);
            rs.close();
            st.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return map;
    }

    /**
     * Find item by name.
     *
     * @param nameItem name item
     * @return Map items
     */
    public Map<Integer, Item> findByName(String nameItem) {
        Item item = null;
        Map<Integer, Item> map = null;
        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
            PreparedStatement ps = conn.prepareStatement("SELECT tr.item_id, it.fname AS type_item, tr.fname AS name_item, tr.fdesc, tr.fcommit, tr.fdate FROM tracker AS tr LEFT JOIN items AS it ON tr.rid_items = it.iid WHERE tr.fname = ?");
            ps.setString(1, nameItem);
            ResultSet rs = ps.executeQuery();
            map = this.getMapItem(rs);
            rs.close();
            ps.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return map;
    }

    /**
     * Create Items object and add their in Map.
     *
     * @param rs ResultSet object
     * @return Map Items
     * @throws SQLException exception
     */
    private Map<Integer, Item> getMapItem(ResultSet rs) throws SQLException {
        Map<Integer, Item> map = new LinkedHashMap<>();
        while (rs.next()) {
            int idItem = rs.getInt("item_id");
            String itemType = rs.getString("type_item");
            Item item = null;
            if (itemType.equals("Bug")) {
                item = new Bug(rs.getString("name_item"), rs.getString("fdesc"));
            } else if (itemType.equals("Task")) {
                item = new Task(rs.getString("name_item"), rs.getString("fdesc"));
            }
            if (item != null) {
                item.setId(String.valueOf(idItem));
            }
            if (item != null) {
                item.setCommit(rs.getString("fcommit"));
            }
            if (item != null) {
                item.setDate(rs.getDate("fdate"));
            }
            if (item != null) {
                map.put(idItem, item);
            }
        }
        return map;
    }

    /**
     * Find item by id.
     *
     * @param id item
     * @return Item object
     */
    public Item findById(int id) {
        Item item = null;
        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
            PreparedStatement ps = conn.prepareStatement("SELECT tr.item_id, it.fname AS type_item, tr.fname " +
                    "AS name_item, tr.fdesc, tr.fcommit, tr.fdate FROM tracker AS tr " +
                    "LEFT JOIN items AS it ON tr.rid_items = it.iid " +
                    "WHERE tr.item_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Map<Integer, Item> map = getMapItem(rs);
            if (map.size() > 0) {
                item = map.get(id);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Delete Item in DB by Id.
     *
     * @param id item.
     */
    public void deleteItemById(int id) {
        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
            PreparedStatement pr = conn.prepareStatement("DELETE FROM tracker WHERE item_id = ?");
            pr.setInt(1, id);
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update item in db.
     *
     * @param item need update.
     */
    public void updateItem(Item item) {
        try (Connection conn = DriverManager.getConnection(this.url, this.userName, this.userPassword)) {
            PreparedStatement pr = conn.prepareStatement("UPDATE tracker SET fname = ?, rid_items = ?, fdesc = ?, fcommit = ?, fdate = ? WHERE iid = ?");
            pr.setString(1, item.getName());
            if (item.getClass() == Bug.class) {
                pr.setInt(2, 1);
            } else if (item.getClass() == Task.class) {
                pr.setInt(2, 2);
            }
            pr.setString(3, item.getDesc());
            pr.setString(4, item.getCommit());
            pr.setTimestamp(5, new Timestamp(item.getDate().getTime()));
            pr.setInt(6, Integer.parseInt(item.getId()));
            pr.executeUpdate();
            pr.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
