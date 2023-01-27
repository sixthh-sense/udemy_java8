package com.acme.domain;

public class Service implements Product {
    // fields
    private String name;
    private int estimatedTaskDuration;
    private boolean timeAndMaterials;

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedTaskDuration() {
        return estimatedTaskDuration;
    }

    public void setEstimatedTaskDuration(int estimatedTaskDuration) {
        this.estimatedTaskDuration = estimatedTaskDuration;
    }

    public boolean isTimeAndMaterials() {
        return timeAndMaterials;
    }

    public void setTimeAndMaterials(boolean timeAndMaterials) {
        this.timeAndMaterials = timeAndMaterials;
    }

    // constructor
    public Service(String n, int dur, boolean tAndM) {
        this.estimatedTaskDuration = dur;
        this.name = n;
        this.timeAndMaterials = tAndM;
    }

    public String toString() {
        return name + " (a " + estimatedTaskDuration + " day service)";
    }
}
