package com.example.jh.commenutils;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import utils.CallBack;


public class CallBackActivity extends BaseActivity {
    CallBack callBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);
        Button btn_click=(Button)findViewById(R.id.btn_click);
        final TextView textView=(TextView)findViewById(R.id.tv_textView);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
         callBack=new CallBack();
         callBack.setExecutor(new CallBack.CallBackExecutor() {
            @Override
            public void click() {
                textView.setText("aasdasdasd");
            }
        });
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBrower();
            }
        });
    }
    protected void openBrower() {
        Intent intent= new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("http://weixin.qq.com");
        intent.setData(content_url);
//        intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");//Android手机系统本地浏览器
        intent.setClassName("com.uc.browser","com.uc.browser.ActivityUpdate");
        if (intent.resolveActivity(getPackageManager())!=null){//判断是否能得到可开启的activity
            Log.e("bbb", intent.resolveActivity(getPackageManager()).getClassName());
            startActivity(intent);
        }
        else {
            Toast.makeText(CallBackActivity.this,"是空",Toast.LENGTH_LONG);

        }



//        Uri uri = Uri.parse("http://weixin.qq.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//        startActivity(intent);

    }
}
