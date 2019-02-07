package com.example.alex.graphics.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.alex.graphics.R;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.until.Const;

public class OperationActivity extends AppCompatActivity {

    TextView textA;
    TextView textB;
    TextView textC;
    TextView textD;
    TextView textP;
    TextView textQ;
    TextView textM;
    TextView textN;
    TextView textS;

    Button make;
    Button local;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        inicialisation();

        local.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double a = Double.parseDouble(textA.getText().toString());
                        double b = Double.parseDouble(textB.getText().toString());
                        double c = Double.parseDouble(textC.getText().toString());
                        double d = Double.parseDouble(textD.getText().toString());
                        double p = Double.parseDouble(textP.getText().toString());
                        double q = Double.parseDouble(textQ.getText().toString());
                        double m = Double.parseDouble(textM.getText().toString());
                        double n = Double.parseDouble(textN.getText().toString());
                        double s = Double.parseDouble(textS.getText().toString());
                        for (Drawable drawable: Const.list) {
                            if (drawable.isChoose()) {
                                drawable.localOperation(a, b, c, d, p, q, m, n, s);
                            }
                        }
                    }
                }
        );

        make.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        double a = Double.parseDouble(textA.getText().toString());
                        double b = Double.parseDouble(textB.getText().toString());
                        double c = Double.parseDouble(textC.getText().toString());
                        double d = Double.parseDouble(textD.getText().toString());
                        double p = Double.parseDouble(textP.getText().toString());
                        double q = Double.parseDouble(textQ.getText().toString());
                        double m = Double.parseDouble(textM.getText().toString());
                        double n = Double.parseDouble(textN.getText().toString());
                        double s = Double.parseDouble(textS.getText().toString());
                        for (Drawable drawable: Const.list){
                            if(drawable.isChoose()){
                                drawable.operation(a,b,c,d,p,q,m,n,s);
                            }
                        }
                        Intent appIntent = new Intent(OperationActivity.this,AppActivity.class);
                        startActivity(appIntent);
                    }
                }
        );
    }

    private void inicialisation(){
        textA = findViewById(R.id.aText);
        textB = findViewById(R.id.bText);
        textC = findViewById(R.id.cText);
        textD = findViewById(R.id.dText);
        textP = findViewById(R.id.pText);
        textQ = findViewById(R.id.qText);
        textM = findViewById(R.id.mText);
        textN = findViewById(R.id.nText);
        textS = findViewById(R.id.sText);
        make = findViewById(R.id.makeButton);
        local = findViewById(R.id.localButton);
    }
}
