package com.example.kurakani;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String Db_name = "kurakani.db";
    private static final int Db_version = 1;
    private static final String Table_name = "registration";
//    private static

    public DbHelper(@Nullable Context context) {
        super(context, Db_name, null, Db_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String qry = "CREATE TABLE "+Table_name+" (SNo INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Gmail TEXT, Number TEXT, Password TEXT, Gender TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }

    public void registerPeople(String name, String gmail, String number, String password, String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name", name);
        cv.put("Gmail", gmail);
        cv.put("Number", number);
        cv.put("Password", password);
        cv.put("Gender", gender);
        Long res = db.insert(Table_name, null, cv);
        if(res == -1){
            Toast.makeText(context, "Failed to register. Try again", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Registered successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
