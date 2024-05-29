package com.nmcnpm.payment.dao;

import com.nmcnpm.payment.util.ConfigConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    public static String getEmail(int customerId) {
        String sql = "SELECT * FROM customer where id=?";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            preStat.setInt(1, customerId);
            rs = preStat.executeQuery();
            if (rs.next()) {
                return rs.getString("email");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getEmail(1));
    }
}
