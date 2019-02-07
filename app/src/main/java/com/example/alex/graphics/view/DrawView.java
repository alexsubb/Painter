package com.example.alex.graphics.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.alex.graphics.activity.AppActivity;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.model.Point;
import com.example.alex.graphics.until.Const;


public class DrawView extends View {
    private Point touch;
    private Point currentPoint;
    private Paint paint = new Paint();
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawFigure(canvas);
        invalidate();
    }


    public void drawFigure(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);
        paint.setShadowLayer(4, 2, 2, 0x80000000);


        if (Const.list.size() != 0) {
            for (Drawable d : Const.list) {
                if (touch != null)
                    if (d.isChoose()) {
                        paint.setColor(Color.RED);
                    } else {
                                paint.setColor(d.getColor());
                        }
                    d.draw(canvas, paint);
                    }
            }
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                int id =0;
                currentPoint = new Point(event.getX(), event.getY());
                touch = new Point(event.getX(), event.getY());
                if(!AppActivity.checkGroops()) {
                    for (Drawable d : Const.list) {
                        d.setChoose(false);
                    }
                    for (Drawable d : Const.list) {
                        if (touch != null)
                            if (d.isNearTouch(touch, 20)) {
                                id = d.getId();
                                break;
                            }
                    }
                    Const.setActive(id);
                }
                for (Drawable d : Const.list) {
                    if (touch != null)
                        if (d.isNearTouch(touch, 20)) {
                            d.setChoose(true);
                            if (AppActivity.checkGroops())
                            break;
                        }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                AppActivity.kText.setText("x: "+ Math.round(event.getX())+" y: "+ Math.round(event.getY()));
                if(AppActivity.checkMove()){
                    Point finishPoint = new Point(event.getX(), event.getY());
                    Point delta = new Point(finishPoint.getX() - currentPoint.getX(),
                            finishPoint.getY() - currentPoint.getY());
                    currentPoint = new Point(finishPoint);
                for (Drawable d : Const.list) {
                    if (d.isChoose()) {
                        d.shift(delta);
                    }
                }}
                else {
                    for (Drawable d : Const.list) {
                        if (d.isChoose()) {
                            d.touch(new Point(event.getX(), event.getY()));
                        }
                    }
                }
                break;
        }
        invalidate();
        return true;

    }

}
