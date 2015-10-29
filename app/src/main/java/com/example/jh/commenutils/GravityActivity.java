package com.example.jh.commenutils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GravityActivity extends ActionBarActivity {
/*添加当重力变化时的处理函数
在创建监听器时调用的函数 doSomething(x, y, z) 是自己定义的方法。
当手机倾斜方向改变时，监听器会调用该方法。
我们要做的，就是填充该方法，用于在重力发生变化时进行我们自己的处理。
当 x=y=0 时，手机处于水平放置状态。
当 x=0 并且 y>0 时，手机顶部的水平位置要大于底部，也就是一般接听电话时手机所处的状态。
当 x=0 并且 y<0 时，手机顶部的水平位置要小于底部。手机一般很少处于这种状态。
当 y=0 并且 x>0 时，手机右侧的水平位置要大于左侧，也就是右侧被抬起。
当 y=0 并且 x<0 时，手机右侧的水平位置要小于左侧，也就是左侧被抬起。
当 z=0 时，手机平面与水平面垂直。
当 z>0 时，手机屏幕朝上。
当 z<0 时，手机屏幕朝下。
senser 传感器
*/
    TextView tv_textView;
    private SensorEventListener mListener = null;
    private SensorManager mManager = null;
    private Sensor mSensor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        tv_textView=(TextView)findViewById(R.id.tv_textView);
        mManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor=mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            public void onSensorChanged(SensorEvent event) {
                float x = event.values[SensorManager.DATA_X];
                float y = event.values[SensorManager.DATA_Y];
                float z = event.values[SensorManager.DATA_Z];
                if (x==0&&x==y){
                    tv_textView.setText("水平"+x+","+y);
                }else if (1>x&&x>-1&&y>0){
                    tv_textView.setText("手机顶部的水平位置要大于底部"+x+","+y);
                }else if (1>x&&x>-1&&y<0){
//                   当 x=0 并且 y<0 时，手机顶部的水平位置要小于底部。手机一般很少处于这种状态。
                    tv_textView.setText("手机顶部的水平位置要小于底部"+x+","+y);
                }else if (1>y&&y>-1&&x>0){
//                   当 y=0 并且 x>0 时，手机右侧的水平位置要大于左侧，也就是右侧被抬起。
//                   当 y=0 并且 x<0 时，手机右侧的水平位置要小于左侧，也就是左侧被抬起。
                    tv_textView.setText("手机右侧的水平位置要大于左侧"+x+","+y);
                }
                else if (1>y&&y>-1&&x<0){
//                   当 y=0 并且 x>0 时，手机右侧的水平位置要大于左侧，也就是右侧被抬起。
//                   当 y=0 并且 x<0 时，手机右侧的水平位置要小于左侧，也就是左侧被抬起。
                    tv_textView.setText("手机右侧的水平位置要小于左侧"+x+","+y);
                }
                else if (z==0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                    tv_textView.setText("手机平面与水平面垂直。"+z);
                }
                else if (z<0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                    tv_textView.setText("手机屏幕朝下。"+z);
                }
                else if (z>0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                    tv_textView.setText("手机屏幕朝上。"+z);
                }
//                doSomething(x, y, z);
            }


            private void doSomething(float x, float y, float z) {
               if (x==0&&x==y){
                   tv_textView.setText("水平"+x+","+y);
               }else if (x==0&&y>0){
                   tv_textView.setText("手机顶部的水平位置要大于底部"+x+","+y);
               }else if (x==0&&y<0){
//                   当 x=0 并且 y<0 时，手机顶部的水平位置要小于底部。手机一般很少处于这种状态。
                   tv_textView.setText("手机顶部的水平位置要小于底部"+x+","+y);
               }else if (y==0&&x>0){
//                   当 y=0 并且 x>0 时，手机右侧的水平位置要大于左侧，也就是右侧被抬起。
//                   当 y=0 并且 x<0 时，手机右侧的水平位置要小于左侧，也就是左侧被抬起。
                   tv_textView.setText("手机右侧的水平位置要大于左侧"+x+","+y);
               }
               else if (y==0&&x<0){
//                   当 y=0 并且 x>0 时，手机右侧的水平位置要大于左侧，也就是右侧被抬起。
//                   当 y=0 并且 x<0 时，手机右侧的水平位置要小于左侧，也就是左侧被抬起。
                   tv_textView.setText("手机右侧的水平位置要小于左侧"+x+","+y);
               }
                else if (z==0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                   tv_textView.setText("手机平面与水平面垂直。"+z+","+y);
               }
               else if (z<0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                   tv_textView.setText("手机屏幕朝下。"+z+","+y);
               }
               else if (z>0){
//                   当 z=0 时，手机平面与水平面垂直。
//                   当 z>0 时，手机屏幕朝上。
//                   当 z<0 时，手机屏幕朝下。
                   tv_textView.setText("手机屏幕朝上。"+z+","+y);
               }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        mManager.registerListener(mListener, mSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mManager.unregisterListener(mListener);
    }
}
