package com.danosipov.testdemo;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    private TemperatureEditText celsiusField;
    private TemperatureEditText fahrenheitField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusField = (TemperatureEditText) findViewById(R.id.celsius);
        celsiusField.setSuffix("\u00B0C");
        fahrenheitField = (TemperatureEditText) findViewById(R.id.fahrenheit);
        fahrenheitField.setSuffix("\u00B0F");

        celsiusField.addTextChangedListener(
                new TemperatureWatcher(celsiusField, fahrenheitField, new FahrenheitConverter()));

        fahrenheitField.addTextChangedListener(
                new TemperatureWatcher(fahrenheitField, celsiusField, new CelsiusConverter()));
    }
}
