package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/7.
 */

public class BasicImage extends View {
    private Context context;
    public BasicImage(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
       // paint.setShadowLayer(30,100,220,Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        //canvas.drawLine(100,100, 200,200,paint);
       // canvas.drawPoint(200,220,paint);
       // RectF rectF = new RectF(300,100,200,200);
       // canvas.drawRect(rectF,paint);
      //  canvas.drawRoundRect(220,240,600,350,3,20,paint);
        //canvas.drawCircle(410,240,100,paint);
        //canvas.drawLine(300,300,100,460,paint);
      //  canvas.drawLine(99,457,110,470,paint);
      /*    RectF rectF1 = new RectF(390,370,430,750);
        canvas.rotate(4);
        canvas.drawCircle(410,240,100,paint);
        canvas.rotate(4);
        canvas.drawRect(rectF1,paint);*/
        super.onDraw(canvas);
        int Width = 900;
        int height = 900;
        RectF rectF = new RectF(300,300,600,600);

        canvas.drawArc(rectF,-75,330,false,paint);
        canvas.drawLine(450,250,450,420,paint);

    }
}
