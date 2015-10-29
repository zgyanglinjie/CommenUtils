package utils;

import android.os.CountDownTimer;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by jh on 2015/8/17.
 */
public class AsyncHttpUtils {

    private static AsyncHttpClient client =new AsyncHttpClient();  //实例话对象
         static
         {
            Log.e("bb b","设置链接超时，如果不设置，默认为10s");
            client.setTimeout(11000);//设置链接超时，如果不设置，默认为10s

        }
        public static void get(String urlString,AsyncHttpResponseHandler res)
         {
             Log.e("bbb",client.toString());
              client.get(urlString, res);
         }
       public static void get(String urlString,RequestParams params,AsyncHttpResponseHandler res) //url里面带参数
        {
          client.get(urlString, params,res);
        }
       public static void get(String urlString,JsonHttpResponseHandler res){
           client.get(urlString, res);
       }
    public static void get(String urlString,RequestParams params,JsonHttpResponseHandler res)
    {
        client.get(urlString, params,res);
    }
    public static void get(String uString, BinaryHttpResponseHandler bHandler)
    {
        client.get(uString, bHandler);
    }
    public static AsyncHttpClient getClient()
    {
        return client;
    }
}
