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

    public SparseArray<Path> adjustData2Sa(SparseArray<Point> sa) {
        SparseArray<Path> saP = new SparseArray<>();
        Point startp;
        Point endp;
        for (int i = 0; i < sa.size() - 1; i++) {
            startp = sa.get(i);
            endp = sa.get(i + 1);
            int wt = (startp.x + endp.x) / 2;
            Point p3 = new Point();
            Point p4 = new Point();
            p3.y = startp.y;
            p3.x = wt;
            p4.y = endp.y;
            p4.x = wt;
            Path path = new Path();
            path.moveTo(startp.x, startp.y);
            path.cubicTo(p3.x, p3.y, p4.x, p4.y, endp.x, endp.y);
            saP.put(i, path);
        }
        return saP;
    }

}
