package com.danosipov.testdemo.test;

import android.app.Activity;

import com.danosipov.testdemo.MainActivity;
import com.danosipov.testdemo.R;
import com.danosipov.testdemo.TemperatureEditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Config(emulateSdk = 18, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    Activity activity;
    TemperatureEditText fahrenheitField;
    TemperatureEditText celsiusField;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        fahrenheitField = (TemperatureEditText) activity.findViewById(R.id.fahrenheit);
        celsiusField = (TemperatureEditText) activity.findViewById(R.id.celsius);
    }

    @Test
    public void launchedActivity_shouldNotBeNull() throws Exception {
        assertThat(activity, notNullValue());
    }

    @Test
    public void textInFahrenheit_shouldBeConvertedToCelsius() throws Exception {
        fahrenheitField.requestFocusFromTouch();
        fahrenheitField.setText("32");

        assertEquals("0.0", celsiusField.getText().toString());
    }

    @Test
    public void textInCelsius_shouldBeConvertedToFahrenheit() throws Exception {
        celsiusField.requestFocusFromTouch();
        celsiusField.setText("0");

        assertEquals("32.0", fahrenheitField.getText().toString());
    }

    @Test
    public void negativeTemperatureInCelsius_shouldBeConvertedToFahrenheit() throws Exception {
        celsiusField.requestFocusFromTouch();
        celsiusField.setText("-50");

        assertEquals("-58.0", fahrenheitField.getText().toString());
    }

    @Test
    public void negativeTemperatureInFahrenheit_shouldBeConvertedToCelsius() throws Exception {
        fahrenheitField.requestFocusFromTouch();
        fahrenheitField.setText("-32");

        assertEquals("-35.6", celsiusField.getText().toString());
    }

    @Test
    public void backAndForthConversions_shouldYieldCorrectValues() throws Exception {
        fahrenheitField.requestFocusFromTouch();
        fahrenheitField.setText("0");
        celsiusField.requestFocusFromTouch();
        celsiusField.setText("100");

        assertEquals("212.0", fahrenheitField.getText().toString());
        assertEquals("100", celsiusField.getText().toString());
    }

    @Test
    public void entryWithoutFocus_shouldResultInNoChange() throws Exception {
        fahrenheitField.requestFocusFromTouch();
        fahrenheitField.setText("50");
        celsiusField.setText("100");

        assertEquals("50", fahrenheitField.getText().toString());
    }
}