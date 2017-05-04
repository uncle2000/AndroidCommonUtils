package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.chart.Charts;

import java.util.List;

/**
 * Created by 2000 on 2017/5/3.
 */

public class ChartOption {
    /*锚点*/
    public Anchor anchor;
    /*数据*/
    public List<Point> list;
    public Charts[] charts;
}
