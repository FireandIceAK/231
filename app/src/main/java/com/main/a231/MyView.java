package com.main.a231;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context) {
        super(context);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int a = canvas.getWidth();
        int b = canvas.getHeight();

        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        canvas.drawLine(0, 0, 100, 200, paint);
    }
}
