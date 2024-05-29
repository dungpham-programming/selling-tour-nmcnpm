package com.nmcnpm.payment.controller;

import com.nmcnpm.payment.dao.OrderTourDAO;
import com.nmcnpm.payment.model.OrderTour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/to-payment-page")
public class BeforePaymentController extends HttpServlet {
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
                req.setAttribute("timer", 5*60);
                req.getRequestDispatcher("./payment.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("./beforePayment.jsp");
        }
    }
}

