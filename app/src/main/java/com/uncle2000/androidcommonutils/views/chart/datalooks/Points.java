package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;

import java.util.List;

/**
 * 散点图
 * Created by 2000 on 2017/4/25.
 */

@SuppressWarnings("unchecked")
public class Points extends ChartData {


    public Points(RangeModel rangeModel) {
        super(rangeModel);
    }

    public Points(RangeModel rangeModel, Paint paint) {
        super(rangeModel, paint);
    }

    public void draw(Canvas canvas) {
        this.paint.setStrokeWidth(10f);
        canvas.drawPoints(toPoints(rangeModel.list), paint);
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
