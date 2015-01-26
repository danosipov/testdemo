package com.danosipov.testdemo.test;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.danosipov.testdemo.TemperatureEditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowCanvas;

import static org.mockito.Mockito.*;

/**
 * Test for the custom view
 */
@Config(emulateSdk = 18, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class TemperatureEditTextTest {
    @Test
    public void shouldShowEditTextFieldWithSuffix() throws Exception {
        TemperatureEditText field = new TemperatureEditText(Robolectric.application, null);
        field.setSuffix(".test");
        field.setText("My Text");
        Canvas c = mock(Canvas.class);

        field.onDraw(c);

        verify(c).drawText(eq(".test"), anyFloat(), eq(0.0f), any(Paint.class));
    }
}
