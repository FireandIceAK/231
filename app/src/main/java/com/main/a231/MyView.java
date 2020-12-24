package com.main.a231;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.nfc.Tag;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Point;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context) {
        super(context);
    }
    //Point[] points = new Point[50];
    List<Point> points=new ArrayList<Point>();
    int cellSize = 30;
    int width;
    int height;
    int countPoints;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();
        drawGrid(canvas);
        drawPoints(canvas);
    }
    public void drawGrid(Canvas canvas) {
        Paint paint = new Paint();
        DashPathEffect effect = new DashPathEffect(new float[] {3,9}, 0);
        paint.setPathEffect(effect);

        for (int i = 0; i < width/cellSize; i++) {
            int x = i * cellSize;
            canvas.drawLine(x, 0, x, height, paint);
            paint.setColor(Color.parseColor("black"));
        }
        for (int i = 0; i < height/cellSize; i++) {
            int y = i * cellSize;
            canvas.drawLine(0, y, width, y, paint);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            downTouch(event.getX(),event.getY());
        }
        return true;
    }
    public void downTouch(float x,float y){
        points.add(new Point((int)x,(int)y));
        invalidate();
    }

    public void drawPoints(Canvas canvas){
        Paint paint=new Paint();
        for(int i = 0;i<points.size(); i++){
            Point point= points.get(i);
            canvas.drawCircle(point.x,point.y,5,paint);
        }
    }

}


