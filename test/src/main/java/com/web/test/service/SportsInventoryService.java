package com.web.test.service;

import com.web.test.model.SportsInventory;
import com.web.test.repository.SportsInventoryRepository;

import java.sql.SQLException;
import java.util.List;

public class SportsInventoryService {
    private SportsInventoryRepository repository;

    public SportsInventoryService(SportsInventoryRepository repository) {
        this.repository = repository;
    }

    public List<SportsInventory> getAllSports() throws SQLException {
        return repository.findAll();
    }

    public SportsInventory getSportById(int id) throws SQLException {
        return repository.findById(id);
    }
}
