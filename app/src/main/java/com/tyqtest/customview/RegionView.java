package com.tyqtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.view.View;

/**
 * Created by 谭雅清 on 2017/12/11.
 */

public class RegionView extends View {
    private Context m_context ;
    public RegionView(Context context) {
        super(context);
        this.m_context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        RectF rectF = new RectF(50,50,200,500);
        path.addOval(rectF, Path.Direction.CCW);
        Region region = new Region();
       // region.setPath(path,new Region(50,50,200,200));
        draw(canvas, paint, region);


        Rect rect1 = new Rect(100,100,400,200);
        Rect rect2 = new Rect(200,0,300,300);
        Paint paint1 = new Paint();
        paint1.setStrokeWidth(9);
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect1,paint1);
        canvas.drawRect(rect2,paint1);
        ///canvas.rotate(-60);
       /* canvas.drawRect(rect1,paint1);
        canvas.drawRect(rect2,paint1);
        canvas.rotate(-60);
       */
        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.XOR);
        Paint paint2 = new Paint();
        paint2.setColor(Color.GREEN);
        paint2.setStyle(Paint.Style.FILL);
        draw(canvas,paint2,region1);
     /*   canvas.rotate(30);
        draw(canvas,paint2,region1);
     */
            super.onDraw(canvas);
    }

    public void draw(Canvas canvas, Paint paint, Region region) {
        RegionIterator iterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (iterator.next(rect)){
            canvas.drawRect(rect,paint);
        }
    }
}
