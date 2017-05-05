package com.uncle2000.androidcommonutils.views.chart.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱状
 * Created by 2000 on 2017/4/25.
 */

public class Pillar extends Points {
    int pillarW = 5;

    public Pillar(ChartOption chartOption) {
        super(chartOption);
    }

    @Override
    public void draw(Canvas canvas) {
        for (Rect r : toPillar(list, pillarW, anchor)) {
            canvas.drawRect(r, paint);
        }
    }

    /**
     * 画柱子
     *
     * @param sa
     * @return
     */
    public static List<Rect> toPillar(List<Point> sa, int pillarW, Anchor anchor) {
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
