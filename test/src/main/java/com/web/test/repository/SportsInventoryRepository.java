package com.web.test.repository;

import com.web.test.model.SportsInventory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SportsInventoryRepository {
    private Connection connection;

    public SportsInventoryRepository(Connection connection) {
        this.connection = connection;
    }

    public List<SportsInventory> findAll() throws SQLException {
        List<SportsInventory> inventory = new ArrayList<>();
        String query = "SELECT * FROM sports_inventory";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                SportsInventory item = new SportsInventory();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setParameters(rs.getString("parameters"));
                item.setAgeLimit(rs.getInt("age_limit"));
                item.setPlacementConditions(rs.getString("placement_conditions"));
                inventory.add(item);
            }
        }
        return inventory;
    }

    public SportsInventory findById(int id) throws SQLException {
        String query = "SELECT * FROM sports_inventory WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    SportsInventory item = new SportsInventory();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setParameters(rs.getString("parameters"));
                    item.setAgeLimit(rs.getInt("age_limit"));
                    item.setPlacementConditions(rs.getString("placement_conditions"));
                    return item;
                }
            }
        }
        return null;
    }
}

