package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/7.
 */

public class MyView extends View {
    private  Context m_Context;
    public MyView(Context context) {
        super(context);
        m_Context = context;
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint_green  = generatePaint(Color.GREEN, Paint.Style.STROKE,3);
        Paint paint_rea = generatePaint(Color.RED, Paint.Style.STROKE,3);
        Rect rect1 = new Rect(300,10,500,100);
        canvas.drawRect(rect1,paint_rea);
        canvas.rotate(30);
        canvas.drawRect(rect1,paint_green);
    }
    private Paint generatePaint(int color ,Paint.Style style, int width){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}

