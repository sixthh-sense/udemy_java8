package com.acme.domain;

public class Solid extends Good{

    private double width;
    private double length;

    // getter & setter
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // constructor
    public Solid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUoM, double width, double length) {
        super(name, modelNumber, height, uoM, flammable, wgtPerUoM);
        this.width = width;
        this.length = length;
    }

    public double volume() {
        return width * length * getHeight();
    }

    public String toString() {
        return super.toString() + " that is " + volume() + " " + getUnitOfMeasure() + " in size";
    }
}
