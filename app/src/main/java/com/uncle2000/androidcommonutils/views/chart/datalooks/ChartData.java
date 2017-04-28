package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;

import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData<T> {
    protected float offsetX, offsetY;
    protected float scale;
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

    public Anchor mkAnchor(@NonNull @Size(min = 1) List<Points> list) {
        Anchor anchor = new Anchor();


        return anchor;
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
