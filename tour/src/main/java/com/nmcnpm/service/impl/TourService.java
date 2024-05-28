package com.nmcnpm.service.impl;

import com.nmcnpm.dao.impl.TourDAO;
import com.nmcnpm.model.Tour;
import com.nmcnpm.model.TourDate;
import com.nmcnpm.service.intf.IService;

import java.util.List;

public class TourService implements IService<Tour> {
    private final TourDAO tourDAO = new TourDAO();

    @Override
    public List<Tour> getAll() {
        // Lấy ra List Tour từ database
        List<Tour> tours = tourDAO.getAll();
        for (Tour tour : tours) {
            List<TourDate> tourDates = tourDAO.getDatesByTourId(tour.getId());
            tour.setTourDates(tourDates);
        }
        System.out.println(tours);
        return tours;
    }
}
