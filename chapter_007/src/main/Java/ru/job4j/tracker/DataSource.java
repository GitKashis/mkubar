package ru.job4j.tracker;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private String url;
    private String userName;
    private String userPassword;
    private boolean dbExist = false;
    private Properties prop;

    public Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        prop = new Properties();
        prop.load(new FileInputStream("src\\main\\java\\ru\\job4j\\tracker\\resources\\connect-db.properties"));
        String driver = prop.getProperty("db.driver");
        this.url = String.format("jdbc:postgresql://%s/%s", prop.getProperty("db.host"), prop.getProperty("db.name"));
        this.userName = prop.getProperty("db.userName");
        this.userPassword = prop.getProperty("db.userPassword");
        this.dbExist = Boolean.valueOf(prop.getProperty("db.exist"));
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, userPassword);
    }


}
