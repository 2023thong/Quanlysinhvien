package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quanlysinhvien.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ClassManagerDAO {
    private SQLiteDatabase db;
    public static List<ClassManager> lsclass = new ArrayList<>();

    public ClassManagerDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getReadableDatabase();

        //dumydata();8
    }

    public int add(ClassManager cls){
        //lsclass.add(cls);
        ContentValues values = new ContentValues();
        values.put("Malop",cls.getId());
        values.put("TenLop",cls.getName());
        try {
            if (db.insert("ClassRoos",null,values) == -1){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("ClassManagerDAO","//==="+e.toString());
        }
        return 1;
        }
    public List<ClassManager> getAll(){
        List<ClassManager> ls = new ArrayList<>();
        Cursor c = db.query("ClassRoos", null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            ClassManager cls = new ClassManager();
            cls.setId(c.getString(0));
            cls.setName(c.getString(1));
            ls.add(cls);
            c.moveToNext();
        }
        return ls;
    }
    public int update(ClassManager cls){
        ContentValues values = new ContentValues();
        values.put("Malop",cls.getId());
        values.put("TenLop",cls.getName());
        try {
            if (db.update("ClassRoos",values,"Malop=?",new String[]{cls.getId()}) == -1){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("ClassManagerDAO","//==="+e.toString());
        }
        return 1;
    }
    public int del(String id) {
        int result = db.delete("ClassRoos","Malop=?",new String[]{id});
        if (result == 0)
            return -1;
        return 1;
        }

    public int finByid(String id){
        for (int i = 0; i< getAll().size(); i++) {
            ClassManager cls = lsclass.get(i);
            if (cls.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public  void dumydata(){
        lsclass.add(new ClassManager("PD1503", "Lập trình android"));
        lsclass.add(new ClassManager("PD1504", "Thiết kế đồ họa"));
        lsclass.add(new ClassManager("PD1505", "Lập trình web"));
        lsclass.add(new ClassManager("PD1506", "Ứng dụng phần mềm"));
    }
}
