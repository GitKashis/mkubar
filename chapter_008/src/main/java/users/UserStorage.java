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
    private volatile static UserStorage instance;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStorage.class);

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
            LOGGER.error(e.getMessage(), e);
        }

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db-param.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String urlDB = String.format("jdbc:postgresql://%s", this.properties.getProperty("urlAddress"));
        String userNameDB = this.properties.getProperty("userName");
        String passwordDB = this.properties.getProperty("userPassword");
        boolean dbExist = Boolean.valueOf(this.properties.getProperty("dbTableExist"));
        this.pool.setDriverClassName("org.postgresql.Driver");
        this.pool.setUrl(urlDB);
        this.pool.setUsername(userNameDB);
        this.pool.setPassword(passwordDB);
        this.pool.getConnection();
        if (!dbExist) {
            createTableInDB();
        }
    }
    /**
     * Save data in prop.
     */
    private void saveProp() {
        try (FileOutputStream os = new FileOutputStream(("db-param.properties"))) {
            this.properties.store(os, "No commit");
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Create table in DB if not exist.
     */
    public void createTableInDB() throws SQLException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("newTable.sql");
        Connection conn = pool.getConnection();
        ScriptRunner scriptExecutor = new ScriptRunner(conn, false, false);
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            scriptExecutor.runScript(reader);
            this.properties.setProperty("dbTableExist", "true");
            saveProp();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
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
            LOGGER.error(e.getMessage(), e);
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
        String query;
        if (email == null && id != null) {
            query = "DELETE FROM user_store AS us WHERE us.iid = ?";
            flag = false;
        } else {
            query = "DELETE FROM user_store AS us WHERE us.email=?";
            flag = true;
        }
        boolean result = false;
        try (Connection connection = this.pool.getConnection()) {
            connection.setAutoCommit(false);
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
            LOGGER.error(e.getMessage(), e);
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
            LOGGER.error(e.getMessage(), e);
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
                try (ResultSet rs = ps.executeQuery("SELECT iid, name, login, email, create_date, user_password FROM user_store")) {
                    while (rs.next()) {
                        int id = rs.getInt("iid");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(rs.getTimestamp("create_date").getTime());
                        usersMap.put(id,
                                new User(id,
                                        rs.getString("name"),
                                        rs.getString("login"),
                                        rs.getString("email"),
                                        calendar,
                                        rs.getString("user_password")));
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
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
                                    rs.getString("user_password"));
                            index++;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return user;
    }

    /**
     * Getter for instance field.
     *
     * @return instance
     */

    public static UserStorage getInstance() throws SQLException {
        if (instance == null) {
            synchronized (UserStorage.class) {
                if (instance == null) {
                    instance = new UserStorage();
                }
            }
        }
        return instance;
    }
}
