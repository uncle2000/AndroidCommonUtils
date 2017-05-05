package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;

import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public abstract class Charts {
    DescartesOption dop;
    protected Anchor anchor;
    protected Paint paint = new Paint();
    protected int xScale, yScale;
    public List<Point> list;

    public Charts(DescartesOption dop) {
        this.dop = dop;
        this.anchor = dop.anchor;
        this.xScale = dop.xScale;
        this.yScale = dop.yScale;
        this.list = dop.list;
        paint.setStrokeWidth(2f);
    }

    public abstract void draw(Canvas canvas);

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
