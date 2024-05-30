package com.nmcnpm.payment.service;

import com.nmcnpm.payment.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.UUID;

public class PaymentAPI {
    public static Transaction getTransactionFromPaymentAPI(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
            double amount = Double.parseDouble(req.getParameter("amount"));
            String paymentMethod = req.getParameter("paymentMethod");
            String currency = req.getParameter("currency");
            String submit = req.getParameter("submit");
            String transactionStatus;
            if (submit != null && submit.equals("success")) {
                transactionStatus = "Success";
            } else {
                transactionStatus = "Fail";
            }
            String transactionTime = LocalTime.now().toString();
            String transferorName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 1);

            Transaction transaction = new Transaction(id, paymentMethod, amount, currency, transactionStatus, transactionTime, transferorName);
            return transaction;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
