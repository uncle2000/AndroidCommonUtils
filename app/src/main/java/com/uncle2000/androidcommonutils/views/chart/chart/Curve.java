package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.chart.Points;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.List;

/**
 * 折线
 * Created by 2000 on 2017/4/25.
 */

public class Curve extends Points {

    public Curve(ChartOption chartOption) {
        super(chartOption);
    }

    public void draw(Canvas canvas) {
        canvas.drawLines(toCurve(list), paint);
    }

    /**
     * 画折线
     *
     * @param sa
     * @return
     */
    public static float[] toCurve(List<Point> sa) {
        float[] pts = new float[(sa.size() - 1) * 4];
        for (int i = 0; i < sa.size() - 1; i++) {
            pts[i * 4] = sa.get(i).x;
            pts[i * 4 + 1] = sa.get(i).y;
            pts[i * 4 + 2] = sa.get(i + 1).x;
            pts[i * 4 + 3] = sa.get(i + 1).y;
        }
        return pts;
    }
}
