package com.acme.utils;

public class MyDate {

    private byte day;
    private short year;
    private byte month;

    private static MyDate[] holidays;

    /* for prior bonus lab
    {
        day = 1;
        month = 1;
        year = 2001;
    }
    */
    // lab 14 :: step 1
    static {
        holidays = new MyDate[6];
        holidays[0] = new MyDate(1, 1, 2023);
        holidays[1] = new MyDate(5, 30, 2023);
        holidays[2] = new MyDate(7, 4, 2023);
        holidays[3] = new MyDate(9, 5, 2023);
        holidays[4] = new MyDate(11, 24, 2023);
        holidays[5] = new MyDate(12, 25, 2023);
    }

    // getter & setter
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (valid(day, month, year)) {
            this.day = (byte) day;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (valid(day, month, year)) {
            this.year = (short) year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (valid(day, month, year)) {
            this.month = (byte) month;
        }
    }

    public static MyDate[] getHolidays() { // no setter, just getter
        return holidays;
    }

    public static void listHolidays() {
        System.out.println("the holidays are: ");
        for (MyDate holiday : holidays) {
            System.out.println(holiday);
        }
    }

    // constructor
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
            case 11:
                return (day <= 30); // no need for break?
            case 2:
                return day <= 28 || (day == 29 && year % 4 == 0);
        }
        return true;
    }

    public MyDate(int m, int d, int y) {
        setDate(m, d, y);
    }

    public void setDate(int m, int d, int y) {
        if (valid(d, m, y)) {
            this.month = (byte) m;
            this.day = (byte) d;
            this.year = (short) y;
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

    public boolean equals(Object o) {
        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;
            return (d.day == day) && (d.month == month) && (d.year == year);
        }
        return false;
    }
}
