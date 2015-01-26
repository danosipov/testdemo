package com.danosipov.testdemo.test;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.danosipov.testdemo.MainActivity;
import com.danosipov.testdemo.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@Config(emulateSdk = 18, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void launchedActivity_shouldNotBeNull() throws Exception {
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        assertThat(activity, notNullValue());
    }
}