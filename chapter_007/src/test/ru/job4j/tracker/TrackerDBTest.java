package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerDBTest {

    /**
     * Field Connection object in DB.
     */
    private Connection conn = null;

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
     * Object for need check.
     */
    private TrackerDB trackerDB;

    private static final Random rn = new Random();

    /**
     * Initialize fro test.
     */
    @Before
    public void initialize() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found!!!");
            e.printStackTrace();
        }
        this.url = "jdbc:postgresql://localhost:5432/db_tracker";
        this.userName = "postgres";
        this.userPassword = "root";
        this.trackerDB = new TrackerDB();
    }

    /**
     * Test add item.
     */
    @Test
    public void whenAddItemInDbThenAddInDb() {
        Item item = new Bug("testJUnit", "testJUnit");
        item.setId(String.valueOf(rn.nextInt(100)));
        int execute = trackerDB.addItem(item);
        try {
            this.conn = DriverManager.getConnection(this.url, this.userName, this.userPassword);
            Statement ps = this.conn.createStatement();
            ps.executeUpdate("DELETE FROM tracker as tr where tr.fname = 'testJUnit'");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        assertThat(execute, is(1));
    }

    /**
     * Test get all item in DB.
     */
    @Test
    public void whenNeedGetAllItemsThenGet() {
        Item item = new Bug("testJUnit", "testJUnit");
        trackerDB.addItem(item);
        Map<Integer, Item> result = trackerDB.findAll();
        assertThat(result.size() > 0, is(true));
    }

    /**
     * Test find by name in DB.
     */
//    @Test
//    public void whenNeedFindItemByNameThenFound() {
//        Item item = new Bug("testJUnit", "testJUnit");
//        trackerDB.addItem(item);
//        Map<Integer, Item> result = trackerDB.findByName("testJUnit");
//        int iid = -1;
//        for (Map.Entry<Integer, Item> next : result.entrySet()) {
//            iid = next.getValue().getId();
//        }
//        assertThat(result.get(iid).getName(), is(item.getName()));
//        trackerDB.deleteItemById(iid);
//    }

    /**
     * Test find by name.
     */
//    @Test
//    public void whenNeedFindByNameThenFound() {
//        Item item = new Bug("testJUnit", "testJUnit");
//        item.setId(-1);
//        trackerDB.addItem(item);
//        Item result = trackerDB.findById(-1);
//        assertThat(result.getId(), is(-1));
//        trackerDB.deleteItemById(-1);
//    }
}