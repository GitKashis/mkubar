package users;

import com.ibatis.common.jdbc.ScriptRunner;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserStorage {

    /**
     * Instance these class.
     */
    private static UserStorage INSTANSE;

    /**
     * Pool object for connect DB.
     */
    private BasicDataSource pool = new BasicDataSource();

    /**
     * Properties object.
     */
    private final Properties properties = new Properties();

    /**
     * Logger object.
     */
    private static final Logger logger = LoggerFactory.getLogger(UserStorage.class);

    private String urlDB;
    private String userNameDB;
    private String passwordDB;

    /**
     * Constructor.
     */
    private UserStorage() throws SQLException {
        initializeDbUser();
    }

    /**
     * Initialize prop for connect in db.
     */
    private void initializeDbUser() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            properties.load(new FileInputStream("C:\\projects\\mkubar\\chapter_008\\src\\main\\resources\\db-param.properties"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        this.urlDB = String.format("jdbc:postgresql://%s", this.properties.getProperty("urlAddress"));
        this.userNameDB = this.properties.getProperty("userName");
        this.passwordDB = this.properties.getProperty("userPassword");
        boolean dbExist = Boolean.valueOf(this.properties.getProperty("dbTableExist"));
        this.getConnection();
        if (!dbExist) {
            createTableInDB();
        }
    }
    /**
     * Get Connection from pool
     * @return connection
     */
    public Connection getConnection() throws SQLException {
        this.pool = new BasicDataSource();
        this.pool.setDriverClassName("org.postgresql.Driver");
        this.pool.setUrl(this.urlDB);
        this.pool.setUsername(this.userNameDB);
        this.pool.setPassword(this.passwordDB);
        return this.pool.getConnection();
    }
    /**
     * Save data in prop.
     */
    private void saveProp() {
        try (FileOutputStream os = new FileOutputStream(("C:\\projects\\mkubar\\chapter_008\\src\\main\\resources\\db-param.properties"))) {
            this.properties.store(os, "No commit");
        } catch (IOException e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    /**
     * Create table in DB if not exist.
     */
    public void createTableInDB() throws SQLException {
        String scriptFilePath = "C:\\projects\\mkubar\\chapter_008\\src\\main\\resources\\newTable.sql";
        Connection conn = pool.getConnection();
        ScriptRunner scriptExecutor = new ScriptRunner(conn, false, false);
        try (Reader reader = new BufferedReader(new FileReader(scriptFilePath))) {
            scriptExecutor.runScript(reader);
            this.properties.setProperty("dbTableExist", "true");
            saveProp();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Add user in db.
     *
     * @param user need add
     * @return yes or not
     */
    public boolean addUserInDB(User user) {
        boolean result = false;
        try (Connection connection = this.pool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO user_store(name, login, email, user_password) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Delete user in DB by id.
     *
     * @param id User
     * @return yes or not
     */
    public boolean delUserByID(int id) {
        return this.delUserInDB(null, id);
    }

    /**
     * Delete user in BD by email.
     *
     * @param email user
     * @return yes or not
     */
    public boolean delUserByEmail(String email) {
        return this.delUserInDB(email, null);
    }

    /**
     * Delete user in DB.
     *
     * @param email User
     * @param id    User
     * @return yes or not
     */
    public boolean delUserInDB(String email, Integer id) {
        boolean flag;
        String query = "";
        String queryDelRole = "";
        if (email == null && id != null) {
            query = "DELETE FROM user_store AS us WHERE us.iid = ?";
            queryDelRole = "DELETE FROM user_role WHERE iid_user=?";
            flag = false;
        } else {
            query = "DELETE FROM user_store AS us WHERE us.email=?";
            queryDelRole = "DELETE FROM user_role WHERE iid_user=(SELECT iid FROM user_store WHERE email=?)";
            flag = true;
        }
        boolean result = false;
        try (Connection connection = this.pool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(queryDelRole)) {
                if (flag) {
                    ps.setString(1, email);
                } else {
                    ps.setInt(1, id);
                }
                ps.executeUpdate();
            }
            try (PreparedStatement ps = connection.prepareCall(query)) {
                if (flag) {
                    ps.setString(1, email);
                } else {
                    ps.setInt(1, id);
                }
                if (ps.executeUpdate() > 0) {
                    result = true;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Update User in DB.
     * @param user object
     */
    public void updateUserInDB(User user) {
        try (Connection connection = this.pool.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareCall("UPDATE user_store SET name = ?, login = ?, email = ? WHERE iid = ?")) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getEmail());
                ps.setInt(4, user.getId());
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Get all User in db.
     * @return list user
     */
    public List<User> getAllUserInDB() {
        List<User> listUsers = new ArrayList<>(1000);
        Map<Integer, User> usersMap = new HashMap<>(100);
        try (Connection connection = this.pool.getConnection()) {
            try (Statement ps = connection.createStatement()) {
                try (ResultSet rs = ps.executeQuery("SELECT iid, name, login, email, create_date, name_role, user_password FROM users_view")) {
                    while (rs.next()) {
                        int id = rs.getInt("iid");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(rs.getTimestamp("create_date").getTime());
                        if (usersMap.containsKey(id)) {
                            User user = usersMap.get(id);
                            user.getRoles().add(rs.getString("name_role"));
                        } else {
                            usersMap.put(id,
                                    new User(id,
                                            rs.getString("name"),
                                            rs.getString("login"),
                                            rs.getString("email"),
                                            calendar,
                                            rs.getString("name_role"),
                                            rs.getString("user_password")));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        for (Map.Entry<Integer, User> next : usersMap.entrySet()) {
            listUsers.add(next.getValue());
        }
        return listUsers;
    }


    /**
     * Get User object in database.
     * @param id User
     * @param login Login
     * @return User object
     */
    private User getUser(Integer id, String login) {
        User user = null;
        String query;
        boolean flag;
        if (login == null) {
            query = "SELECT * FROM users_view WHERE iid=?";
            flag = true;
        } else {
            query = "SELECT * FROM users_view WHERE login=?";
            flag = false;
        }
        try (Connection connection = this.pool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                if (flag) {
                    ps.setInt(1, id);
                } else {
                    ps.setString(1, login);
                }
                try (ResultSet rs = ps.executeQuery()) {
                    int index = 0;
                    while (rs.next()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(rs.getTimestamp("create_date").getTime());
                        if (index == 0) {
                            user = new User(rs.getInt("iid"),
                                    rs.getString("name"),
                                    rs.getString("login"),
                                    rs.getString("email"),
                                    calendar,
                                    rs.getString("name_role"),
                                    rs.getString("user_password"));
                            index++;
                        } else {
                            user.addRole(rs.getString("name_role"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Getter for instance field.
     *
     * @return instance
     */
    public static UserStorage getInstanse() {
        if (INSTANSE == null) {
            try {
                INSTANSE = new UserStorage();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return INSTANSE;
    }
}
