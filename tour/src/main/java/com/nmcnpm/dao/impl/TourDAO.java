package com.nmcnpm.dao.impl;

import com.nmcnpm.dao.intf.IDao;
import com.nmcnpm.mapping.MapperData;
import com.nmcnpm.model.Tour;
import com.nmcnpm.model.TourDate;
import com.nmcnpm.util.ConfigConnectionUtil;
import com.nmcnpm.util.SetParameterUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDAO implements IDao<Tour> {
    @Override
    public List<Tour> getAll() {
        List<Tour> tours = new ArrayList<>();
        String sql = "SELECT * FROM tours";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            rs = preStat.executeQuery();

            while (rs.next()) {
                Tour tour = MapperData.mappingTour(rs);
                tours.add(tour);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return tours;
    }

    public List<TourDate> getDatesByTourId(int tourId) {
        List<TourDate> tourDates = new ArrayList<>();
        String sql = "SELECT * FROM tour_dates WHERE tourId = ?";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            SetParameterUtil.setParameter(preStat, tourId);
            rs = preStat.executeQuery();

            while (rs.next()) {
                TourDate tourDate = MapperData.mappingTourDate(rs);
                tourDates.add(tourDate);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return tourDates;
    }
}
