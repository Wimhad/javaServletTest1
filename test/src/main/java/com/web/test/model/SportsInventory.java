package com.web.test.model;

public class SportsInventory {
    private int id;
    private String name;
    private String parameters;
    private int ageLimit;
    private String placementConditions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getPlacementConditions() {
        return placementConditions;
    }

    public void setPlacementConditions(String placementConditions) {
        this.placementConditions = placementConditions;
    }
}

