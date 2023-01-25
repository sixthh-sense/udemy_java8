package com.acme.utils;

public class MyDate {
    public int day;
    public int year;
    public int month;

    { // for bonus lab
        day = 1;
        month = 1;
        year = 2001;
    }

    public MyDate() {}

    public MyDate(int m, int d, int y) {
        setDate(m, d, y);
    }

    public void setDate(int m, int d, int y) {
        this.month = m;
        this.day = d;
        this.year = y;
    }

    public String toString() { // strictly, i'd have to care about putting 01 rather than 1
        return this.day + "/" + this.month + "/" + this.year;
    }

    // lab 6 :: list all leap years between 1752(1st modern leap year) and 2020
    public static void leapYears() {
        for (int year = 1752; year <= 2020; year += 4) {
            if (year % 400 == 0 || year % 100 != 0) {
                System.out.println("The year " + year + " is a leap year");
            }
        }
    }
}
