package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/19.
 */

public class ViewOfPS extends View {
   private  int Width= 400;
    private int Height = 400;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Paint mPaint;

    public ViewOfPS(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mPaint= new Paint();
        srcBitmap = makeSrc(Width,Height);
        dstBitmap = makeDst(Width,Height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layoutID = canvas.saveLayer(0,0,Width*2,Height*2,mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        canvas.drawBitmap(srcBitmap,Width/2,Height/2,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layoutID);
    }

    static Bitmap makeSrc(int w, int h){
        Bitmap bm = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xffffcc44);
        c.drawOval(new RectF(0,0,w,h),p);
        return bm;
    }

    static Bitmap makeDst(int w,int h){
        Bitmap bm = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xff66aaff);
        c.drawRect(0,0,w,h,p);
        return bm;
    }

}
