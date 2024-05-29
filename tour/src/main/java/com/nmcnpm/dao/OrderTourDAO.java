package com.nmcnpm.dao;

import com.nmcnpm.mapping.MapperData;
import com.nmcnpm.model.OrderTour;
import com.nmcnpm.util.ConfigConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderTourDAO {
    public static OrderTour getOrderTourById(int id) {
        String sql = "SELECT * FROM order_tours where id=?";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            preStat.setInt(1, id);
            rs = preStat.executeQuery();
            if (rs.next()) {
                OrderTour tour = MapperData.mappingOrderTours(rs);
                return tour;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return null;
    }

    public static List<OrderTour> getOrderTourToPayment() {
        String sql = "SELECT * FROM order_tours where paymentTransactionId is null";
        List<OrderTour> orderTours = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            rs = preStat.executeQuery();
            while (rs.next()) {
                OrderTour tour = MapperData.mappingOrderTours(rs);
                orderTours.add(tour);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return orderTours;
    }

    public static void updatePaymentTransactionId(int orderId, String paymentTransactionId) {
        String sql = "UPDATE order_tours SET paymentTransactionId = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement preStat = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            preStat.setString(1, paymentTransactionId);
            preStat.setInt(2, orderId);
            preStat.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, null);
        }
    }

    public static void main(String[] args) {
        System.out.println(getOrderTourToPayment());
    }
}
