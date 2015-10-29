package com.example.jh.commenutils;

import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CountDownTimerActivity extends ActionBarActivity {
    TextView tv_time;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down_timer);
        tv_time=(TextView)findViewById(R.id.tv_time);
        try{
            Toast.makeText(CountDownTimerActivity.this,"dajiahapo",Toast.LENGTH_SHORT).show();
            Thread.sleep(50000);
            tv_time.setText("王八蛋");
        }catch (Exception O){
        }
//        new   AsyncTask<String , Void,String>(){
//            @Override
//            protected String doInBackground(String... params) {
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                try{
//                    Toast.makeText(CountDownTimerActivity.this,"dajiahapo",Toast.LENGTH_SHORT).show();
//                    Thread.sleep(10000);
//                    tv_time.setText("王八蛋");
//                }catch (Exception O){
//                }
//                super.onPostExecute(s);
//            }
//        }.execute();
        timer=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
             tv_time.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
             tv_time.setText("开始计时");
                tv_time.setEnabled(true);
            }
        };
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                tv_time.setEnabled(false);
            }
        });

    }
}
