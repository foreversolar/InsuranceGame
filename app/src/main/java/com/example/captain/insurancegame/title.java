package com.example.captain.insurancegame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by captain on 2018/5/20.
 */

public class title extends Activity {
    private Context context;
    private TextView tvmonth;
    private TextView tvyear;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        tvmonth=(TextView)findViewById(R.id.textmonth);
        tvyear=(TextView)findViewById(R.id.textyear);
        Timer timer=new Timer();

    }
}


class Task extends TimerTask{
    @Override
    public void run(){
    }
}
