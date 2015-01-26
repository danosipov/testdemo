package com.danosipov.testdemo;

/**
 * Simple converter to fahrenheit.
 * Could be an inner class
 */
public class FahrenheitConverter implements TemperatureConverter {
    @Override
    public double convert(double temperature) {
        return (temperature * 1.8) + 32;
    }
}
