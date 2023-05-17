package com.example.quanlysinhvien.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbStudentManager";
    public static final  int VERSION_DB = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sSQL_ClassRoom = "CREATE TABLE ClassRoos(Malop TEXT PRIMARY KEY, TenLop TEXT)";
        String sSQL_student = "CREATE TABLE Student(id TEXT PRIMARY KEY, name TEXt, phone TEXT, idClass TEXt)";
        db.execSQL(sSQL_ClassRoom);
        db.execSQL(sSQL_student);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if  exists ClassRoos");
        onCreate(db);
    }
}