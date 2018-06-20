package com.example.captain.insurancegame;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.captain.work.Insurance;
import com.example.captain.work.Mydatabase;

import java.util.ArrayList;

/**
 * Created by captain on 2018/5/11.
 */

public class firstActivity extends Activity
{
    private TextClock mtc;
    private Button btcus,btsale,btinfo,button;
    private ScrollView svcus,svsale,svinfo;
    private ImageButton ibtcus,ibtsale,next,ibtinfo;
    private ArrayAdapter<customer> cusadapter;
    private GridView cusgrid;
    private Context mcontent;
    private TextView salein,moneyshow;
    private Spinner insuspin;
    private ImageButton letter,salere,salebegin;
    private Mydatabase dbhelper;
    private ArrayList<customer> cusData;
    private int fee;
    private int mymoney;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firststage);


        //数据库更新
        dbhelper=new Mydatabase(this,"userinfo.db",null,1);
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        Cursor cursor=db.query("user",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                mymoney=cursor.getInt(cursor.getColumnIndex("MONEY"));
            }while(cursor.moveToNext());
        }
        cursor.close();

        db.execSQL("replace into user values(1,10000,3)");
        db.close();
        moneyshow=(TextView)findViewById(R.id.moneyyyy);
        moneyshow.setText(""+mymoney);

        //客户信息，销售模块

        mcontent = firstActivity.this;
//        mtc=(TextClock)findViewById(R.id.clock1);
        btcus = (Button) findViewById(R.id.button5);
        svcus = (ScrollView) findViewById(R.id.svcus);
        btcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svcus.setVisibility(View.VISIBLE);
            }
        });
        ibtcus = (ImageButton) findViewById(R.id.cancle);
        ibtcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svcus.setVisibility(View.INVISIBLE);
            }
        });
        ibtsale = (ImageButton) findViewById(R.id.cancle1);
        btsale = (Button) findViewById(R.id.button6);
        svsale = (ScrollView) findViewById(R.id.svsale);
        btinfo = (Button) findViewById(R.id.button8);
        svinfo=(ScrollView)findViewById(R.id.svinfo);
        ibtinfo = (ImageButton) findViewById(R.id.cancle2);
        btinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView=(TextView)findViewById(R.id.moneysel);
                textView.setText(""+mymoney);
                svinfo.setVisibility(View.VISIBLE);


            }
        });
        ibtinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svinfo.setVisibility(View.INVISIBLE);
            }
        });
        //获取信息模块，计算销售利润


        btsale.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                svsale.setVisibility(View.VISIBLE);
                insuspin=(Spinner)findViewById(R.id.spinner);
                insuspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String str="";
                        str=(String)insuspin.getSelectedItem();
                        Insurance myins=new Insurance();
                        Log.d("item", "onItemSelected: "+str);
                        fee=myins.agencyfee(str);
                        Log.d("item", "onItemSelected: "+fee);
                        mymoney+=fee;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });
        ibtsale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                svsale.setVisibility(View.INVISIBLE);
            }
        });

        cusData = new ArrayList<customer>();
        cusData.add(new customer("陈婆婆", "普通", "s区", "中年", "小康"));
        cusData.add(new customer("王婆婆", "普通", "s区", "中年", "小康"));
        next=(ImageButton)findViewById(R.id.salebegin);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mcontent,SaleActivity.class);
                startActivity(intent);
            }
        });
        svinfo=(ScrollView)findViewById(R.id.svinfo);
        btinfo=(Button)findViewById(R.id.button8);
        ibtinfo=(ImageButton)findViewById(R.id.cancle2);


        salebegin=(ImageButton)findViewById(R.id.salebegin);
        letter=(ImageButton) findViewById(R.id.imageView2);
        salere=(ImageButton) findViewById(R.id.imageView3);
        salein=(TextView)findViewById(R.id.money);



        //获取信息传递
        Intent intent=getIntent();
        int status=intent.getIntExtra("lettershown",0);
        fee=intent.getIntExtra("feebefo",fee);
        if(status==1){

            letter.setVisibility(View.VISIBLE);
        }
        salere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salein.setVisibility(View.INVISIBLE);
                salere.setVisibility(View.INVISIBLE);
            }
        });

        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               letter.setVisibility(View.INVISIBLE);
               salein.setText("$"+fee);
               moneyshow.setText(""+mymoney);
               salein.setVisibility(View.VISIBLE);
               salere.setVisibility(View.VISIBLE);
            }
        });
       button=(Button)findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SQLiteDatabase db=dbhelper.getWritableDatabase();
               ContentValues values=new ContentValues();
               values.put("MONEY",mymoney);
               db.update("user",values,"id=1",null);
               db.close();
               Intent intent=new Intent(mcontent,SecondActivity.class);
               startActivity(intent);
           }
       });


       salebegin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SQLiteDatabase db=dbhelper.getWritableDatabase();
               ContentValues values=new ContentValues();
               values.put("MONEY",mymoney);
               db.update("user",values,"id=1",null);
               db.close();

               Intent intent=new Intent(mcontent,SaleActivity.class);
               intent.putExtra("feebefo",fee);
               startActivity(intent);
           }
       });

        //跑马灯方案1
//        TextSwitcher ts=(TextSwitcher)findViewById(R.id.ts);
//        ts.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                TextView tv=new TextView(mcontent);
//                return tv;
//            }
//        });
//        ts.setInAnimation(AnimationUtils.loadAnimation(getBaseContext(),android.R.anim.slide_in_left));
//        ts.setOutAnimation(AnimationUtils.loadAnimation(getBaseContext(),android.R.anim.slide_out_right));
//        ts.setText("ASdadadasd");
//
           //跑马灯方案2



    }





    }

