package com.danosipov.testdemo;

/**
 * Simple converter to celsius.
 * Could be an inner class
 */
public class CelsiusConverter implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        return (temperature - 32) / 1.8;
    }
}
