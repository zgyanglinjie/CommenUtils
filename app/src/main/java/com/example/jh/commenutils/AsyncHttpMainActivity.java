package com.example.jh.commenutils;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;

import utils.AsyncHttpUtils;


public class AsyncHttpMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http_main);
        AsyncHttpClient asc=new AsyncHttpClient();
        asc.get("https://httpbin.org/get",new TextHttpResponseHandler() {
            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                Log.e("bbb",s);
            }
        });
//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
    }
    public void method1() {
        Log.e("bbb","进入方法");
        String urlString = "https://httpbin.org/get"; // 一個獲取菜谱的url地址
        AsyncHttpUtils.get(urlString, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.e("bbb",new String(bytes));
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.e("bbb","失败");
            }

            public void onFinish() { // 完成后调用，失败，成功，都要掉
                Log.e("bbb","完成");
            };
        });
    }
    public void method2() {
        String urlString = "http://client.azrj.cn/json/cook/cook_list.jsp?";
        RequestParams params = new RequestParams(); // 绑定参数
        params.put("type", "1");
        params.put("p", "2");
        params.put("size", "10");
        AsyncHttpUtils.get(urlString, params, new JsonHttpResponseHandler() {
            public void onSuccess(JSONArray arg0) { // 成功后返回一个JSONArray数据
                Log.e("bbb", arg0.length() + ","+arg0.toString());
//                try {
//                    textView.setText("菜谱名字："
//                            + arg0.getJSONObject(2).getString("name")); //返回的是JSONArray， 获取JSONArray数据里面的第2个JSONObject对象，然后获取名字为name的数据值
//                } catch (Exception e) {
//                    Log.e("hck", e.toString());
//                }
            };
            public void onFailure(Throwable arg0) {
                Log.e("hck", " onFailure" + arg0.toString());
            };
            public void onFinish() {
                Log.i("hck", "onFinish");
            };
            public void onSuccess(JSONObject arg0) {   //返回的是JSONObject，会调用这里
                Log.i("hck", "onSuccess ");
                try {
//                    textView.setText("菜谱名字："
//                            + arg0.getJSONArray("list").getJSONObject(0)
//                            .getString("name"));
                } catch (Exception e) {
                    Log.e("hck", e.toString());
                }
            };
        });
    }
    public void method3() {
        String urlString = "http://client.azrj.cn/json/cook/cook_list.jsp?type=1&p=2&size=10";
        AsyncHttpUtils.get(urlString, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.e("bbb","请求1"+response.toString());
            }
        });
    }
    public void method4() {
        String urlString = "http://client.azrj.cn/json/cook/cook_list.jsp?";
        final RequestParams params = new RequestParams();
        params.put("type", "1");
        params.put("p", "2");
        params.put("size", "10");
        AsyncHttpUtils.get(urlString, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.e("bbb","请求1"+new String(bytes));
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }
    public void method5() {
        String url = "http://f.hiphotos.baidu.com/album/w%3D2048/sign=38c43ff7902397ddd6799f046dbab3b7/9c16fdfaaf51f3dee973bf7495eef01f3b2979d8.jpg";
        AsyncHttpUtils.get(url, new BinaryHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.e("bbb",new String(bytes));
                File file = Environment.getExternalStorageDirectory();
                File file2 = new File(file, "cat");
                file2.mkdir();
                file2 = new File(file2, "cat.jpg");
                try {
                    FileOutputStream oStream = new FileOutputStream(file2);
                    oStream.write(bytes);
                    oStream.flush();
                    oStream.close();
//                    textView.textView("可爱的猫咪已经保存在sdcard里面");
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.i("hck", e.toString());
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

}
