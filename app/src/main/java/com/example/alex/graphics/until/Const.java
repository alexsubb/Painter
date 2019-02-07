package com.example.alex.graphics.until;

import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.view.DrawView;

import java.util.LinkedList;


public class Const {
    public static final double scale = 0.01;
    public static final double angle = 10. / 360.;
    public static LinkedList<Drawable> list = new LinkedList<>();
    public static LinkedList<LinkedList<Drawable>> cadr =new LinkedList<>();
    public static int id = 0;
    public static int isTouch=0;
    public static LinkedList<Drawable> morflist = new LinkedList<>();
    public static void setActive(int id){
        for (Drawable drawable : list){
            if(drawable.getId() != 0 && drawable.getId() == id){
                drawable.setChoose(true);
            }
        }
    }
    public static void makeCadr(){
        cadr.add(new LinkedList<Drawable>());
        for (Drawable drawable : list)
        {
            cadr.getLast().add(drawable);
        }
    }
    }

