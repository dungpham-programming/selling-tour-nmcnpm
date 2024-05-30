package com.nmcnpm.mapping;

import com.nmcnpm.model.Image;
import com.nmcnpm.model.Tour;
import com.nmcnpm.model.TourDate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperData {
    public static Tour mappingTour(ResultSet rs) {
        Tour tour = new Tour();

        try {
            tour.setId(rs.getInt("id"));
            tour.setTourCateId(rs.getInt("tourCateId")); // Camel case key
            tour.setName(rs.getString("name"));
            tour.setDescription(rs.getString("description"));
            tour.setVehicle(rs.getString("vehicle"));
            tour.setStarting(rs.getString("starting"));
            tour.setDestination(rs.getString("destination"));
            tour.setTravelTime(rs.getString("travelTime"));
            tour.setPrice(rs.getDouble("price"));
            tour.setTimeline(rs.getString("timeline"));
            tour.setStatus(rs.getString("status"));
            tour.setCreatedAt(rs.getDate("createdAt"));
            tour.setCreatedBy(rs.getString("createdBy"));
            tour.setModifiedAt(rs.getDate("modifiedAt"));
            tour.setModifiedBy(rs.getString("modifiedBy"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tour;
    }

    public static TourDate mappingTourDate(ResultSet rs) {
        TourDate tourDate = new TourDate();

        try {
            tourDate.setId(rs.getInt("id"));
            tourDate.setTourId(rs.getInt("tour_id"));
            tourDate.setStartDate(rs.getDate("start_date"));
            tourDate.setEndDate(rs.getDate("end_date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tourDate;
    }

    public static Image mappingImage(ResultSet rs) {
        Image image = new Image();

        try {
            image.setId(rs.getInt("id"));
            image.setTourId(rs.getInt("tourId"));
            image.setName(rs.getString("name"));
            image.setUrl(rs.getString("url"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
