package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/11.
 */

public class ViewOfRotate extends View {
    private Context  m_context;
    public ViewOfRotate(Context context) {
        super(context);
        this.m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setColor(Color.GREEN);
        int height = getHeight();
        int width = getWidth();
        canvas.drawCircle(width/2,height/2,100,paint);
        canvas.drawCircle(width/2,width/2-200,40,paint);
         for (int i = 0;i <=6; i++ ){
             canvas.rotate(60,width/2,height/2);
             canvas.drawCircle(width/2,width/2-200,40,paint);
         }
        super.onDraw(canvas);
    }
}
