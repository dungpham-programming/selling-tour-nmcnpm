package com.nmcnpm.dao;

import com.nmcnpm.mapping.MapperData;
import com.nmcnpm.model.OrderTour;
import com.nmcnpm.model.Transaction;
import com.nmcnpm.util.ConfigConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    public static Transaction getTransactionById(String id) {
        String sql = "SELECT * FROM transaction WHERE id=?";
        Connection conn = null;
        PreparedStatement preStat = null;
        ResultSet rs = null;
        Transaction transaction = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            preStat.setString(1, id);
            rs = preStat.executeQuery();

            if (rs.next()) { // Duyệt kết quả truy vấn
                transaction = MapperData.mappingTransaction(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, rs);
        }
        return transaction;
    }
    public static boolean insertTransaction(Transaction transaction) {
        String sql = "INSERT INTO transaction (id, amount, paymentMethod, currency, transactionStatus, transactionTime, transferorName) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement preStat = null;

        try {
            conn = ConfigConnectionUtil.getConnection();
            preStat = conn.prepareStatement(sql);
            preStat.setString(1, transaction.getId());
            preStat.setDouble(2, transaction.getAmount());
            preStat.setString(3, transaction.getPaymentMethod());
            preStat.setString(4, transaction.getCurrency());
            preStat.setString(5, transaction.getTransactionStatus());
            preStat.setString(6, transaction.getTransactionTime());
            preStat.setString(7, transaction.getTransferorName());

            int rowsAffected = preStat.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConfigConnectionUtil.closeResource(conn, preStat, null);
        }
    }
    public static void main(String[] args) {
        Transaction newTransaction = new Transaction("TXN004", "Credit Card", 250.00, "USD", "Completed", "2024-05-28 14:00:00", "Alice Brown");

        boolean success = insertTransaction(newTransaction);

        if (success) {
            System.out.println("Transaction inserted successfully:");
            System.out.println(newTransaction);
        } else {
            System.out.println("Failed to insert transaction.");
        }
    }

}
