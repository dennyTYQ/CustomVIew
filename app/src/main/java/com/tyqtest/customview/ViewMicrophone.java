package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/8.
 */

public class ViewMicrophone extends View {
    private Context m_context;
    public ViewMicrophone(Context context) {
        super(context);
        this.m_context=context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(5);
        Paint paint1 = new Paint();
        paint1.setColor(Color.GRAY);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(7);
        int BaseX = getWidth();
        int BaseY = getHeight();
        canvas.drawCircle(getWidth()/2,getWidth()/2,90,paint);
        Path path = new Path();
        path.moveTo(BaseX/2-150,BaseX/2+270);
        path.lineTo(BaseX/2-30,BaseX/2+110);


        path.lineTo(BaseX/2-60,BaseX/2+94);
        path.close();
        canvas.drawPath(path,paint1);

        super.onDraw(canvas);
    }
}
