package com.example.captain.insurancegame;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by captain on 2018/5/12.
 */

public class ClockTask extends TimerTask {
    public void run(){

    }

    public void runclock(int month , int year, TextView tvmonth,TextView tvyear){
        int temp=month+1;
        if(temp>12){
            month=1;
            year++;
        }
        tvmonth.setText(month);
        tvyear.setText(year);
    }


}
