package ru.job4j.optimization;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Connect {
    /**
     * Count of numbers wich need add to database.
     */
    private int field;
    private String url;
    private java.sql.Connection cn = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    /**
     * Open connection to database.
     */
    public void openConnections() {
        try {
            cn = DriverManager.getConnection(url);
            st = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Create new table if it not exist in database.
     */
    public void initTable() {
        try {
            st.execute("CREATE TABLE IF NOT EXISTS test(field INTEGER)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Add numbers to database.
     */
    public void addNumbers() {
        try {
            st.execute("DELETE FROM test");
            cn.setAutoCommit(false);
            System.out.println("start adding to DB");
            long s = System.currentTimeMillis();

            for (int i = 1; i <= this.field; i++) {
                pst = cn.prepareStatement("INSERT INTO test(field) VALUES (?)");
                pst.setInt(1, i);
                pst.executeUpdate();
                if (i > 500 && i % 500 == 0) {
                    st.executeBatch();
                }
            }
            long res = System.currentTimeMillis() - s;
            System.out.println("finish adding to DB " + res + " ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Get numbers from database.
     * @return int[].
     */
    public int[] getNumbers() {
        int[] result = new int[this.field];
        int index = 0;
        try {
            pst = cn.prepareStatement("SELECT test.field FROM test");
            rs = pst.executeQuery();
            while (rs.next()) {
                result[index++] = rs.getInt("field");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Close all opening connections.
     */
    public void closeConnections() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Set url - address for getting connection to database.
     * @param url - address.
     */
    public void setURL(String url) {
        this.url = url;
    }
    /**
     * Set count of numbers.
     * @param field - count of number.
     */
    public void setN(int field) {
        this.field = field;
    }
}