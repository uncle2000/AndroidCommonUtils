package com.uncle2000.androidcommonutils.views.chart.data;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import static com.uncle2000.androidcommonutils.views.chart.utils.DefaultData.chartDataCopy;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DashLine extends Points {
    int phase = 0;
    SparseArray<Path> saP;

    public DashLine(@NonNull float[] pts) {
        super(pts);
        init();
    }

    public DashLine(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
        init();
    }

    private void init() {
        //设置画直线格式
        paint.setStyle(Paint.Style.STROKE);
        //设置虚线效果
        paint.setPathEffect(new DashPathEffect(new float[]{25, 25}, phase));

//        saP = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < saP.size() - 1; i++) {
            canvas.drawPath(saP.get(i), paint);
        }
    }

    public SparseArray<Path> adjustData2Sa(SparseArray<Point> sa) {
        SparseArray<Path> saP = new SparseArray<>();
        Path path = new Path();
        for (int i = 0; i < sa.size() * 2; i++) {
            path.moveTo(chartDataCopy[i].x, chartDataCopy[i].y);
            if (i % 2 == 0) {
//                path.lineTo(minTableX, chartDataCopy[i].y);
            } else {
//                path.lineTo(chartDataCopy[i].x, maxTableY);
            }
            saP.put(i, path);
        }
        return saP;
    }
}
