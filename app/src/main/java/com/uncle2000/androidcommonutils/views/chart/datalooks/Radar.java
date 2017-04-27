package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2000 on 2017/4/26.
 */

public class Radar extends Points {
    List<Path> listP = new ArrayList<>();

    public Radar(@NonNull float[] pts) {
        super(pts);
    }

    public Radar(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Path p : listP) {
            canvas.drawPath(p, paint);
        }
    }

//    public float[] adjustData2Pts(SparseArray<Point> sa) {
//
//    }
}
