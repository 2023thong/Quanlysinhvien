package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quanlysinhvien.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    private SQLiteDatabase db;
    private DatabaseHelper helper;
    private static final String TABLE_NAME = "Student";

    public studentDAO(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }
    public int add(student2 st){
        ContentValues values = new ContentValues();
        values.put("id",st.getId());
        values.put("name",st.getName());
        values.put("phone",st.getPhone());
        values.put("idClass",st.getIdclass());
        try {
            if (db.insert(TABLE_NAME,null,values) == -1){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("studentDAO Error",e.toString());
        }
        return 1;
    }
    public List<student2> getAll(){
        List<student2> ls  = new ArrayList<>();
        Cursor c = db.query("ClassRoos", null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast() == false){
            student2 st = new student2();
            st.setId(c.getString(0));
            st.setName(c.getString(1));
            ls.add(st);
            c.moveToNext();
        }
        c.close();
        return ls;

    }
    public int update(student2 st){
        ContentValues values = new ContentValues();
        values.put("id",st.getId());
        values.put("name",st.getName());
        values.put("phone",st.getPhone());
        values.put("idClass",st.getIdclass());
        int result = db.update(TABLE_NAME,values,"id=?",new String[]{st.getId()});
        try {
            if (result == 0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("studentDAO Error",e.toString());
        }
        return 1;
    }
    public  int del(String id){
        int result = db.delete(TABLE_NAME,"id=?",new String[]{id});
        if (result == 0)
            return -1;
        return 1;
    }



}
