package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

/**
 * 折线
 * Created by 2000 on 2017/4/25.
 */

public class Polyline extends Points {
    SparseArray<Path> saP;

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
//        saP = adjustData2Sa(pts);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < saP.size() - 1; i++) {
            canvas.drawPath(saP.get(i), paint);
        }
    }


}
