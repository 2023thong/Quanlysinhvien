package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity2 extends AppCompatActivity {
    Spinner spnclass;
    ClassManagerDAO clsDao =  null;//new ClassManagerDAO();
    studentDAO stDAO = null;
    EditText edmasinhvien,edTensinhvien,eddienthoai;
    List<ClassManager> lsClass = new ArrayList<>();
    String stridClass = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2);
        edmasinhvien = (EditText) findViewById(R.id.edmasinhvien);
        edTensinhvien = (EditText) findViewById(R.id.edTensinhvien);
        eddienthoai = (EditText) findViewById(R.id.eddienthoai);
        spnclass = (Spinner) findViewById(R.id.spnclass);
        getclassRoos();
        spnclass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stridClass =  lsClass.get(spnclass.getSelectedItemPosition()).getId();
                Toast.makeText(getApplicationContext(),stridClass,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void save(View view){
        stDAO = new studentDAO(StudentActivity2.this);
        student2 st = new student2();
        st.setId(edmasinhvien.getText().toString());
        st.setName(edTensinhvien.getText().toString());
        st.setPhone(eddienthoai.getText().toString());
        st.setIdclass(stridClass);
        try {
            if (stDAO.add(st)>0){
                Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_SHORT).show();

            }
        }
        catch (Exception e){
            Log.e("Error",e.toString());
        }
    }
    public void getclassRoos(){
        clsDao = new ClassManagerDAO(StudentActivity2.this);
        lsClass = clsDao.getAll();
        ArrayAdapter<ClassManager> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, clsDao.getAll());
        spnclass.setAdapter(adapter);
    }
}