package com.example.alex.graphics.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alex.graphics.R;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.model.Line;
import com.example.alex.graphics.model.Point;
import com.example.alex.graphics.model.Rectangle;
import com.example.alex.graphics.model.Trinagle;
import com.example.alex.graphics.until.Const;

public class EditActivity extends AppCompatActivity {

    TextView x1;
    TextView x2;
    TextView x3;
    TextView x4;
    TextView y1;
    TextView y2;
    TextView y3;
    TextView y4;

    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        inicialisation();
        edit = findViewById(R.id.editButton);
        clickOnButton();
    }

    private void clickOnButton(){
        edit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (Drawable drawable : Const.list){
                            if(drawable.isChoose()){
                                if(drawable instanceof Line){
                                    Point p1 = new Point(Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()));
                                    Point p2 = new Point(Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()));
                                    ((Line) drawable).setP1(p1);
                                    ((Line) drawable).setP2(p2);
                                }
                                if(drawable instanceof Trinagle){
                                    Point p1 = new Point(Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()));
                                    Point p2 = new Point(Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()));
                                    Point p3 = new Point(Double.parseDouble(x3.getText().toString()),Double.parseDouble(y3.getText().toString()));
                                    ((Trinagle) drawable).setP1(p1);
                                    ((Trinagle) drawable).setP2(p2);
                                    ((Trinagle) drawable).setP3(p3);
                                }
                                if(drawable instanceof Rectangle){
                                    Point p1 = new Point(Double.parseDouble(x1.getText().toString()),Double.parseDouble(y1.getText().toString()));
                                    Point p2 = new Point(Double.parseDouble(x2.getText().toString()),Double.parseDouble(y2.getText().toString()));
                                    Point p3 = new Point(Double.parseDouble(x3.getText().toString()),Double.parseDouble(y3.getText().toString()));
                                    Point p4 = new Point(Double.parseDouble(x4.getText().toString()),Double.parseDouble(y4.getText().toString()));
                                    ((Rectangle) drawable).setP1(p1);
                                    ((Rectangle) drawable).setP2(p2);
                                    ((Rectangle) drawable).setP3(p3);
                                    ((Rectangle) drawable).setP4(p4);
                                }
                                break;
                            }
                        }
                        Intent intent = new Intent(EditActivity.this,AppActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    private void inicialisation(){
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);
        y1 = findViewById(R.id.y1);
        y2 = findViewById(R.id.y2);
        y3 = findViewById(R.id.y3);
        y4 = findViewById(R.id.y4);
        for (Drawable drawable : Const.list){
            if(drawable.isChoose()){
               if(drawable instanceof Line){
                   x1.setText(String.valueOf(((Line)drawable).getP1().getX()));
                   y1.setText(String.valueOf(((Line)drawable).getP1().getY()));
                   x2.setText(String.valueOf(((Line)drawable).getP2().getX()));
                   y2.setText(String.valueOf(((Line)drawable).getP2().getY()));
                   x3.setText("-");
                   y3.setText("-");
                   x4.setText("-");
                   y4.setText("-");
               }
                if(drawable instanceof Trinagle){
                    x1.setText(String.valueOf(((Trinagle)drawable).getP1().getX()));
                    y1.setText(String.valueOf(((Trinagle)drawable).getP1().getY()));
                    x2.setText(String.valueOf(((Trinagle)drawable).getP2().getX()));
                    y2.setText(String.valueOf(((Trinagle)drawable).getP2().getY()));
                    x3.setText(String.valueOf(((Trinagle)drawable).getP3().getX()));
                    y3.setText(String.valueOf(((Trinagle)drawable).getP3().getY()));
                    x4.setText("-");
                    y4.setText("-");
                }
                if(drawable instanceof Rectangle){
                    x1.setText(String.valueOf(((Rectangle)drawable).getP1().getX()));
                    y1.setText(String.valueOf(((Rectangle)drawable).getP1().getY()));
                    x2.setText(String.valueOf(((Rectangle)drawable).getP2().getX()));
                    y2.setText(String.valueOf(((Rectangle)drawable).getP2().getY()));
                    x3.setText(String.valueOf(((Rectangle)drawable).getP3().getX()));
                    y3.setText(String.valueOf(((Rectangle)drawable).getP3().getY()));
                    x4.setText(String.valueOf(((Rectangle)drawable).getP4().getY()));
                    y4.setText(String.valueOf(((Rectangle)drawable).getP4().getY()));
                }
                break;
            }
        }
    }
}
