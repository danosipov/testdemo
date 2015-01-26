package com.danosipov.testdemo.test;

import android.widget.EditText;

import com.danosipov.testdemo.TemperatureConverter;
import com.danosipov.testdemo.TemperatureWatcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Test for the custom TextWatcher
 */
@Config(emulateSdk = 18, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class TemperatureWatcherTest {

    EditText field1;
    EditText field2;
    TemperatureWatcher watcher;

    @Test
    public void shouldUpdateEditTextOnChange() throws Exception {
        initEditText("2.0", "Test");
        watcher = new TemperatureWatcher(field1, field2, new TemperatureConverter() {
            @Override
            public double convert(double temperature) {
                return 0;
            }
        });
        watcher.onTextChanged("120", 0, 1, 3);

        assertEquals("0.0", field2.getText().toString());
    }

    @Test
    public void shouldInvokeTheConverterOnTextChange() throws Exception {
        initEditText("2.0", "Test");
        watcher = new TemperatureWatcher(field1, field2, new TemperatureConverter() {
            @Override
            public double convert(double temperature) {
                return temperature * 2;
            }
        });

        watcher.onTextChanged("120", 0, 1, 3);

        assertEquals("4.0", field2.getText().toString());
    }

    private void initEditText(String text1, String text2) {
        field1 = new EditText(Robolectric.application);
        field1.requestFocus();
        field1.setText(text1);
        field2 = new EditText(Robolectric.application);
        field2.setText(text2);
    }
}
