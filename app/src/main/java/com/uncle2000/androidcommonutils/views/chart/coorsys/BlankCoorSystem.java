package com.uncle2000.androidcommonutils.views.chart.coorsys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;

/**
 * 不一定所有的数据表格都需要坐标轴的称托，所以才需要一个什么都不画的类
 * 当然关键还是View绘制子类的时候方便拓展程序
 * Created by 2000 on 2017/4/25.
 */

public class BlankCoorSystem extends View {
    Paint paint = new Paint();
    ChartOption chartOption;
    Anchor anchor;
    Charts[] charts;
    List<Point> list;

    public BlankCoorSystem(Context context) {
        super(context);
        this.anchor = new Anchor();
    }

    public BlankCoorSystem(Context context, ChartOption chartOption) {
        super(context);
        this.chartOption = chartOption;
        this.list = chartOption.list;
        this.anchor = chartOption.anchor;
        this.charts = chartOption.charts;
    }

    public void draw(Canvas canvas) {
        drawAnchor(canvas);
    }

    private void drawAnchor(Canvas canvas) {
        if (null != anchor)
            canvas.drawText(anchor.getText(),
                    anchor.x + anchor.getTextOffsetX(),
                    anchor.y + anchor.getTextOffsetY(),
                    anchor.getAnchorPaint());

        if (null != charts)
            for (Charts c : charts) {
                c.draw(canvas, list, paint);
            }
    }
}
