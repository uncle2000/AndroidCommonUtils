package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;

import java.util.List;

/**
 * 横线段
 * Created by 2000 on 2017/4/25.
 */

public class HorizontalLines extends Points {

    public HorizontalLines(DescartesOption dop) {
        super(dop);
    }

    @Override
    public void draw(Canvas canvas) {
       canvas.drawLines(toHorizontal(list), paint);
    }

    /**
     * 画横线
     *
     * @param sa
     * @return
     */
    public static float[] toHorizontal(List<Point> sa) {
        float[] pts = new float[(sa.size() - 1) * 4];
        for (int i = 0; i < sa.size() - 1; i++) {
            pts[i * 4] = sa.get(i).x;
            pts[i * 4 + 1] = sa.get(i).y;
            pts[i * 4 + 2] = sa.get(i + 1).x;
            pts[i * 4 + 3] = sa.get(i).y;
        }
        return pts;
    }
}
