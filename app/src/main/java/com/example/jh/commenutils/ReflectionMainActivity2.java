package com.example.jh.commenutils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utils.Base64;
import utils.ReflectionUtils;


public class ReflectionMainActivity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection_main_activity2);
        Button  btn_click=(Button)findViewById(R.id.btn_click);
        Button btn_t=(Button)findViewById(R.id.btn_t);
        final TextView tv_textView=(TextView)findViewById(R.id.tv_textView);

        btn_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=16;
                tv_textView.setText(Base64.encode("aaaa".getBytes()));
//                showDiglog();
                Toast.makeText(ReflectionMainActivity2.this,new String(Base64.decode(Base64.encode("aaaa".getBytes()))),Toast.LENGTH_LONG).show();
            }
        });
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Class<?> clz = null;
//                try {
//                    clz = Class.forName("com.gome.share.ui.activity.MainActivity");
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Object object = clz.newInstance();
//                    Field cId = clz.getDeclaredField("currentId");
//                    cId.setAccessible(true);
//                    cId.setInt(object, 1);
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(BaseActivity.this, clz);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                Class<?>clz=null;
                try {
                    clz=Class.forName("com.example.jh.commenutils.ReflectionActivity1");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
//                try {
//                    Object obj=clz.newInstance();
//                    Field cid=clz.getDeclaredField("i");
//                    Log.e("bbb",cid+"");
//                    cid.setAccessible(true);
//                    cid.setInt(obj,12);
//                } catch (Exception e) {
//                    e.printStackTrace();}
                ReflectionUtils.getInstance(clz,"i,12");
                Intent intent=new Intent(ReflectionMainActivity2.this,clz);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean isShow() {
        return true;
    }
}
