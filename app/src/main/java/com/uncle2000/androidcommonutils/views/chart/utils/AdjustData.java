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
        float angle = 360 / num;
        List<Point> temp = new ArrayList<>();
        for (int i = 0; i < orign.size(); i++) {
            Point p = Utils.getPoint(anchor.x, anchor.y, angle * i, orign.get(i) / scale);
            temp.add(p);
        }
        List<Path> list = new ArrayList<>();
        Path path = new Path();
        int buck = temp.size() / num;
        for (int i = 0; i < buck; i++) {
            path.moveTo(temp.get(i * num).x, temp.get(i * num).y);
            for (int j = 1; j < num; j++) {
                path.lineTo(temp.get(i* num + j).x, temp.get(i* num + j).y);
            }
            path.lineTo(temp.get(i * num).x, temp.get(i * num).y);
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
