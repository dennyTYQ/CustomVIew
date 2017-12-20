package com.tyqtest.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by 谭雅清 on 2017/12/12.
 */

public class ViewOfQuade extends View {
    private Path m_Path = new Path();
    private float mPreX,mPreY;
    int mItemWaveLength = 400;
    int dx;
    public ViewOfQuade(Context context) {
        super(context);
    }

   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
       *//* switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                m_Path.moveTo(event.getX(),event.getY());
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                m_Path.lineTo(event.getX(),event.getY());
                postInvalidate();
                break;
            default:
                break;
        }*//*
        *//*switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                m_Path.moveTo(event.getX(),event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE:

            {
                float ednX = (mPreX+event.getX())/2;
                float endY = (mPreY+event.getY())/2;
                m_Path.quadTo(mPreX,mPreY,ednX,endY);
                mPreY = event.getY();
                mPreX= event.getX();
                invalidate();
            }
            break;
            default:
                break;


        }
        *//*return super.onTouchEvent(event);
    }
*/
    public ViewOfQuade(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(100,300);
        path.rQuadTo(100,-100,200,0);
        path.rQuadTo(100,100,200,0);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(9);
        Path path1 = new Path();
        int originY =300;
        int halfWaveLen = mItemWaveLength/2;
        path1.moveTo(-mItemWaveLength,originY);
        for ( int i = -mItemWaveLength;i <= getWidth()+mItemWaveLength; i+=mItemWaveLength){

             path1.rQuadTo( halfWaveLen/2, -50,halfWaveLen,0);
             path1.rQuadTo(halfWaveLen/2,50 ,halfWaveLen,0);

        }
        path1.lineTo(getWidth(),getHeight());
        path1.lineTo(0,getHeight());
        path.close();


        canvas.drawPath(path1,paint);
       // canvas.drawPath(m_Path,paint);


    }


    public void startAnim(){
        final ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                  dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    public void reset(){
        m_Path.reset();
        invalidate();
    }
}
