package com.example.jh.commenutils;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PhoneActivity extends ActionBarActivity implements View.OnClickListener {
     private EditText et_name;
     private EditText et_phone;
     private Button btn_query;
     private Button btn_add;
     private Button btn_updata;
     private Button btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        init();
    }

    private void init() {
        et_name=(EditText)findViewById(R.id.et_name);
        et_phone=(EditText)findViewById(R.id.et_phone);
        btn_query=(Button)findViewById(R.id.btn_query);
        btn_query.setOnClickListener(this);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_delete=(Button)findViewById(R.id.btn_delete);
        btn_updata=(Button)findViewById(R.id.btn_updata);
    }
    private void displayRecords() {
        //该数组中包含了所有要返回的字段
        String columns[] = new String[] { Contacts.People.NAME, Contacts.People.NUMBER };
        Uri mContacts = Contacts.People.CONTENT_URI;
        Cursor cur = managedQuery(
                mContacts,
                columns,  // 要返回的数据字段
                null,          // WHERE子句
                null,         // WHERE 子句的参数
                null         // Order-by子句
        );
        if (cur.moveToFirst()) {
            String name = null;
            String phoneNo = null;
            do {
                // 获取字段的值
                name = cur.getString(cur.getColumnIndex(Contacts.People.NAME));
                phoneNo = cur.getString(cur.getColumnIndex(Contacts.People.NUMBER));
                Toast.makeText(this,"name="+name,Toast.LENGTH_LONG);
            } while (cur.moveToNext());
        }
    }

    private void insertRecords(String name, String phoneNo) {
        ContentValues values = new ContentValues();
        values.put(Contacts.People.NAME, name);
        Uri uri = getContentResolver().insert(Contacts.People.CONTENT_URI, values);
        Uri numberUri = Uri.withAppendedPath(uri, Contacts.People.Phones.CONTENT_DIRECTORY);
        values.clear();
        values.put(Contacts.Phones.TYPE, Contacts.People.Phones.TYPE_MOBILE);
        values.put(Contacts.People.NUMBER, phoneNo);
        getContentResolver().insert(numberUri, values);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_query:
                displayRecords();
                break;
            case R.id.btn_add:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_updata:
                break;
        }
    }
}
