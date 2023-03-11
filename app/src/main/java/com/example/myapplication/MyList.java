package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyList extends AppCompatActivity {

    String listItem [] ;
    android.widget.ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        listView = (ListView) findViewById(R.id.listView);
        listItem = getResources().getStringArray(R.array.list_Item);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_list_view,R.id.textView, listItem);
        listView.setAdapter(arrayAdapter);
    }
}