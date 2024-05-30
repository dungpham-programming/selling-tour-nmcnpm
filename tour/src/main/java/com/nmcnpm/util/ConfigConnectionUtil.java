package com.nmcnpm.util;

import java.sql.*;
import java.util.ResourceBundle;

public class ConfigConnectionUtil {
    static ResourceBundle bundle = ResourceBundle.getBundle("database-connection");

    public static Connection getConnection() {
        try {
            Class.forName(bundle.getString("driverName"));
            String url = bundle.getString("url");
            String user = bundle.getString("user");
            String password = bundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static void closeResource(Connection conn, PreparedStatement preStat, ResultSet rs) {

    }

    public static void closeResource(Connection conn, PreparedStatement preStat) {

    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println(conn);
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
