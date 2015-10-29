package com.example.jh.commenutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import CustomView.SlideButton;


public class CustomViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        SlideButton csb=(SlideButton)findViewById(R.id.csb);
        csb.setToggleState(true);
        csb.setOnToggleStateChangeListener(new SlideButton.OnToggleStateChangeListener() {
            @Override
            public void changlistener(boolean state) {
                Toast.makeText(CustomViewActivity.this,""+state,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
