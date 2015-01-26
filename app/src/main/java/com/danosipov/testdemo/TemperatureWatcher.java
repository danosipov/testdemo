package com.danosipov.testdemo;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Text Watcher for temperature EditText fields
 */
public class TemperatureWatcher implements TextWatcher {
    private static final NumberFormat formatter = new DecimalFormat("#0.0");
    private EditText thisField; // The field we're watching
    private EditText thatField; // The field we want to update
    private TemperatureConverter converter; // Object that does the temperature conversion

    public TemperatureWatcher(EditText thisField, EditText thatField, TemperatureConverter converter) {
        this.thisField = thisField;
        this.thatField = thatField;
        this.converter = converter;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Not needed
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (thisField.hasFocus()) {
            double thisTemperature = Double.valueOf(thisField.getText().toString());
            double thatTemperature = converter.convert(thisTemperature);
            thatField.setText(format(thatTemperature));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Not needed
    }

    private String format(double temperature) {
        return formatter.format(temperature);
    }
}
