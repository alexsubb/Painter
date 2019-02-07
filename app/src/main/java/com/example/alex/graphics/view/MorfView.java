package com.example.alex.graphics.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.alex.graphics.activity.MorfActivity;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.until.Const;
import java.util.LinkedList;


public class MorfView extends View {
    private Paint paint = new Paint();
    LinkedList<DrawView> list = new LinkedList<>();
    public MorfView(Context context, AttributeSet attrs) {
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
        for(Drawable d : Const.morflist){
            paint.setColor(d.getColor());
            d.draw(canvas,paint);
        }
        if(Const.morflist.size() ==2){
            paint.setColor(Color.RED);
            Const.morflist.get(0).morf(MorfActivity.progres,Const.morflist.get(1)).draw(canvas,paint);
        }
    }
}
