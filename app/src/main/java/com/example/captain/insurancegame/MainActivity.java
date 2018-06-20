package com.example.captain.insurancegame;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.captain.work.Mydatabase;


public class MainActivity extends Activity {
    private RelativeLayout linearLayout;
    private ImageButton loginButton,continuebt;
    private Mydatabase dbhelper;
    private Context mcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mcontent=this;


        //图像处理
//        linearLayout=(RelativeLayout)findViewById(R.id.LinearLayout1);
//        Bitmap bm=BitmapFactory.decodeResource(this.getResources(),R.drawable.story);
//        BitmapDrawable bd=new BitmapDrawable(this.getResources(),bm);
//        linearLayout.setBackground(bd);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



        //数据库操作

//         values.put("id",1);
//         values.put("MONEY",10000);
//         values.put("PAGE",1);
//         db.insert("user",null,values);
//        db.execSQL("replace into user values(1,10000,0)");


        //利用数据库实现存档



//        if(cursor.moveToFirst()){
//            do{
//                int  id=cursor.getInt(cursor.getColumnIndex("id"));
//                int money=cursor.getInt(cursor.getColumnIndex("MONEY"));
//                Log.d("MainActivity","id is"+ id);
//                Log.d("MainActivity","money is"+ money);
//
//            }while(cursor.moveToNext());
//        }


//        RelativeLayout dialayout=(RelativeLayout)getLayoutInflater().inflate(R.layout.activity_main, null);

        loginButton=(ImageButton)findViewById(R.id.ImageButton0);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper=new Mydatabase(mcontent,"userinfo.db",null,1);
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                db.execSQL("replace into user values(1,10000,1)");
                db.close();
                Intent intent=new Intent(mcontent,gameActivity.class);
                startActivity(intent);
            }
        });

        continuebt=(ImageButton)findViewById(R.id.imageButton2);
        continuebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper=new Mydatabase(mcontent,"userinfo.db",null,1);
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                Cursor cursor=db.rawQuery("SELECT * FROM user",null);
                Intent intent;
                if(cursor.moveToFirst()){
                    int page=cursor.getInt(cursor.getColumnIndex("PAGE"));
                    cursor.close();
                    db.close();
                    if(page==2){
                        intent=new Intent(mcontent,gameActivity.class);
                        startActivity(intent);
                    }
                    if(page==3){
                        intent=new Intent(mcontent,firstActivity.class);
                        startActivity(intent);
                    }
                    if(page==4){
                        intent=new Intent(mcontent,SecondActivity.class);
                        startActivity(intent);
                    }

                }
            db.close();
                cursor.close();
            }
        });






    }
}
