package com.example.jh.commenutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class SpannableStringBuilderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_string_builder);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        String str="中华人民共和国是一个很好的国家，党是伟大的，大学时美好的,[123456],去你大爷的[78910],儿子们好";
        SpannableStringBuilder ssb=new SpannableStringBuilder(str);
        int start=str.indexOf("[");
        int end=0;
        while (start!=-1){
            end=str.indexOf("]",start)+1;
            Log.e("bbb",""+end);
            final   String obtainStr=str.substring(start,end);
            if (obtainStr.equals("[123456]")){
                Log.e("bbb",""+obtainStr);
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(SpannableStringBuilderActivity.this,"我很好"+obtainStr,Toast.LENGTH_LONG).show();
                    }
                },start,end,0);

            }
            if (obtainStr.equals("[78910]")){
                Log.e("bbb",""+obtainStr);
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(SpannableStringBuilderActivity.this,"你大爷的"+obtainStr,Toast.LENGTH_LONG).show();
                    }
                },start,end,0);
            }
         start=str.indexOf("[",end);
        }
        tv.setText(ssb, TextView.BufferType.SPANNABLE);

    }

}
