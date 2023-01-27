package com.acme.utils;

public class MyDate {

    private int day;
    private int year;
    private int month;

    /* for prior bonus lab
    {
        day = 1;
        month = 1;
        year = 2001;
    }
    */

    // getter & setter
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (valid(day, month, year)) {
            this.day = day;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (valid(day, month, year)) {
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (valid(day, month, year)) {
            this.month = month;
        }
    }

    public MyDate() {
        this(1, 1, 1900);
    }

    private boolean valid(int day, int month, int year) {
        if (day > 31 || day < 1 || month > 12 || month < 1) {
            System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
            return false;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11: return (day <= 30);
            case 2: return day <= 28 || (day == 29 && year % 4 == 0);
        }
        return true;
    }

    public MyDate(int m, int d, int y) {
        setDate(m, d, y);
    }

    public void setDate(int m, int d, int y) {
        if (valid(d, m, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        }
    }

    public String toString() { // strictly, i'd have to care about putting 01 rather than 1
        return this.month + "/" + this.day + "/" + this.year;
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
