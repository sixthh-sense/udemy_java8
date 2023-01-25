package com.acme.utils;

import java.math.BigDecimal;

public class ConversionService {
    /**
     *  weight conversion rates
     * */
    public static BigDecimal kilogramToPounds = new BigDecimal("2.2046"); // double to BigDecimal
    public static BigDecimal kilogramToGrams = new BigDecimal(1000); // int to BigDecimal
    public static BigDecimal kilogramToOunces = new BigDecimal("35.274"); // double to BigDecimal

    /**
     *  volume conversion rates
     */
    public static float literToFluidOunce = 33.814f;
    public static float literToGallon = 0.2642f;
    public static float literToPints = 2.1134f;
    public static short literToMilliliters = 1_000;

    public static BigDecimal pounds(BigDecimal kilograms) {
        return kilograms.multiply(kilogramToPounds);
    }
    public static BigDecimal grams(BigDecimal kilograms) {
        return kilograms.multiply(kilogramToGrams);
    }
    public static BigDecimal ounces(BigDecimal kilograms) {
        return kilograms.multiply(kilogramToOunces);
    }
    public static float fluidOunces(float liters) {
        return liters * literToFluidOunce;
    }

    public static float gallons(float liters) {
        return liters * literToGallon;
    }
    public static float pints(float liters) {
        return liters * literToPints;
    }
    public static int milliliters(int liters) {
        return liters * literToMilliliters;
    }



    /*
    public static boolean fluidOunces(float v) {
        return false;
    }

    public static boolean gallons(float v) {
        return false;
    }

    public static boolean grams(int i) {
        return false;
    }

    public static boolean milliliters(int i) {
        return false;
    }

    public static boolean ounces(int i) {
        return false;
    }

    public static boolean pints(float v) {
        return false;
    }

    public static boolean pounds(double v) {
        return false;
    }
     */
}