package CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.example.jh.commenutils.R;
import com.nostra13.universalimageloader.utils.L;

/**
 * Created by jh on 2015/8/21.
 */
public class SlideButton extends View {
    Bitmap slideButton;
    Bitmap switchBg;
    boolean currenstate=false;
    int  currentX;
    boolean isSliding=false;
    OnToggleStateChangeListener   mListen;
    public SlideButton(Context context) {
        super(context);
    }

    public SlideButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context,attrs);
    }

    public SlideButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
   void  initData(Context context, AttributeSet attrs){
       slideButton= BitmapFactory.decodeResource(getResources(), R.drawable.slide_button_background);
     switchBg=BitmapFactory.decodeResource(getResources(),R.drawable.switch_background);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isSliding=true;
                currentX=(int)event.getX();
                Log.e("bbb","开始距离："+currentX);
                break;
            case MotionEvent.ACTION_MOVE:
                currentX=(int)event.getX();
                break;
            case MotionEvent.ACTION_UP:
                Log.e("bbb","滑动距离："+currentX);
                isSliding=false;
                int switchCenten=switchBg.getWidth()/2;
                boolean state=currentX>=switchCenten;
                if (state!=currenstate&&mListen!=null){
                    mListen.changlistener(state);
                }
               currenstate=state;
                break;
        }
         invalidate();
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(switchBg.getWidth(),switchBg.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(switchBg, 0, 0, null);
        // 2，绘制滑动块显示的位置，开启或关闭
        if (isSliding) {
            int left = currentX - slideButton.getWidth() / 2; // 处理手指触点，将触点从slidingButton的左边移动到中间
            if (left < 0) {
                left = 0;
            } else if (left > switchBg.getWidth() - slideButton.getWidth()) {
                left = switchBg.getWidth() - slideButton.getWidth();
            }
            canvas.drawBitmap(slideButton, left, 0, null);
        } else {
            if (currenstate) {
                // 绘制打开状态
                canvas.drawBitmap(slideButton, switchBg.getWidth() - slideButton.getWidth(), 0, null);
            } else {
                // 绘制关闭状态
                canvas.drawBitmap(slideButton, 0, 0, null);
            }
        }
    }

    public  interface  OnToggleStateChangeListener{
        abstract  void  changlistener(boolean state);
    }

    public void setToggleState(boolean b) {
        currenstate = b;
    }

    /**
     * 对外设置监听方法
     *
     * @param listener
     */
    public void setOnToggleStateChangeListener(OnToggleStateChangeListener listener) {
        this.mListen = listener;
    }
}
