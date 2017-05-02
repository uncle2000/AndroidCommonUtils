package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 区线
 * Created by 2000 on 2017/4/25.
 */

public class Polyline extends Points<List<Path>> {

    public Polyline(@NonNull List<Path> listP) {
        this(listP, null);
    }

    public Polyline(@NonNull List<Path> listP, Paint paint) {
        super(listP, paint);
        init();
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Path p : (List<Path>) t) {
            canvas.drawPath(p, paint);
        }
    }
}
