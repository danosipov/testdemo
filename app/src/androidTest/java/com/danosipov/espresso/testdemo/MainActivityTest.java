package com.danosipov.espresso.testdemo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.danosipov.testdemo.MainActivity;
import com.danosipov.testdemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Espresso Integration test
 */
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testFahrenheitToCelsius() {
        onView(withId(R.id.fahrenheit)).perform(typeText("32"));
        onView(withId(R.id.celsius)).check(matches(withText("0.0")));
    }

    public void testCelsiusToFahrenheit() {
        onView(withId(R.id.celsius)).perform(typeText("232.778"));
        onView(withId(R.id.fahrenheit)).check(matches(withText("451.0")));
    }
}
