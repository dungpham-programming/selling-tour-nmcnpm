package com.nmcnpm.service.impl;

import com.nmcnpm.dao.ImageDAO;
import com.nmcnpm.dao.impl.TourDAO;
import com.nmcnpm.model.Image;
import com.nmcnpm.model.Tour;
import com.nmcnpm.model.TourDate;
import com.nmcnpm.service.intf.IService;

import java.util.List;

public class TourService implements IService<Tour> {
    private final TourDAO tourDAO = new TourDAO();
    private final ImageDAO imageDAO = new ImageDAO();

    @Override
    public List<Tour> getAll() {
        // Lấy ra List Tour từ database
        List<Tour> tours = tourDAO.getAll();
        for (Tour tour : tours) {
            List<TourDate> tourDates = tourDAO.getDatesByTourId(tour.getId());
            tour.setTourDates(tourDates);
        }
        return tours;
    }

    @Override
    public Tour getById(int id) {
        Tour tour = tourDAO.getById(id);
        List<Image> images = imageDAO.getByTourId(id);
        tour.setImages(images);
        return tour;
    }
}
