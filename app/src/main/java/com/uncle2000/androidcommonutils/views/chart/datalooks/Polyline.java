package com.uncle2000.androidcommonutils.views.chart.datalooks;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.RangeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 区线
 * Created by 2000 on 2017/4/25.
 */

public class Polyline extends Points {

    public Polyline(RangeModel rangeModel) {
        super(rangeModel);
    }

    public Polyline(RangeModel rangeModel, Paint paint) {
        super(rangeModel, paint);
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Path p : toPolyline(rangeModel.list)) {
            canvas.drawPath(p, paint);
        }
    }


    /**
     * 画曲线
     *
     * @param sa
     * @return
     */
    private   List<Path> toPolyline(List<Point> sa) {
        List<Path> saP = new ArrayList<>();
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
            saP.add(path);
        }
        return saP;
    }


}
