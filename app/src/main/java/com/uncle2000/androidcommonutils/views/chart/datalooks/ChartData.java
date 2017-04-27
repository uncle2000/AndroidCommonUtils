package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData {
    protected Paint paint;
    protected float[] pts;

    public ChartData(@NonNull float[] pts) {
        this(pts, null);
    }

    public ChartData(float[] pts, Paint paint) {
        this.paint = paint;
        this.pts = pts;
        if (null != paint)
            this.paint = paint;
        else
            paint = new Paint();
        paint.setStrokeWidth(1.2f);
    }

    public void draw(Canvas canvas) {

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public float[] getPts() {
        return pts;
    }

    public void setPts(float[] pts) {
        this.pts = pts;
    }
}
