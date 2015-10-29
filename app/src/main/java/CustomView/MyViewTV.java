package CustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by jh on 2015/8/2
 */
public class MyViewTV extends View {

   private String mtext;
   private int msrc;
    public MyViewTV(Context context) {
        super(context);
    }

    public MyViewTV(Context context, AttributeSet attrs) {
        super(context, attrs);
        int resourceId = 0;
        int textId = attrs.getAttributeResourceValue(null, "Text",0);
        int srcId = attrs.getAttributeResourceValue(null, "Src", 0);
        mtext = context.getResources().getText(textId).toString();
        msrc = srcId;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint=new Paint();
        InputStream in=getResources().openRawResource(msrc);
        Bitmap  bitmap= BitmapFactory.decodeStream(in);
        canvas.drawBitmap(bitmap,0,0,paint);
        int bH=bitmap.getHeight();
        int bw=bitmap.getWidth();
        canvas.drawText(mtext,bw/2,30,paint);
    }
}
