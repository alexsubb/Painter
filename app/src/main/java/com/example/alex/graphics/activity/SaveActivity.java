package com.example.alex.graphics.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.graphics.R;
import com.example.alex.graphics.database.DataBaseHelper;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.until.Const;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SaveActivity extends AppCompatActivity {

    TextView fileText;
    Button savel;
    String FILENAME = "";
    DataBaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        fileText = findViewById(R.id.fileName);
        savel = findViewById(R.id.saveButton);
        helper.getInstance(this);
        savel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FILENAME = fileText.getText().toString();
                        helper.add(FILENAME);
                        /*try {
                            // отрываем поток для записи
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                                    openFileOutput(FILENAME, MODE_PRIVATE)));
                            // пишем данные
                            String str="";
                            for (Drawable drawable : Const.list){
                               str = drawable.toString()+"\n";
                            }
                            bw.write(str);
                            // закрываем поток
                            bw.close();
                            helper.add(FILENAME);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                    }
                }
        );
    }
}
