package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class Calculator extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.textView2);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int curPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,curPos);
        String rightStr = oldStr.substring(curPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(curPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(curPos + 1);
        }

    }

    public void zero (View view){
        updateText("0");
    }
    public void one (View view){
        updateText("1");
    }
    public void two (View view){
        updateText("2");
    }
    public void three (View view){
        updateText("3");
    }
    public void four (View view){
        updateText("4");
    }
    public void five (View view){
        updateText("5");
    }
    public void six (View view){
        updateText("6");
    }
    public void seven (View view){
        updateText("7");
    }
    public void eight (View view){
        updateText("8");
    }
    public void nine (View view){
        updateText("9");
    }
    public void clear (View view){
        display.setText("");
    }
    public void pn (View view){
        updateText("-");
    }
    public void path (View view){
        int curPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < curPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar +=1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")) {
               closePar += 1;
            }
        }
        if (openPar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");

        }
        else if (closePar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals("(")) {
            updateText(")");

        }
        display.setSelection(curPos + 1);
    }
    public void back (View view){
        int curPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (curPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(curPos -1, curPos, "");
            display.setText(selection);
            display.setSelection(curPos - 1);
        }
    }
    public void div (View view){
        updateText("÷");
    }
    public void min (View view){
        updateText("-");
    }
    public void add (View view){
        updateText("+");
    }
    public void mul (View view){
        updateText("×");
    }
    public void dot (View view){
        updateText(".");
    }
    public void eq (View view){
        String userEnter = display.getText().toString();

        userEnter = userEnter.replaceAll("÷","/");
        userEnter = userEnter.replaceAll("×", "*");

        Expression exp = new Expression(userEnter);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void per (View view){
        updateText("%");
    }
}