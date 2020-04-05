package com.example.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        age = findViewById(R.id.edit2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences SharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = SharedPreferences.edit();
        myEdit.putString("name",name.getText().toString());
        myEdit.putString("age",age.getText().toString());
        myEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        @SuppressLint("WrongConstant") SharedPreferences sh = getSharedPreferences("MySharedPref",MODE_APPEND);
        String S1 = sh.getString("name", "");
        int a = sh.getInt("age",0);
        name.setText(S1);
        age.setText(String.valueOf(a));
    }
}