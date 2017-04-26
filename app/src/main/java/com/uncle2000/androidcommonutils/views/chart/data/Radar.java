package com.uncle2000.androidcommonutils.views.chart.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/4/26.
 */

public class Radar extends Points {
    public Radar(@NonNull float[] pts) {
        super(pts);
    }

    public Radar(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLines(pts, paint);
    }

//    public float[] adjustData2Pts(SparseArray<Point> sa) {
//
//    }
}
