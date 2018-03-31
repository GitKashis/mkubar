package ru.job4j.car_catalog;

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
            ResultSet rs = st.executeQuery("select c.mark, e.fuel_type, t.type, cb.form from car as c " +
                    "inner join engine as e on c.engine_id = e.id " +
                    "inner join transmission as t on c.transmission_id = t.id " +
                    "inner join car_body as cb on c.carbody_id = cb.id;");
            while (rs.next()){
                System.out.println(String.format("%s %s %s %s",
                        rs.getString("mark"),
                        rs.getString("fuel_type"),
                        rs.getString("type"),
                        rs.getString("form")));
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
