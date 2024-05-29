package com.nmcnpm.dao;

import com.nmcnpm.dao.intf.IDao;
import com.nmcnpm.mapping.MapperData;
import com.nmcnpm.model.Image;
import com.nmcnpm.model.Tour;
import com.nmcnpm.util.ConfigConnectionUtil;
import com.nmcnpm.util.SetParameterUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO implements IDao<Image> {

    @Override
    public List<Image> getAll() {
        return null;
    }

    @Override
    public Image getById(int id) {
        return null;
    }

    public List<Image> getByTourId(int tourId) {
        List<Image> images = new ArrayList<>();
        String sql = "SELECT * FROM images WHERE tourId = ?";

        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            SetParameterUtil.setParameter(preStat, tourId);
            rs = preStat.executeQuery();

            while (rs.next()) {
                Image image = MapperData.mappingImage(rs);
                images.add(image);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return images;
    }
}
