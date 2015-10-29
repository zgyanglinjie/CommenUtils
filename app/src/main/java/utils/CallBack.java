package utils;

/**
 * Created by jh on 2015/7/27.
 * 1，写一个接口
 * 2，接口中写需要的抽象方法
 * 3，提供一个方法
 * 4,调用这个接口
 *
 */
public class CallBack {
     CallBackExecutor executor;
    public interface  CallBackExecutor{
        public void click();
    }
   public void setExecutor(CallBackExecutor executor){
       executor.click();
   }
}
