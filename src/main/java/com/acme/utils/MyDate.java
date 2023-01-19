package com.acme.utils;

public class MyDate {
    int day;
    int year;
    int month;

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
}
