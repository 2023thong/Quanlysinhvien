package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClass, btnstudent;
    Intent intent = null;
    String strUsername = "";
    TextView tvusername;
    EditText ednhapten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClass = (Button) findViewById(R.id.btnClass);
        btnstudent = (Button) findViewById(R.id.btnstudent);
        tvusername = (TextView) findViewById(R.id.tvusername);
        ednhapten = (EditText) findViewById(R.id.ednhapten);

        if (checkLoginRemember() < 0) {//!checkLoginRemember
            intent = new Intent(MainActivity.this, LoginActivity2.class);
            startActivity(intent);
        }
//        Intent intent = new Intent(MainActivity.this,LoginActivity2.class);
//        startActivity(intent);
    }

    public void click_class(View view) {
        intent = new Intent(MainActivity.this, ClassActivity2.class);
        startActivity(intent);

    }

    public void click_classsinhvien(View view) {
        intent = new Intent(MainActivity.this, StudentActivity2.class);
        startActivity(intent);

    }

    public int checkLoginRemember() {
        SharedPreferences sharedPreferences = getSharedPreferences("TAIKHOAN_FILE", MODE_PRIVATE);
        boolean chk = sharedPreferences.getBoolean("REMEMBER", false);
        if (chk) {
            strUsername = sharedPreferences.getString("USERNAME", "");
            tvusername.setText("xin chào: " + strUsername);
            return 1;
        }
        return -1;

    }

    public int helo() {
        String t = ednhapten.getText().toString();
        tvusername.setText("xin Chào " + t);
        return 1;


    }
}