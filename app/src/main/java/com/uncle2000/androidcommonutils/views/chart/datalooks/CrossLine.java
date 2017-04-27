package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 以点画十字
 * Created by 2000 on 2017/4/25.
 */

public class CrossLine extends Points<float[]> {

    public CrossLine(@NonNull float[] pts) {
        this(pts, null);
    }

    public CrossLine(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLines((float[]) t, paint);
    }

}
