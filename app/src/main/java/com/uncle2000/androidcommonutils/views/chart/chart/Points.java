package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Point;


import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;

/**
 * 散点图
 * Created by 2000 on 2017/4/25.
 */

@SuppressWarnings("unchecked")
public class Points extends Charts {

    public Points(ChartOption chartOption) {
        super(chartOption);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setStrokeWidth(5f);
        canvas.drawPoints(toPoints(list), paint);
    }

    /**
     * 画散点
     *
     * @param sa
     * @return
     */
    private float[] toPoints(List<Point> sa) {
        float[] pts = new float[sa.size() * 2];
        for (int i = 0; i < sa.size(); i++) {
            pts[i * 2] = sa.get(i).x;
            pts[i * 2 + 1] = sa.get(i).y;
        }
        return pts;
    }
}
