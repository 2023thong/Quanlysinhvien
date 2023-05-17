package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity {
    EditText ednhapten , ednhapmatkhau;
    Button btndangnhap , btnsualai;
    CheckBox chkpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ednhapten = (EditText) findViewById(R.id.ednhapten);
        ednhapmatkhau = (EditText) findViewById(R.id.ednhapmatkhau);
        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        btnsualai = (Button) findViewById(R.id.btnsualai);
        chkpass = (CheckBox) findViewById(R.id.chkpass);
    }
    public void dangnhap(View view) {
        String u = ednhapten.getText().toString();
        String p = ednhapmatkhau.getText().toString();
        if (u.equals("PHAM DINH THONG") && p.equals("2003")) {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            remeUser(u,p,chkpass.isChecked());
//            Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
//            intent.putExtra("Xin chào",u);
//            startActivity(intent);
            finish();

        }
//        else if (u.equals("admin") && p.equals("123")){
//            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//            remeUser(u,p,chkpass.isChecked());
//            finish();
//
//        }
        else{
            Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
        }

    }
    public void reset(View view){
        ednhapten.setText("");
        ednhapmatkhau.setText("");
    }
    public void remeUser(String username, String pass , boolean status){
        SharedPreferences sharedPreferences = getSharedPreferences("TAIKHOAN_FILE",MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!status){
            editor.clear();
        }
        else{
            editor.putString("USERNAME",username);
            editor.putString("PASSWORD",pass);
            editor.putBoolean("REMEMBER", status);
        }
        editor.commit();
    }
}