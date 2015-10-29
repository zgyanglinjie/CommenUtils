package CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.example.jh.commenutils.ScreenTools;

import java.util.List;

/**
 * Created by jh on 2015/9/1.
 */
public class CastomWeiXinNineGridlayout extends ViewGroup {

    /**
     * 图片之间的间隔
     */
    private int gap = 5;
    private int columns;//
    private int rows;//
    private List listData;
    private int totalWidth;
    public CastomWeiXinNineGridlayout(Context context) {
        this(context,null);
    }
    public CastomWeiXinNineGridlayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        ScreenTools screenTools=ScreenTools.instance(getContext());
        totalWidth=screenTools.getScreenWidth()-screenTools.dip2px(80);
    }
    public CastomWeiXinNineGridlayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }
}
