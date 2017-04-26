package com.uncle2000.androidcommonutils.views.chart.data;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 瀑布图
 * Created by 2000 on 2017/4/25.
 */

public class Waterfall extends Points {
    int pillarW = 5;
    SparseArray<Rect> saR;

    public Waterfall(@NonNull float[] pts) {
        super(pts);
        init();
    }

    public Waterfall(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
        init();
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
//        saR = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < saR.size() - 1; i++) {
            canvas.drawRect(saR.get(i), paint);
        }
    }

    public SparseArray<Rect> adjustData2Sa(SparseArray<Point> sa) {
        SparseArray<Rect> saR = new SparseArray<>();
        Rect rect;
//        ConvertData.pointA2RectA(chartDataCopy, pillarW);
        return saR;
    }

}
