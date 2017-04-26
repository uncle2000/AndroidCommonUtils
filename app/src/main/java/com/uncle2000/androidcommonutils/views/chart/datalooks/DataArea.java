package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * Created by 2000 on 2017/4/25.
 */

public class DataArea extends Points {
    SparseArray<Rect> saR;

    public DataArea(@NonNull float[] pts) {
        super(pts);
        init();
    }

    public DataArea(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
        init();
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
//        saR = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {

    }


    public SparseArray<Rect> adjustData2Sa(SparseArray<Point> sa) {

        return saR;
    }


//    private void drawDataPadding(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX - lPadding, minRangeY - tPadding, maxRangeX + rPadding, minRangeY - tPadding,
//                maxRangeX + rPadding, minRangeY - tPadding, maxRangeX + rPadding, maxRangeY + bPadding,
//                maxRangeX + rPadding, maxRangeY + bPadding, minRangeX - lPadding, maxRangeY + bPadding,
//                minRangeX - lPadding, maxRangeY + bPadding, minRangeX - lPadding, minRangeY - tPadding,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }
//
//    private void drawDataArea(Canvas canvas) {
//        mDatapaint.setStrokeWidth(1f);
//        float[] pts = new float[]{
//                minRangeX, minRangeY, maxRangeX, minRangeY,
//                maxRangeX, minRangeY, maxRangeX, maxRangeY,
//                maxRangeX, maxRangeY, minRangeX, maxRangeY,
//                minRangeX, maxRangeY, minRangeX, minRangeY,
//        };
//        canvas.drawLines(pts, mDatapaint);
//    }


}
