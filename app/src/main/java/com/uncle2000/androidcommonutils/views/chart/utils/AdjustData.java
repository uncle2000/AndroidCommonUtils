package com.uncle2000.androidcommonutils.views.chart.utils;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.views.chart.model.Anchor;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数据调整成适合图表自身的样子
 * Created by 2000 on 2017/4/26.
 */

public class AdjustData {

    public static List<Point> adjustData2Px(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor, float scaleX, float scaleY) {
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            temp.add(new Point(
                    (int) (anchor.x + (p.x - anchor.xMath) / scaleX),
                    (int) (anchor.y - (p.y - anchor.yMath) / scaleY)
            ));
        }
        return temp;
    }

    public static List<Path> adjustData2RadarPx(@NonNull @Size(min = 1) List<Float> orign, Anchor anchor, int num, float scale) {
        if (orign.size() / num <= 0) {
            throw new IllegalArgumentException();
        }
        List<Point> temp = new ArrayList<>();
        for (float f : orign) {
            Point p = Utils.getPoint(anchor.x, anchor.y, 360 / num, f / scale);
            temp.add(p);
        }
        List<Path> list = new ArrayList<>();
        Path path = new Path();
        for (int i = 0; i < temp.size() / num; i++) {
            path.moveTo(temp.get(i).x, temp.get(i).y);
            for (int j = 0; j < num; j++) {
                path.lineTo(temp.get(i + j).x, temp.get(i + j).y);
            }
            list.add(path);
        }

        return list;
    }

    public static List<Point> reversalData(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor,
                                           boolean reversalX, boolean reversalY) {
        if (!reversalX && !reversalY) {
            return orign;
        }
        int x, y;
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            if (reversalX) {
                y = 2 * anchor.y - p.y;
            } else {
                y = p.y;
            }
            if (reversalY) {
                x = 2 * anchor.x - p.x;
            } else {
                x = p.x;
            }
            temp.add(new Point(x, y));
        }
        return temp;
    }

    public static List<Point> px2MathPoint(@NonNull @Size(min = 1) List<Point> orign, Anchor anchor, float scaleX, float scaleY) {
        List<Point> temp = new ArrayList<>();
        for (Point p : orign) {
            temp.add(new Point(
                    (int) (anchor.xMath + scaleX * (p.x - anchor.x)),
                    (int) (anchor.yMath + scaleY * (anchor.y - p.y))
            ));
        }
        return temp;
    }


}
