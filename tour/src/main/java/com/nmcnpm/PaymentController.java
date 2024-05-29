package com.nmcnpm;

import com.nmcnpm.dao.CustomerDAO;
import com.nmcnpm.dao.OrderTourDAO;
import com.nmcnpm.dao.TransactionDAO;
import com.nmcnpm.model.OrderTour;
import com.nmcnpm.model.Transaction;
import com.nmcnpm.payment.JavaMail.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.UUID;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    /*
        Lấy dữ liệu order tour chưa có transaction order tour
        Chọn phương thức thanh toán
        Hiển thị các phương thức thanh toán
        Chọn 1 phương thức thanh toán
        Hiển thị QR + tổng tiền thanh toán
        Tiến hành thanh toán -> API xác nhận giao dịch
        -> có kết quả giao dịch -> gởi mail, hiển thị kết quả
           + success: insert order tour + transaction
           + fail: thông báo
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderTourId = (String) req.getParameter("orderTourId");
        if (orderTourId != null) {
            try {
                req.setCharacterEncoding("UTF-8");
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html");
                OrderTour orderTour = OrderTourDAO.getOrderTourById(Integer.parseInt(orderTourId));
                Transaction paymentAPIResult = getTransactionFromPaymentAPI(req, resp);
                if (paymentAPIResult != null && paymentAPIResult.getTransactionStatus().equals("Success")) {
//                    send mail
                    String email = CustomerDAO.getEmail(orderTour.getCustomerId());
                    MailService.sendNotifyPayment(email, orderTour);
//                    update insert transaction + order tour
                    TransactionDAO.insertTransaction(paymentAPIResult);
                    OrderTourDAO.updatePaymentTransactionId(orderTour.getId(), paymentAPIResult.getId());
//                    notify
                    resp.getWriter().write("Thanh toán thành công, chúng tôi đã gởi thông tin qua email!");
                } else {
                    resp.getWriter().write("Thanh toán thất bại, Vui lòng thử lại sau!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Transaction getTransactionFromPaymentAPI(HttpServletRequest req, HttpServletResponse resp) {
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

