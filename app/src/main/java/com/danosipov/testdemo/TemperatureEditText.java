package com.danosipov.testdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Custom view to simplify rendering
 * Adapted from https://gist.github.com/kennydude/5407963
 */
public class TemperatureEditText extends EditText {
    TextPaint paint = new TextPaint();
    String suffix = "";
    Rect bounds = new Rect();

    public TemperatureEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setColor(getCurrentHintTextColor());
        paint.setTextSize(getTextSize());
        paint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        if (paint != null) {
            paint.setTypeface(typeface);
        }

        postInvalidate();
    }

    public void setSuffix(String s) {
        suffix = s;
    }

    @Override
    public void onDraw(Canvas c) {
        int baseline = getLineBounds(0, bounds);
        super.onDraw(c);

        int suffixOffset = (int) paint.measureText(getText().toString()) + getPaddingLeft();
        c.drawText(suffix, suffixOffset, baseline, paint);
    }
}
