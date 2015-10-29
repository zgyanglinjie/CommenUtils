package com.example.jh.commenutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ReflectionActivity1 extends BaseActivity {
    private static   String i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection_activity1);
        TextView textView=(TextView)findViewById(R.id.textView);
        Log.e("bbb", i+ "");
        textView.setText(i+"");
    }

//    @Override
//    public boolean isShow() {
//        return true;
//    }
}
