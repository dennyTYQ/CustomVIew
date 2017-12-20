package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/14.
 */

public class ViewOfXfermode extends View {
    private Paint paint;
    private Bitmap bitmap;

    public ViewOfXfermode(Context context) {
        super(context);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
      //  setLayerType(View.LAYER_TYPE_SOFTWARE,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = 500;
        int height = width*bitmap.getHeight()/bitmap.getWidth();
        paint.setColor(Color.RED);
        int layerId = canvas.saveLayer(0,0,width,height,paint,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitmap,null,new Rect(0,0,width,height),paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        canvas.drawRect(0,0,width,height,paint);
        canvas.restoreToCount(layerId);
    }
}
