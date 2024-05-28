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
        String sql = "SELECT * FROM order_tours";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
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

    public static void main(String[] args) {
        System.out.println(getOrderTourById(1));
    }
}
