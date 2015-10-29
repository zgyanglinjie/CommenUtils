package com.example.jh.commenutils;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
/**
 * Created by jh on 2015/7/21.
 */
public class BaseActivity extends Activity {
    int i;
    @Override
    protected void onCreate(Bundle   arg0) {
        super.onCreate(arg0);
        showDiglog();
    }
    public  void showDiglog(){
       if (isShow()){
           Toast.makeText(BaseActivity.this,"执行了",Toast.LENGTH_SHORT).show();
       }
    }
    public boolean isShow(){
        return false;
    }
}
