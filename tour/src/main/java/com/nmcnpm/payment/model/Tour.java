package com.nmcnpm.payment.model;

import com.nmcnpm.model.Image;
import com.nmcnpm.model.TourDate;
import com.nmcnpm.model.TourReview;

import java.sql.Date;
import java.util.List;

public class Tour {
    private int id;
    private int tourCateId;
    private String name;
    private String description;
    private String vehicle;
    private String starting;
    private String destination;
    private String travelTime;
    private double price;
    private String timeline;
    private List<TourDate> tourDates;
    private String status;
    private List<TourReview> tourReviews;
    private List<Image> images;
    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTourCateId() {
        return tourCateId;
    }

    public void setTourCateId(int tourCateId) {
        this.tourCateId = tourCateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public List<TourDate> getTourDates() {
        return tourDates;
    }

    public void setTourDates(List<TourDate> tourDates) {
        this.tourDates = tourDates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TourReview> getTourReviews() {
        return tourReviews;
    }

    public void setTourReviews(List<TourReview> tourReviews) {
        this.tourReviews = tourReviews;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
