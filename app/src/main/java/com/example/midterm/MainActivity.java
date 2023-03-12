package com.example.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> openCalculator());

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(view -> openTo_Do());
    }
    public void openCalculator() {
        Intent intent = new Intent(this,Calculator.class);
        startActivity(intent);
    }

    public void openTo_Do() {
        Intent intent = new Intent(this,To_Do.class);
        startActivity(intent);
    }
}