package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public abstract class Charts {
    ChartOption chartOption;
    protected Anchor anchor;
    protected Paint paint = new Paint();
    protected int xScale, yScale;
    public List<Point> list;

    public Charts(ChartOption chartOption) {
        this.chartOption = chartOption;
        this.anchor = chartOption.anchor;
        this.xScale = chartOption.xScale;
        this.yScale = chartOption.yScale;
        this.list = chartOption.list;
        paint.setStrokeWidth(2f);
    }

    public abstract void draw(Canvas canvas);

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
