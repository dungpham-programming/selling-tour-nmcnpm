package com.nmcnpm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/tour"})
public class TourController extends HttpServlet {
    // Lớp này chỉ có trách nhiệm là load trang JSP lên
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/tour.jsp").forward(req, resp);
    }
}
