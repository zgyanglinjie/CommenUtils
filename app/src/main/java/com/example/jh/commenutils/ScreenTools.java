package com.example.jh.commenutils;

import android.content.Context;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by jh on 2015/9/1.
 */
public class ScreenTools {
    private   Context context;
    private ScreenTools(Context context){
        this.context=context;
    }
    public static ScreenTools instance(Context context){
        return new ScreenTools(context);
    }
    //获取屏幕的宽度
    public  int getScreenWidth() {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }
    //获取屏幕的高度
    public  int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px( float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public  int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
