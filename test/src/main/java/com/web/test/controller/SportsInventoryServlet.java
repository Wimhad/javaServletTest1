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
import java.util.List;

@WebServlet("/sports")
public class SportsInventoryServlet extends HttpServlet {
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
        try {
            List<SportsInventory> inventory = service.getAllSports();
            req.setAttribute("inventory", inventory);
            req.getRequestDispatcher("/WEB-INF/views/sports-list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
