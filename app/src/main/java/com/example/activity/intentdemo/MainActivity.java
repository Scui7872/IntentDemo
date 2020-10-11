package com.example.activity.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            //使用隐式Intent实现 Activity的跳转
            case R.id.btn_second:
                intent.setAction("com.example.activity.SECOND_ACTIVITY");
                intent.putExtra("msg","second activity");
                break;
            case R.id.btn_call:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "10000"));
                break;
            case R.id.btn_set:
                intent = new Intent(Settings.ACTION_DATE_SETTINGS);
                break;
        }
            //判断intent 指向的action是否存在
            if(intent.resolveActivity(getPackageManager()) !=null) {
                startActivity(intent);
        }
    }

//    public void startTimer(String message,int seconds) {
//        switch (R.id.btn_time) {
//        }
//        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
//                .putExtra(AlarmClock.EXTRA_MESSAGE,message)
//                .putExtra(AlarmClock.EXTRA_LENGTH,seconds)
//                .putExtra(AlarmClock.EXTRA_SKIP_UI,true);
//        //判断intent 指向的action是否存在
//        if(intent.resolveActivity(getPackageManager()) !=null) {
//            startActivity(intent);
//        }
//    }
}