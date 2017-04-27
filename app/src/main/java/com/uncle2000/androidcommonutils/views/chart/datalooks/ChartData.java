package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData<T> {
    protected Paint paint;
    protected T t;

    public ChartData(@NonNull T t) {
        this(t, null);
    }

    public ChartData(@NonNull T t, Paint paint) {
        this.paint = paint;
        this.t = t;
        if (null == paint)
            paint = new Paint();
        this.paint = paint;
    }

    public void draw(Canvas canvas) {

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public T getPts() {
        return t;
    }

    public void setPts(T t) {
        this.t = t;
    }
}
