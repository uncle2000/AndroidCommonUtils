package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 散点图
 * Created by 2000 on 2017/4/25.
 */

@SuppressWarnings("unchecked")
public class Points<T> extends ChartData {

    public Points(@NonNull T t) {
        this(t, null);
    }

    public Points(@NonNull T t, Paint paint) {
        super(t, paint);
    }

    public void draw(Canvas canvas) {
        this.paint.setStrokeWidth(10f);
        canvas.drawPoints((float[]) t, paint);
    }
}
