package com.example.jh.commenutils;

import android.app.Activity;
import android.provider.SyncStateContract;
import android.os.Bundle;
import android.util.Log;
import java.security.Key;
import utils.AESEncryption;
import utils.AESUtil;
import utils.Base642;
public class EncryptActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        Key k = AESUtil.toKey("apptest1apptest1".getBytes());
        try {
            byte[] encryptData = AESUtil.encrypt("gome7777".getBytes(), k);
//            Log.e("bbb",Hex.encodeHexStr(encryptData));
              Log.e("bbb", AESEncryption.encrypt("app_testapp_test","gome7777"));
//              Byte[] str=AESEncryption.encrypt("app_testapp_test","gome7777").getBytes();
               String str=new String(Base642.encode(AESEncryption.encrypt("app_testapp_test", "gome7777").getBytes()));
               Log.e("bbb", str);
//             Log.e("bbb", AESEncryption.decrypt("apptest1apptest1",AESUtil2.encrypt("apptest1apptest1","gome7777")));
//            Log.e("bbb"  new String(AESUtil.decrypt(Hex.encodeHexStr(encryptData).getBytes(),k)));
//            Log.e("bbb","解碼后AESUtil："+new String(AESUtil.decrypt("AE5F09675B9BFD808B8678C44800A8FF".getBytes(),k)));
//            Log.e("bbb",AESEncryption.encrypt("apptest1apptest1","gome7777"));
//            Log.e("bbb","解碼后："+ AESEncryption.decrypt("apptest1apptest1", "AE5F09675B9BFD808B8678C44800A8FF"));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("bbb",e.getMessage());
        }
    }


}
