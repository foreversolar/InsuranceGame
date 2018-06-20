package com.example.captain.insurancegame;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Xml;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.content.Context;
import java.io.InputStream;
import android.view.View;

import com.example.captain.work.Mydatabase;

/**
 * Created by captain on 2018/5/10.
 */

public class gameActivity extends Activity {
    private Button storybt;
    private TextView tv;
    private Context mcontent;
    private Mydatabase dbhelper;
    private int missionid=1;
    Mission1 m1=new Mission1();
    protected void onCreate(Bundle savedInstanceState){
        mcontent=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamein);


        dbhelper=new Mydatabase(this,"userinfo.db",null,1);
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        db.execSQL("replace into user values(1,10000,2)");



        RelativeLayout dialayout=(RelativeLayout)getLayoutInflater().inflate(R.layout.gamein, null);
        storybt=(Button)findViewById(R.id.button4);
        tv=(TextView)findViewById(R.id.textView) ;

        storybt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DoXmlWithDOM dd=new DoXmlWithDOM();
//                dd.runparse();
           if(missionid<=2){
//              String input=getResources().getString(R.string.dialog1);
//              String output=String.format(input,"asdafasfafas");
//              mcontent.getResources().getString(R.string.dialog1,"asdasdada");
//               String data = getResources().getString(R.string.data);
//               data = String.format(data, 100, 10.3, "2011-07-01");
                tv.setText(m1.dialogshow(missionid));
                missionid++;}
           else{
               Intent intent=new Intent(mcontent,firstActivity.class);
                startActivity(intent);
           }

//

            }
        });
    }
//    void midToast(String str, int showTime)
//    {
//        Toast toast = Toast.makeText(global_context, str, showTime);
//        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL , 0, 0);  //设置显示位置
//        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//        v.setTextColor(Color.YELLOW);     //设置字体颜色
//        toast.show();
//    }


//    private void parseXmlWithPull(String xmldata){
//        try{
//            XmlResourceParser xmlResourceParser=this.getResources().getXml(R.xml.strings);
//
//        }
//
//    }
}
