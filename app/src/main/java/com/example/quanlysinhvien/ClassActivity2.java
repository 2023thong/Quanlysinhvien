package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassActivity2 extends AppCompatActivity {
    Button btnAdd, btnCanler;
    EditText edid, edname;
    ClassManagerDAO dao;
    ListView lvclass;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2);
        edid = (EditText) findViewById(R.id.edmalop);
        edname = (EditText) findViewById(R.id.ededtenlop);
        btnAdd = (Button) findViewById(R.id.btnluu);
        btnCanler = (Button) findViewById(R.id.btnsualai);
        lvclass = (ListView) findViewById(R.id.lvclass);
        dao = new  ClassManagerDAO(ClassActivity2.this);
        adapter = new ArrayAdapter<ClassManager>(this, android.R.layout.simple_list_item_1,dao.getAll());
        lvclass.setAdapter(adapter);
        lvclass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassManager cls = dao.getAll().get(position);
                edid.setText(cls.getId());
                edname.setText(cls.getName());
            }
        });
    }
    public void resetfrom(View view){
        edid.setText("");
        edname.setText("");
    }
    public void save(View view){
        ClassManager cls = new ClassManager(edid.getText().toString(),edname.getText().toString());
        int rs = dao.add(cls);
        if (rs  > 0){
            Toast.makeText(getApplicationContext(),"Thêm thành công ",Toast.LENGTH_SHORT).show();
            adapter = new ArrayAdapter<ClassManager>(this, android.R.layout.simple_list_item_1,dao.getAll());
            lvclass.setAdapter(adapter);
            resetfrom(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Thêm thất bại ",Toast.LENGTH_SHORT).show();
        }

    }



    public  void updateclass(View view){
        ClassManager cls = new ClassManager(edid.getText().toString(),edname.getText().toString());
        int rs = dao.update(cls);
        if (rs >= 0){
            Toast.makeText(getApplicationContext(),"Sửa thành công ",Toast.LENGTH_SHORT).show();
            adapter = new ArrayAdapter<ClassManager>(this, android.R.layout.simple_list_item_1,dao.getAll());
            lvclass.setAdapter(adapter);
            resetfrom(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Không tìm thấy ",Toast.LENGTH_SHORT).show();
        }
    }
    public  void delclass(View view){
        int rs = dao.del(edid.getText().toString());
        if (rs >= 0){
            Toast.makeText(getApplicationContext(),"Del thành công ",Toast.LENGTH_SHORT).show();
            adapter = new ArrayAdapter<ClassManager>(this, android.R.layout.simple_list_item_1,dao.getAll());
            lvclass.setAdapter(adapter);
            resetfrom(view);
        }
        else{
            Toast.makeText(getApplicationContext(),"Không tìm thấy ",Toast.LENGTH_SHORT).show();
        }
    }

}