package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/7.
 */

public class personView extends View {
    private Context m_Context;
    public personView(Context context) {
        super(context);
        this.m_Context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        paint.setColor(Color.GRAY);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setStrokeWidth(5);
        paint1.setColor(Color.WHITE);
        canvas.drawCircle(400,500,100,paint);
        canvas.drawCircle(400,440,30,paint1);
        RectF rectF = new RectF(330,480,470,630);
        canvas.drawArc(rectF,180,180,false,paint1);

        super.onDraw(canvas);
        int baseLineX =0;
        int baseLineY = 200;
        canvas.drawLine(baseLineX,baseLineY,2000,baseLineY,paint);
        paint.setColor(Color.DKGRAY);
        paint.setTextSize(120);
        canvas.drawText("harvic\'s blog",baseLineX,baseLineY,paint);
        Path path = new Path();
        path.moveTo(10,10);
        path.lineTo(10,100);
        path.lineTo(300,100);
        path.close();
        paint1.setColor(Color.RED);
        canvas.drawPath(path,paint1);
    }
}
