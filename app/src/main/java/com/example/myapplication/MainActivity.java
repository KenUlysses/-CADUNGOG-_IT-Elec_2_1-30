package com.example.myapplication;

import static android.util.Log.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String TAG = new String();
        v(TAG, "This is a verbose log,");
        d(TAG, "This is a debug log,");
        i(TAG, "This is a info log,");
        w(TAG, "This is a warn log,");
        e(TAG, "This is a error log,");

        Button button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                i(TAG, "Button Clicked");

                Intent intent = new Intent(MainActivity.this, MyList.class);
                startActivity(intent);
            }

        });
         Button b = (Button) findViewById(R.id.button5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i(TAG, "Button Clicked");

                Intent intent = new Intent(MainActivity.this, Third.class);
                startActivity(intent);
            }
        });
    }
}