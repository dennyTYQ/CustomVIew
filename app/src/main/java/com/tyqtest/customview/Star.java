package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 *
 *
 *
 *
 *
 * Created by 谭雅清 on 2017/12/11.
 */

public class Star extends View {
    private Context context;
    public Star(Context context) {
        super(context);
        this.context = context;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        Path path = new Path();
        int heigth = getHeight();
        int width = getWidth();
        path.moveTo(width/2,heigth/2-160);
        path.lineTo(width/2-40,heigth/2);
        path.lineTo(width/2,heigth/2 +160);
        path.lineTo(width/2+40,heigth/2);
        path.close();

        canvas.drawPath(path,paint);
      for (int i = 0; i<=2 ; i ++ ){
            canvas.rotate(90,width/2,heigth/2);
            canvas.drawPath(path,paint);

        }
       super.onDraw(canvas);
    }

}
