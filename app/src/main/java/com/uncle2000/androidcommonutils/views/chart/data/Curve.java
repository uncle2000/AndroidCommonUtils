package com.uncle2000.androidcommonutils.views.chart.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 曲线
 * Created by 2000 on 2017/4/25.
 */

public class Curve extends Points {

    public Curve(@NonNull float[] pts) {
        super(pts);
    }

    public Curve(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLines(pts, paint);
    }

    public static float[] adjustData2Pts(SparseArray<Point> sa) {
        float[] pts = new float[(sa.size() - 1) * 4];
        for (int i = 0; i < sa.size() - 1; i++) {
            pts[i * 4] = sa.get(i).x;
            pts[i * 4 + 1] = sa.get(i).y;
            pts[i * 4 + 2] = sa.get(i + 1).x;
            pts[i * 4 + 3] = sa.get(i + 1).y;
        }
        return pts;
    }
}
