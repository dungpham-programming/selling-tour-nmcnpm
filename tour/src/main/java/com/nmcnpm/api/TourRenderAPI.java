package com.nmcnpm.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nmcnpm.model.Tour;
import com.nmcnpm.service.impl.TourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/api/tour"})
public class TourRenderAPI extends HttpServlet {
    private final TourService tourService = new TourService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tour> tours = tourService.getAll();
        Gson gson = new GsonBuilder().serializeNulls().create();
        String responseJson = gson.toJson(tours);

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(responseJson);
    }
}
