package com.acme.domain;

public class Car {
    String color;
    String type;

    int serialNumber;
    static int carCount;
    /*
    { // initialization block always comes before constructors
        carCount++;
        serialNumber = carCount;
    }
     */

    Car() {
        carCount++;
        serialNumber = carCount;
        // this("green", "convertible");
    }

    Car(String color, String type) {
        this(); // rather than Car(); this() has to be in the 1st line
        /*carCount++;
        serialNumber = carCount;*/
        this.color = color;
        this.type = type;
    }
    {
        this.color = "red";
        this.type = "Celica";
    }
    /*
    {
        Car myCar = new Car();
        myCar.customize("blue", "convertible");
    }
     */
    String getDescription() {
        String desc = "This is a " + this.color + " " + this.type;
        return desc; // may inline variable
    }

    // Customize Frame: newColor = blue, newType = convertible
    void customize(String color, String type) {
        this.color = color; // it's already been declared, so just 'color' (w/o type)
        this.type = type + " " + this.type; // what if things go like type = type? we have to know which is which so that's why we add "this."
        System.out.println(getDescription());
    }
}
