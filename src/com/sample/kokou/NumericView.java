package com.sample.kokou;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class NumericView extends TextView {
    private int count;

    public NumericView(Context context) {
        this(context, null, 0);
    }

    public NumericView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumericView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        count = 0;
    }

    public void up() { 
        count++;
        invalidate();
    }
    
    public void down() {
        count--;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setText(String.format("%05d", count));
    }
}
