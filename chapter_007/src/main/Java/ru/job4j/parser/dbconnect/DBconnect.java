package ru.job4j.parser.dbconnect;

import com.ibatis.common.jdbc.ScriptRunner;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class DBconnect {

    /**
     * Address database.
     */
    private String urlDB;

    /**
     * User name for connect from db.
     */
    private String userNameDB;

    /**
     * Password db.
     */
    private String passwordDB;

    /**
     * Pool connection database.
     */
    private BasicDataSource pool;

    /**
     * Properties object.
     */
    private Properties properties = new Properties();

    /**
     * Logger.
     */
    private final Logger logger = LoggerFactory.getLogger(DBconnect.class);

    /**
     * Constructor.
     */
    public DBconnect() throws SQLException {
        this.propLoad();
    }

    /**
     * Initialize prop for connect in db.
     */
    private void propLoad() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            properties.load(new FileInputStream("C:\\Projects\\mkubar\\chapter_007\\src\\main\\Java\\ru\\job4j\\parser\\resources\\db-param.properties"));
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
        try (FileOutputStream os = new FileOutputStream(ClassLoader.getSystemResource("C:\\Projects\\mkubar\\chapter_007\\src\\main\\Java\\ru\\job4j\\parser\\resources\\db-param.properties").getPath())) {
            this.properties.store(os, "No commit");
        } catch (IOException e) {
            this.logger.error(e.getMessage(), e);
        }
    }

    /**
     * Create table in DB if not exist.
     */
    public void createTableInDB() throws SQLException {
        String scriptFilePath = "C:\\Projects\\mkubar\\chapter_007\\src\\main\\Java\\ru\\job4j\\parser\\resources\\newTable.sql";
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
     * Save data in db.
     *
     */
    public void addNodeInDB(List<?> list) {

    }


}
