package com.example.alex.graphics.model;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface Drawable {
    void draw(Canvas canvas, Paint p);
    boolean isNearTouch(Point touch, float rad);
    void shift(Point delta);
    void setChoose(boolean choose);
    boolean isChoose();
    void globalScale(boolean zoom);
    void globalRotate(boolean rotate);
    void localSacle(boolean zoom);
    void localRotate(boolean rotate);
    void localOperation(double a,double b,double c,double d, double p,double q,double m,double n, double s);
    int getId();
    void setId(int id);
    int getColor();
    void touch(Point touch);
    void operation(double a,double b,double c,double d, double p,double q,double m,double n, double s);
    Drawable morf(double t, Drawable d);
}
