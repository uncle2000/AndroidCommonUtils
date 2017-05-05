package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2000 on 2017/5/5.
 */

public class Area extends Polyline {

    public Area(DescartesOption dop) {
        super(dop);
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xffff00ff);
        for (Path p : toArea(list, anchor, true)) {
            canvas.drawPath(p, paint);
            paint.setColor(paint.getColor() - 3333 );
        }
    }

    public static List<Path> toArea(List<Point> sa, Anchor anchor, boolean toX) {
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
            if (toX) {
                path.lineTo(endp.x, anchor.y);
                path.lineTo(startp.x, anchor.y);
                path.lineTo(startp.x, startp.y);
            } else {
                path.lineTo(anchor.x, endp.y);
                path.lineTo(anchor.x, startp.y);
                path.lineTo(startp.x, startp.y);
            }
            saP.add(path);
        }
        return saP;
    }
}
