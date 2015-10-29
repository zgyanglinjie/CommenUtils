package utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by yanglinjie on 2015/8/5.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override

    public void onReceive(Context context, Intent intent) {
        if (!isNetworkAvailable(context)) {
            Toast.makeText(context, "network disconnected!", Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(context, "network connected!", Toast.LENGTH_LONG).show();
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = mgr.getAllNetworkInfo();
        if (info != null) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
