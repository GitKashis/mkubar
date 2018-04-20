package ru.job4j.tracker;

import com.ibatis.common.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private String url;
    private String userName;
    private String userPassword;
    private boolean dbExist;
    private Properties prop = new Properties();
    private final Logger logger = LoggerFactory.getLogger(DataSource.class);

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("connect-db.properties");
        prop.load(inputStream);
        String driver = prop.getProperty("db.driver");
        this.url = String.format("jdbc:postgresql://%s/%s", prop.getProperty("db.host"), prop.getProperty("db.name"));
        this.userName = prop.getProperty("db.userName");
        this.userPassword = prop.getProperty("db.userPassword");
        this.dbExist = Boolean.valueOf(prop.getProperty("db.exist"));
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, userPassword);
    }
    /**
     * Check table in date base and create table if not exist.
     */
    public void createTablesInDB() throws IOException, SQLException {
        // initialize script path
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("newTable_query.sql");
        Connection conn = null;
        Reader reader = null;
        try {
            // create connection
            conn = getConnection();
            // create ScripRunner object
            ScriptRunner scriptExecutor = new ScriptRunner(conn, false, false);
            // initialize file reader
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // execute script with file reader as input
            scriptExecutor.runScript(reader);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            // close file reader
            if (reader != null) {
                reader.close();
            }
            // close db connection
            if (conn != null) {
                conn.close();
            }
        }
        this.dbExist = true;
    }

    public boolean isDbExist() {
        return dbExist;
    }


}
