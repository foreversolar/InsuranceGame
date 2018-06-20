package com.example.captain.work;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by captain on 2018/6/4.
 */

public class Mydatabase extends SQLiteOpenHelper {
    public static final String CREATE_Info="CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT,MONEY INTEGER,PAGE INTEGER)";
    private Context mcontext;
    public Mydatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
        mcontext=context;
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_Info);
        Toast.makeText(mcontext,"Create Success!",Toast.LENGTH_SHORT).show();
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
