package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;
import com.uncle2000.androidcommonutils.views.chart.model.NormalOption;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布图
 * Created by 2000 on 2017/4/25.
 */

public class Waterfall extends Pillar {
    int pillarW;

    public Waterfall(DescartesOption dop) {
        super(dop);
    }

    private void init() {
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Rect r : toWaterfall(list, pillarW, anchor)) {
            canvas.drawRect(r, paint);
        }
    }

    /**
     * 画柱子
     *
     * @param sa
     * @return
     */
    public static List<Rect> toWaterfall(List<Point> sa, int pillarW, Anchor anchor) {
        List<Rect> saR = new ArrayList<>();
        Rect rect;
        for (int i = 0; i < sa.size(); i++) {
            rect = new Rect(
                    sa.get(i).x - pillarW,
                    sa.get(i).y,
                    sa.get(i).x + pillarW,
                    anchor.y
            );
            saR.add(rect);
        }
        return saR;
    }

}
