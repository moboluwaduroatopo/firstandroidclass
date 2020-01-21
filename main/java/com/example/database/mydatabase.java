package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class mydatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="test.db";
    public static final String TABLE_NAME="users";
    public static final String COL_1="_id";
    public static final String COL_2="first_name";
    public static final String COL_3="last_name";
    public static final String COL_4="email";
    public static final  int DATABASE_VERSION=1;

    public mydatabase(@Nullable Context context)//, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " ("+ COL_1 +" INTEGER PRIMARY KEY AUTOINCREMENT"+"," +COL_2+" TEXT,"+COL_3+" TEXT,"+COL_4+" TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean addData(String fName, String lName, String email){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_2, fName);
        cv.put(COL_3,lName);
        cv.put(COL_4,email);
       long i= db.insert(TABLE_NAME, null,cv);
       if (i == 1){
           return true;
       }else {
           return false;
       }
    }

}
