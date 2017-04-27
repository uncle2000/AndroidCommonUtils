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
 * 折线
 * Created by 2000 on 2017/4/25.
 */

public class Polyline extends Points {
    List<Path> listP = new ArrayList<>();

    public Polyline(@NonNull float[] pts) {
        super(pts);
        init();
    }

    public Polyline(@NonNull float[] pts, Paint paint) {
        super(pts, paint);
        init();
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
}
