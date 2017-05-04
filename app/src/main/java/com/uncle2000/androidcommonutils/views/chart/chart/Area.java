package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;


/**
 * Created by 2000 on 2017/4/25.
 */

public class Area extends Charts {
    private int dataAreaOffset = 10;

    public Area(ChartOption chartOption) {
        super(chartOption);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(toArea(list), paint);
        canvas.drawRect(chartOption.getChartRect(), paint);
    }

    private Rect toArea(List<Point> sa) {
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE, maxx = 0, maxy = 0;
        for (Point p : sa) {
            minx = Math.min(minx, p.x);
            miny = Math.min(miny, p.y);
            maxx = Math.max(maxx, p.x);
            maxy = Math.max(maxy, p.y);
        }
        return new Rect(
                minx - dataAreaOffset,
                miny - dataAreaOffset,
                maxx + dataAreaOffset,
                maxy + dataAreaOffset);
    }

}
