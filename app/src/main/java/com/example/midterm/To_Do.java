package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class To_Do extends AppCompatActivity {

    List<String> todolist;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        todolist = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_lay,todolist);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                todolist.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });



        editText = findViewById(R.id.id_edit_text);
    }
    public void add_item_list(View view){
        todolist.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");

        closeKeyboard();
    }
    private void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}