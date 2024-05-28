package com.nmcnpm.mapping;

import com.nmcnpm.model.OrderTour;
import com.nmcnpm.model.Tour;
import com.nmcnpm.model.TourDate;
import com.nmcnpm.model.Transaction;

import javax.naming.ldap.SortResponseControl;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperData {
    public static OrderTour mappingOrderTours(ResultSet rs) {
        OrderTour orderTour = new OrderTour();

        try {
            orderTour.setId(rs.getInt("id"));
            orderTour.setCustomerId(rs.getInt("customerId"));
            orderTour.setTotal(rs.getDouble("total"));
            orderTour.setNote(rs.getString("note"));
            orderTour.setPaymentTransactionId(rs.getString("paymentTransactionId"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderTour;
    }

    public static Transaction mappingTransaction(ResultSet rs) {
        Transaction transaction = new Transaction();
        try {
            transaction.setId(rs.getString("id"));
            transaction.setAmount(rs.getDouble("amount"));
            transaction.setPaymentMethod(rs.getString("paymentMethod"));
            transaction.setCurrency(rs.getString("currency"));
            transaction.setTransactionStatus(rs.getString("transactionStatus"));
            transaction.setTransactionTime(rs.getString("transactionTime"));
            transaction.setTransferorName(rs.getString("transferorName"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transaction;
    }
}
