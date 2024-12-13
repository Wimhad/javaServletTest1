package com.web.test.controller;

import com.web.test.model.SportsInventory;
import com.web.test.repository.SportsInventoryRepository;
import com.web.test.service.SportsInventoryService;
import com.web.test.util.DatabaseUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/sports/details")
public class SportsDetailsServlet extends HttpServlet {
    private SportsInventoryService service;

    @Override
    public void init() throws ServletException {
        Connection connection = null;
        try {
            connection = DatabaseUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        service = new SportsInventoryService(new SportsInventoryRepository(connection));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            SportsInventory item = service.getSportById(id);
            req.setAttribute("item", item);
            req.getRequestDispatcher("/WEB-INF/views/sports-details.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

