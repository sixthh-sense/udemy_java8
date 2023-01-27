package com.acme.domain;

public class Liquid extends  Good{

    private double radius;

    // getter & setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType uoM, boolean flammable, double wgtPerUoM, double radius) {
        super(name, modelNumber, height, uoM, flammable, wgtPerUoM);
        this.radius = radius;
    }

    public double volume() {
        return Math.PI * radius * radius * getHeight();
    }

    public String toString() {
        return super.toString() + " (liquid) " + volume() + " " + getUnitOfMeasure();
    }

//    public final boolean canShipViaPostOffice() { // 'canShipViaPostOffice()' cannot override 'canShipViaPostOffice()' in 'com.acme.domain.Good'; overridden method is final
//        return true;
//    }
}
