package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


import com.uncle2000.androidcommonutils.views.chart.model.Anchor;

import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public abstract class Charts {
    protected Anchor anchor;
    protected Paint paint;

    public abstract void draw(Canvas canvas, List<Point> list, Paint paint);

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
