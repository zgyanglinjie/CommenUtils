package utils;

import android.util.LruCache;

/**
 * Created by yanglinjie on 2015/12/29.
 */
public class LruCacheUtils {
    private LruCache<String,String> mLruCache;
    int  memorySize=(int)(Runtime.getRuntime().maxMemory()/1024);
    private LruCacheUtils(){
        if (mLruCache==null){
           mLruCache=new LruCache<String,String>(memorySize/16){
               @Override
               protected int sizeOf(String key, String value) {
                   return value.getBytes().length;
               }
           };
        }
    }
    private static class LruCacheUtilsHolder{
        private static  final  LruCacheUtils INSTANCE=new LruCacheUtils();
    }
    public static final LruCacheUtils  getInstance(){
    return LruCacheUtilsHolder.INSTANCE;
    }
    public  void clearCache(){
        if (mLruCache!=null){
            if (mLruCache.size()>0){
                mLruCache.evictAll();
            }
            mLruCache=null;
        }
    }
    public synchronized  void addStringToMomery(String key,String value){
          if (mLruCache.get(key)==null){
              if (key!=null&&value!=null)
                  mLruCache.put(key,value);
          }
    }
    public synchronized String getStringFromMomery(String key){
               String value=mLruCache.get(key);
              if (value!=null)
                  return value;
        return null;
    }
    public synchronized void removeString(String key){
           if (key!=null){
               if (mLruCache!=null){
                mLruCache.remove(key);
           }
           }
    }

}
