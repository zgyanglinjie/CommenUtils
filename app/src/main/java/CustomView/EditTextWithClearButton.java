package CustomView;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.example.jh.commenutils.R;

/**
 * Created by jh on 2015/8/25.
 */
public class EditTextWithClearButton extends EditText implements View.OnFocusChangeListener,TextWatcher {
   Drawable clearDrawable;
   boolean  hasFocus;
//

    public EditTextWithClearButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public EditTextWithClearButton(Context context, AttributeSet attrs) {
      this(context,attrs,android.R.attr.editTextStyle);

    }

    public EditTextWithClearButton(Context context) {
        this(context, null);

    }
    public  void init(){
        clearDrawable=getCompoundDrawables()[2];
        if (clearDrawable==null){
            clearDrawable=getResources().getDrawable(R.drawable.edit_delete);
        }
        clearDrawable.setBounds(0,0,clearDrawable.getIntrinsicWidth(),clearDrawable.getIntrinsicHeight());
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus=hasFocus;
        if (hasFocus){
            Log.e("bbb","删除显示了么"+getText().length());
            setClearIconVisible(getText().toString().length()>0);
        }else{
            Log.e("bbb","删除没显示");
            setClearIconVisible(false);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("bbb","进入evENT了么");
        if (event.getAction()==MotionEvent.ACTION_UP){
            if (getCompoundDrawables()[2]!=null){
                int x=(int)event.getX();
                int y=(int)event.getY();
                Rect rect=getCompoundDrawables()[2].getBounds();
                int height=rect.height();
                int distance=(getHeight()-height)/2;
                boolean isInnerHeight=y>distance&&y<(distance+height);
                boolean isInnerWidth=x>(getWidth()-getTotalPaddingRight())&&x<(getWidth()-getPaddingRight());
                if (isInnerHeight&&isInnerWidth){
                    this.setText("");
                }
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void afterTextChanged(Editable s) {
        if (hasFocus){
            setClearIconVisible(s.length()>0);
        }
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    protected  void setClearIconVisible(boolean visible){
        Drawable right=visible?clearDrawable:null;
        Log.e("bbb",right+"");
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1],right,getCompoundDrawables()[3]);
    }
}
