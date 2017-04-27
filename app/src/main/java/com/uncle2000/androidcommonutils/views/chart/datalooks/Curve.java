package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 折线
 * Created by 2000 on 2017/4/25.
 */

public class Curve extends Points<float[]> {

    public Curve(@NonNull float[] pts) {
        super(pts);
    }

    public Curve(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
    }


    public void draw(Canvas canvas) {
        canvas.drawLines((float[]) t, paint);
    }

}
