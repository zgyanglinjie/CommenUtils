package com.example.jh.commenutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class PicassoActivity extends ActionBarActivity {
    ImageView iv_pocasso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        iv_pocasso=(ImageView)findViewById(R.id.iv_pocasso);
        String url="http://www.jycoder.com/json/Image/1.jpg";
        Picasso.with(PicassoActivity.this).load(url)
        .placeholder(R.drawable.abc_btn_check_material)
        .error(R.drawable.abc_btn_check_material)
        .into(iv_pocasso);

//        Picasso.with(PicassoActivity.this)
//                .load(url)
//                .resize(500, 500)
//                .centerCrop()
//                .into(iv_pocasso);
    }
}
