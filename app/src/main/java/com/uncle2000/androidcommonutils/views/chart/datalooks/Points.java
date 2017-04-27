package com.uncle2000.androidcommonutils.views.chart.datalooks;

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

    public Points(@NonNull float[] pts) {
        this(pts, null);
    }

    public Points(@NonNull float[] pts, Paint paint) {
        super(pts);
    }

    public void draw(Canvas canvas) {
        canvas.drawPoints(pts, paint);
    }
}
