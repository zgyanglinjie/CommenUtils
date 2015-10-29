package com.example.jh.commenutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.utils.L;


public class AnmtionActivity extends ActionBarActivity {
ImageView iv_imageview;
    TextView tv_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anmtion);
        iv_imageview=(ImageView)findViewById(R.id.iv_imageview);
        tv_textview=(TextView)findViewById(R.id.tv_textview);
        iv_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Translate();
            }
        });
    }

    public void Rotata(){
        AnimationSet animationSet=new AnimationSet(true);
        //后面的四个参数定义的是旋转的圆心位置
        RotateAnimation rotateAnimation=new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f);
        rotateAnimation.setDuration(2000);
        animationSet.addAnimation(rotateAnimation);
        iv_imageview.startAnimation(animationSet);
    }

    public void Alpha_Translate() {
//        int[] location2 = new int[2];
//        iv_imageview.getLocationOnScreen(location2);
//        int x2 = location2[0];
//        int y2 = location2[1];
//        AnimationSet animationSet=new AnimationSet(true);
////        AlphaAnimation alphaAnimation=new AlphaAnimation(1, 0);
////        alphaAnimation.setDuration(2000);
////        animationSet.addAnimation(alphaAnimation);
////        TranslateAnimation translateAnimation=new TranslateAnimation(
////                Animation.RELATIVE_TO_SELF, x,  //X轴的开始位置
////                Animation.RELATIVE_TO_SELF, 0.5f,  //X轴的结束位置
////                Animation.RELATIVE_TO_SELF, y,  //Y轴的开始位置
////                Animation.RELATIVE_TO_SELF, 1.0f);  //Y轴的结束位置
//        translateAnimation.setFillAfter(true);
//        translateAnimation.setDuration(1000);
//        animationSet.addAnimation(translateAnimation);
//        iv_imageview.startAnimation(animationSet);
    }


    public void Translate() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
                2.5f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 2.5f);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        iv_imageview.startAnimation(animationSet);
    }
}
