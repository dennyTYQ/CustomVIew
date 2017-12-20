package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/19.
 */

public class GuaguaCardView extends View {
    private Paint mPaint;
    private Bitmap dstBitmap,srcBitmap,textBitmap;
    private Path path;
    private float mPreX,mPrexY;
    public GuaguaCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(45);
        textBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.l,null);
        srcBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.tupian,null);
        dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(textBitmap,0,0,mPaint);
        int layoutID = canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        Canvas c = new Canvas(dstBitmap);
        c.drawPath(path,mPaint);
        canvas.drawBitmap(dstBitmap,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(srcBitmap,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layoutID);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            {
                path.moveTo(event.getX(),event.getY());
                mPreX = event.getX();
                mPrexY= event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                float endX = (mPreX+event.getX())/2;
                float endY = (mPrexY+event.getY())/2;
                path.quadTo(mPreX,mPrexY,endX,endY);
                mPreX = event.getX();
                mPrexY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
