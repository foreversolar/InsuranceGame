package com.example.captain.insurancegame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.captain.work.Mydatabase;

public class SecondActivity extends Activity {
     Context mcontent;
     private Button learning,people,affair,sheet,xiaozhaodecide,affairnewproduct1,newproduct,newproductconfirm,learning1,learning3;
     private ScrollView learninglist,menu,peoplelist,xiaozhaolist,affairlist,affairitem,newproductlist;
     private ImageButton ibtlearninglist,ibtpeople;
     private TextView shezhao,xiaozhao,affairitem1;
     private Mydatabase dbhelper;
     private int number;
     private int mymoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondstage);
        mcontent = SecondActivity.this;

        dbhelper=new Mydatabase(this,"userinfo.db",null,1);
        SQLiteDatabase db=dbhelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        db.execSQL("replace into user values(1,10000,4)");

         learning=(Button)findViewById(R.id.learning);
         learning1=(Button)findViewById(R.id.learning1);
         learning3=(Button)findViewById(R.id.learning3);
         learning3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AlertDialog.Builder dialog=new AlertDialog.Builder(mcontent,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                 dialog.setTitle("选课确认");
                 dialog.setMessage("  团队合作可以调动团队成员的所有资源和才智，它必将会产生一股强大而且持久的力量。\n" +
                         "\n" +
                         "  你是否确认学习这门课程？");
                 dialog.setCancelable(true);
                 dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         learninglist.setVisibility(View.INVISIBLE);
                         Toast.makeText(mcontent,"您开始学习团队合作",Toast.LENGTH_SHORT).show();
                     }
                 });
                 dialog.setNegativeButton("算了，太难了", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {

                     }
                 });
                 dialog.show();
             }
         });

        TextView insurancegame=(TextView)findViewById(R.id.textView27);
        TextView mymoneyl=(TextView)findViewById(R.id.textView26);


        learning1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(mcontent,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                dialog.setTitle("选课确认");
                dialog.setMessage("  客户沟通可以调动提升公司业绩，提升形象，它必对公司未来产生深远的影响。\n" +
                        "\n" +
                        "  你是否确认学习这门课程？");
                dialog.setCancelable(true);
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        learninglist.setVisibility(View.INVISIBLE);
                        Toast.makeText(mcontent,"您开始学习客户沟通",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("算了，太难了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
         people=(Button)findViewById(R.id.people);
         learninglist=(ScrollView)findViewById(R.id.learninglist);
         peoplelist=(ScrollView)findViewById(R.id.peoplelist);
         ibtlearninglist=(ImageButton)findViewById(R.id.cancel3);
         ibtpeople=(ImageButton)findViewById(R.id.cancle4);
         learning.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 learninglist.setVisibility(View.VISIBLE);
             }
         });
         ibtlearninglist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                learninglist.setVisibility(View.INVISIBLE);
            }
        });
         people.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 peoplelist.setVisibility(View.VISIBLE);
             }
         });
         ibtpeople.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 peoplelist.setVisibility(View.INVISIBLE);
             }
         });
         xiaozhao=(TextView)findViewById(R.id.textViewxiaozhao);
         shezhao=(TextView)findViewById(R.id.textViewshezhao);
        xiaozhaolist=(ScrollView)findViewById(R.id.xiaozhaolist);
          xiaozhao.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  peoplelist.setVisibility(View.INVISIBLE);
                  xiaozhaolist.setVisibility(View.VISIBLE);
              }
          });
        xiaozhaodecide=(Button)findViewById(R.id.xiaozhaodecide);
        xiaozhaodecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaozhaolist.setVisibility(View.INVISIBLE);
            }
        });


        affairlist=(ScrollView)findViewById(R.id.affairlist);
        affairitem=(ScrollView)findViewById(R.id.affairitem);
        affair=(Button)findViewById(R.id.affair);
        affair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                affairlist.setVisibility(View.VISIBLE);
            }
        });


        newproduct=(Button)findViewById(R.id.button10);
        newproductconfirm=(Button)findViewById(R.id.button13);
        newproductlist=(ScrollView)findViewById(R.id.newproductliat);
        newproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newproductlist.setVisibility(View.VISIBLE);
            }
        });
        newproductconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newproductlist.setVisibility(View.INVISIBLE);
                Toast.makeText(mcontent,"您的定制保险正在提交研发部...",Toast.LENGTH_SHORT).show();
                number=Integer.parseInt(insurancegame.getText().toString());
                number++;
                insurancegame.setText(""+number);
                mymoney=Integer.parseInt(mymoneyl.getText().toString());
                mymoney-=20000;
                mymoneyl.setText(mymoney+"");
            }
        });


        //
        String[] data={"!!!!新产品研发","!!!与王老板的会议","!!!!新产品发售"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(mcontent,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.afflist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str=data[i];
                affairitem.setVisibility(View.VISIBLE);
                affairlist.setVisibility(View.INVISIBLE);
                affairnewproduct1=(Button)findViewById(R.id.button12);
                affairnewproduct1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        affairitem.setVisibility(View.INVISIBLE);
                        Toast.makeText(mcontent,"新产品正在研发中.....",Toast.LENGTH_LONG).show();
                        number=Integer.parseInt(insurancegame.getText().toString());
                        number++;
                        insurancegame.setText(""+number);
                        mymoney=Integer.parseInt(mymoneyl.getText().toString());
                        mymoney-=20000;
                        mymoneyl.setText(mymoney+"");

                    }
                });
            }
        });



        //校招

        xiaozhaodecide=(Button)findViewById(R.id.xiaozhaodecide);
        xiaozhaodecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xiaozhaolists="";
                CheckBox check1=(CheckBox)findViewById( R.id.checkBox);
                CheckBox check2=(CheckBox)findViewById( R.id.checkBox2);
                CheckBox check3=(CheckBox)findViewById( R.id.checkBox3);
                CheckBox check4=(CheckBox)findViewById( R.id.checkBox4);
                if(check1.isChecked()){
                    xiaozhaolists+=check1.getText().subSequence(0,2)+" ";
                }if (check2.isChecked()){
                    xiaozhaolists+=check2.getText().subSequence(0,2)+" ";
                }if (check3.isChecked()){
                    xiaozhaolists+=check3.getText().subSequence(0,2)+" ";
                }if (check4.isChecked()){
                    xiaozhaolists+=check4.getText().subSequence(0,2)+" ";
                }
                Toast.makeText(mcontent,xiaozhaolists+"正在前往人事部报道...",Toast.LENGTH_SHORT).show();
                xiaozhaolist.setVisibility(View.INVISIBLE);
            }
        });



        sheet=(Button)findViewById(R.id.sheet);
        ScrollView svsheet=(ScrollView)findViewById(R.id.sheetlist);
        ImageButton isheet=(ImageButton)findViewById(R.id.imageButton);

        sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svsheet.setVisibility(View.VISIBLE);
            }
        });
       isheet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               svsheet.setVisibility(View.INVISIBLE);
           }
       });




















}
}
