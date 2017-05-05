package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Point;
import android.graphics.Rect;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.chart.CrossLine;
import com.uncle2000.androidcommonutils.views.chart.chart.Area;
import com.uncle2000.androidcommonutils.views.chart.chart.Points;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.uncle2000.androidcommonutils.views.chart.Constant.CROSSLINE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.CURVE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.DATAAREA;
import static com.uncle2000.androidcommonutils.views.chart.Constant.POINTS;

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
            case DATAAREA:
                chart = new Area(this);
                break;
            case POINTS:
                chart = new Points(this);
                break;
            case CURVE:
                break;
//            case POLILINE:
//                chart=
//                charts.add(new Polyline(canvasModel));
//                break;
//            case DASHLINE:
//                charts.add(new DashLine(canvasModel));
//                break;
            case CROSSLINE:
                chart = new CrossLine(this);
            default:
                break;
        }
        charts.add(chart);
    }

    public Rect getChartRect() {
        return new Rect(chartPadding, chartPadding, chartWidth - chartPadding, chartHeight - chartPadding);
    }
}
