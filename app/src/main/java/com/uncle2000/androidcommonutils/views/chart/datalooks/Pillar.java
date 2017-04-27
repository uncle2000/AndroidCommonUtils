package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 柱状
 * Created by 2000 on 2017/4/25.
 */

public class Pillar extends Points {
    int pillarW = 5;
    SparseArray<Rect> saR;

    public Pillar(@NonNull float[] pts) {
        super(pts);
    }

    public Pillar(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
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

}
