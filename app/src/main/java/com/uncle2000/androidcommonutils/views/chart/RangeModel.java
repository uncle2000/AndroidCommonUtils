package com.uncle2000.androidcommonutils.views.chart;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.uitls.equipment.ScreenUtils;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

import java.util.List;

/**
 * Created by 2000 on 2017/5/2.
 */

public class RangeModel {
    public List<Point> list;
    public Anchor anchor = new Anchor();
    public int xScale = 1, yScale = 1;
    public int width = 1080;
    public int height = 600;
    public float minRangeX, maxRangeX, minRangeY, maxRangeY;
    public int lPadding, tPadding, rPadding, bPadding;
    protected int screenW, screenH;

    public RangeModel(Context context, List<Point> list) {
        this(context, list, 1080, 600, 1, 1, 100, 500, 0, 0);
    }

    public RangeModel(Context context, List<Point> list,
                      float width, float height) {
        this(context, list, width, height, 1, 1, 100, height - 100, 0, 0);
    }

    public RangeModel(Context context, List<Point> list,
                      float width, float height,
                      float xScale, float yScale) {
        this(context, list, width, height, xScale, yScale, 100, height - 100, 0, 0);
    }

    public RangeModel(Context context, List<Point> list,
                      float width, float height,
                      float xScale, float yScale,
                      float xAnchor, float yAnchor) {
        this(context, list, width, height, xScale, yScale, xAnchor, yAnchor, 0, 0);
    }

    public RangeModel(Context context, List<Point> list,
                      float width, float height,
                      float xScale, float yScale,
                      float xAnchor, float yAnchor,
                      float xMathAnchor, float yMathAnchor) {
        init(context, list, width, height, xScale, yScale, xAnchor, yAnchor, xMathAnchor, yMathAnchor);
    }

    private void init(@NonNull Context context, @NonNull @Size(min = 1) List<Point> list,
                      float width, float height,
                      float xScale, float yScale,
                      float xAnchor, float yAnchor,
                      float xMathAnchor, float yMathAnchor) {
        screenW = ScreenUtils.getScreenWidth(context);
        screenH = ScreenUtils.getScreenHeight(context);
        if (screenW * screenH <= 0) {
            throw new ExceptionInInitializerError();
        }
        if (width * height <= 0) {
            throw new ExceptionInInitializerError();
        }
        if (xScale * yScale <= 0) {
            throw new ExceptionInInitializerError();
        }
        if (xAnchor * yAnchor <= 0 || xAnchor > width || yAnchor > height) {
            throw new ExceptionInInitializerError();
        }
        anchor = new Anchor(xAnchor, yAnchor, xMathAnchor, yMathAnchor);
        this.list = AdjustData.adjustData2Px(list, anchor, xScale, yScale);
    }

    public int getWarpWidth() {
        lPadding = rPadding = 50;
        width = screenW;
        minRangeX = lPadding;
        maxRangeX = width - rPadding;
        return width;
    }

    public int getWarpHeight() {
        tPadding = bPadding = 50;
        height = 600;
        minRangeY = tPadding;
        maxRangeY = height - bPadding;
        return height;
    }
}
