package com.example.alex.graphics.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.alex.graphics.R;
import com.example.alex.graphics.model.Drawable;
import com.example.alex.graphics.model.Line;
import com.example.alex.graphics.model.Point;
import com.example.alex.graphics.model.Rectangle;
import com.example.alex.graphics.model.Trinagle;
import com.example.alex.graphics.until.Const;

public class MorfActivity extends AppCompatActivity {

    SeekBar seekBar;
    public static float progres=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morf);
        seekBar = findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.morf_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addLine:
                Const.morflist.clear();
                Const.morflist.add((new Line(new Point(172,142), new Point(749,319 ), Color.BLACK)));
                Const.morflist.add((new Line(new Point(199,781), new Point(935,1313 ), Color.BLACK)));
                break;
            case R.id.addTriangle:
                Const.morflist.clear();
                Const.morflist.add(new Trinagle(500, 1000, Color.BLACK));
                Const.morflist.add(new Trinagle(100, 1500, Color.BLACK));
                break;
            case R.id.addRectangle:
                Const.morflist.clear();
                Const.morflist.add(new Rectangle(500, 1000, Color.BLACK));
                Const.morflist.add(new Rectangle(500, 1000, Color.BLACK));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            progres=progress/100f;
            Log.d("seek",String.valueOf(progress/100f));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
