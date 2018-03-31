package ru.job4j;

import java.sql.*;

public class Car {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/car_catalog";
        String user = "postgres";
        String password = "root";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM car");
            while (rs.next()){
                System.out.println(String.format("%s", rs.getString("mark")));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
