package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/7.
 */

public class SeconView extends View {
    public SeconView(Context context) {
        super(context);
    }

    public SeconView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SeconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint bg = new Paint();
        int [] colors;
        colors = new int[]{Color.BLUE, Color.GREEN, Color.RED, Color.CYAN ,Color.DKGRAY,Color.GRAY};


        bg.setColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();
        Rect bgR = new Rect(0,0, width, height);
        canvas.drawRect(bgR,bg);
        float start = 0f;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        for (int i = 0; i < 4; i ++){
            RectF bigOval = new RectF(500,600,700,800);
            paint.setColor(colors[i]);
            paint.setStrokeWidth(90);
            canvas.drawArc(bigOval,start,90,true,paint);
            RectF litterOval = new RectF(100,200,300,400);
            paint.setColor(colors[i+2]);
            paint.setShadowLayer(15,20,30,Color.CYAN);
          //
            //  canvas.drawArc(litterOval,start,90,true,paint);
            start+=90f;
        }
        super.onDraw(canvas);

    }
}
