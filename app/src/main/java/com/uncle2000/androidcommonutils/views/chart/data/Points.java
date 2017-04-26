package com.uncle2000.androidcommonutils.views.chart.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 散点图
 * Created by 2000 on 2017/4/25.
 */

public class Points extends ChartData {
    protected Paint paint;
    protected float[] pts;

    public Points(@NonNull float[] pts) {
        this.pts = pts;
        paint = new Paint();
        paint.setStrokeWidth(1.2f);
    }

    public Points(@NonNull float[] pts, Paint paint) {
        this.pts = pts;
        if (null != paint)
            this.paint = paint;
    }

    public void draw(Canvas canvas) {
        canvas.drawPoints(pts, paint);
    }

    public static float[] adjustData2Pts(SparseArray<Point> sa) {
        float[] pts = new float[sa.size() * 2];
        for (int i = 0; i < sa.size(); i++) {
            pts[i * 2] = sa.get(i).x;
            pts[i * 2 + 1] = sa.get(i).y;
        }
        return pts;
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
