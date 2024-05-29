package com.nmcnpm.model.user;

import com.nmcnpm.model.OrderTour;
import com.nmcnpm.model.TourReview;

import java.util.List;

public class Customer {
    private String customerBadge;
    private int loyaltyPoint;
    private List<OrderTour> orderTours;
    private List<TourReview> tourReviews;

    // Getters and Setters
    public String getCustomerBadge() {
        return customerBadge;
    }

    public void setCustomerBadge(String customerBadge) {
        this.customerBadge = customerBadge;
    }

    public int getLoyaltyPoint() {
        return loyaltyPoint;
    }

    public void setLoyaltyPoint(int loyaltyPoint) {
        this.loyaltyPoint = loyaltyPoint;
    }

    public List<OrderTour> getOrderTours() {
        return orderTours;
    }

    public void setOrderTours(List<OrderTour> orderTours) {
        this.orderTours = orderTours;
    }

    public List<TourReview> getTourReviews() {
        return tourReviews;
    }

    public void setTourReviews(List<TourReview> tourReviews) {
        this.tourReviews = tourReviews;
    }
}