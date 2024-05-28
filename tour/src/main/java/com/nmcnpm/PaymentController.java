package com.nmcnpm;

import com.nmcnpm.dao.OrderTourDAO;
import com.nmcnpm.model.OrderTour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    /*
        Tạo ngẫu nhiên order tour -> lưu ở session + giữ chỗ?
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
                OrderTour orderTour = OrderTourDAO.getOrderTourById(Integer.parseInt(orderTourId));
                req.setAttribute("orderTour", orderTour);
                System.out.println("okok: "+ orderTour);
                req.getRequestDispatcher("./payment.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            resp.sendRedirect("./payment.jsp");
        }
    }
}

