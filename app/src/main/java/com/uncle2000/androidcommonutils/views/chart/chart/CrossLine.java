package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;

import java.util.List;

/**
 * 以点画十字
 * Created by 2000 on 2017/4/25.
 */

public class CrossLine extends Points {

    public CrossLine(DescartesOption dop) {
        super(dop);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setStrokeWidth(3f);
        canvas.drawLines(toCrossLine(list, 10), paint);
    }

    private float[] toCrossLine(List<Point> sa, float crossLineW) {
        float[] pts = new float[sa.size() * 8];
        for (int i = 0; i < sa.size(); i++) {
            pts[i * 8 + 0] = sa.get(i).x - crossLineW;
            pts[i * 8 + 1] = sa.get(i).y;
            pts[i * 8 + 2] = sa.get(i).x + crossLineW;
            pts[i * 8 + 3] = sa.get(i).y;
            pts[i * 8 + 4] = sa.get(i).x;
            pts[i * 8 + 5] = sa.get(i).y - crossLineW;
            pts[i * 8 + 6] = sa.get(i).x;
            pts[i * 8 + 7] = sa.get(i).y + crossLineW;
        }
        return pts;
    }

}
