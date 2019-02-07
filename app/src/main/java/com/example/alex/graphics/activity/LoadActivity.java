package com.example.alex.graphics.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.graphics.R;
import com.example.alex.graphics.database.DataBaseHelper;

public class LoadActivity extends AppCompatActivity {

    private ListView listView;
    ArrayAdapter<String> adapter;
    DataBaseHelper helper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        listView = (ListView)findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, helper.allElement());
        helper= DataBaseHelper.getInstance(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                            }
                                        }
        );
    }
}
