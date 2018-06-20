package com.example.captain.insurancegame;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.TextView;


import java.util.TimerTask;

/**
 * Created by captain on 2018/5/11.
 */

public class titleLayout extends LinearLayout {

    private TextView tvyear=(TextView)findViewById(R.id.textyear);
    private TextView tvmonth=(TextView)findViewById(R.id.textyear);
    int  month=5;
    int year=2018;
    public titleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);

    }

    public titleLayout(Context context){
        super(context);
        LayoutInflater.from(context).inflate(R.layout.title,this);

    }
  
}