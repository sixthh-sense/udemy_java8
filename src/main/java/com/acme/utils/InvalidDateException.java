package com.acme.utils;

public class InvalidDateException extends Exception{
    private static final long serialVersionUID = 6165028722785664789L;
    public InvalidDateException(int month, int day, int year) {
       super("invalid date: " + month + " / " + day + " / " + year);
    }
}
