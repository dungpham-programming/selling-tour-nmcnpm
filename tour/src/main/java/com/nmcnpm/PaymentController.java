package com.nmcnpm;

import com.nmcnpm.dao.CustomerDAO;
import com.nmcnpm.dao.OrderTourDAO;
import com.nmcnpm.dao.TransactionDAO;
import com.nmcnpm.model.OrderTour;
import com.nmcnpm.model.Transaction;
import com.nmcnpm.service.MailService;
import com.nmcnpm.service.PaymentAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
//                notify: giả sử API gọi đươc kết quả
                Transaction paymentAPIResult = PaymentAPI.getTransactionFromPaymentAPI(req, resp);
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
}

