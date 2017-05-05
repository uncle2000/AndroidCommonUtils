package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Point;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.chart.Area;
import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.chart.CrossLine;
import com.uncle2000.androidcommonutils.views.chart.chart.Zone;
import com.uncle2000.androidcommonutils.views.chart.chart.Curve;
import com.uncle2000.androidcommonutils.views.chart.chart.DashLine;
import com.uncle2000.androidcommonutils.views.chart.chart.HorizontalLines;
import com.uncle2000.androidcommonutils.views.chart.chart.Pillar;
import com.uncle2000.androidcommonutils.views.chart.chart.Points;
import com.uncle2000.androidcommonutils.views.chart.chart.Polyline;
import com.uncle2000.androidcommonutils.views.chart.chart.Waterfall;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.uncle2000.androidcommonutils.views.chart.Constant.AREA;
import static com.uncle2000.androidcommonutils.views.chart.Constant.CROSSLINE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.CURVE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.DASHLINE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.DATA_ZONE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.HORIZONTAL;
import static com.uncle2000.androidcommonutils.views.chart.Constant.PILLAR;
import static com.uncle2000.androidcommonutils.views.chart.Constant.POINTS;
import static com.uncle2000.androidcommonutils.views.chart.Constant.POLILINE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.WATERFALL;

/**
 * Created by 2000 on 2017/5/3.
 */

public class ChartOption {
    /*锚点*/
    public Anchor anchor;
    /*数据*/
    public List<Point> list;
    public Set<Charts> charts;
    public int xScale = Constant.DEFALT_CHART_X_SCALE, yScale = Constant.DEFALT_CHART_y_SCALE;
    /*********************************************************************************************/
    public int chartPadding = Constant.DEFALT_CHART_PADDING;
    public int chartWidth;
    public int chartHeight;

    public ChartOption(List<Point> list, Anchor anchor, int xScale, int yScale) {
        this.anchor = anchor;
        this.xScale = xScale;
        this.yScale = yScale;
        charts = new HashSet<>();
        this.list = AdjustData.adjustData2Px(list, anchor, xScale, yScale);
        AdjustData.px2MathPoint(this.list, anchor, xScale, yScale);
    }

    public void setCharts(@Constant.DataLooks int... looks) {
        for (@Constant.DataLooks int l : looks) {
            addChartData(l);
        }
    }

    private void addChartData(@Constant.DataLooks int looks) {
        Charts chart = null;
        switch (looks) {
            case DATA_ZONE:
                chart = new Zone(this);
                break;
            case POINTS:
                chart = new Points(this);
                break;
            case CURVE:
                chart = new Curve(this);
                break;
            case POLILINE:
                chart = new Polyline(this);
                break;
            case DASHLINE:
                chart = new DashLine(this);
                break;
            case CROSSLINE:
                chart = new CrossLine(this);
                break;
            case HORIZONTAL:
                chart = new HorizontalLines(this);
                break;
            case PILLAR:
                chart = new Pillar(this);
                break;
            case WATERFALL:
                chart = new Waterfall(this);
                break;
            case AREA:
                chart = new Area(this);
                break;
            default:
                break;
        }
        charts.add(chart);
    }

    public Rect getChartRect() {
        return new Rect(chartPadding, chartPadding, chartWidth - chartPadding, chartHeight - chartPadding);
    }
}
