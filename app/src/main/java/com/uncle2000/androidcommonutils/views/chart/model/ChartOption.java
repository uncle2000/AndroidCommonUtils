package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
import com.uncle2000.androidcommonutils.views.chart.chart.Points;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.uncle2000.androidcommonutils.views.chart.Constant.CURVE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.DASHLINE;
import static com.uncle2000.androidcommonutils.views.chart.Constant.DATAAREA;
import static com.uncle2000.androidcommonutils.views.chart.Constant.POINTS;
import static com.uncle2000.androidcommonutils.views.chart.Constant.POLILINE;

/**
 * Created by 2000 on 2017/5/3.
 */

public class ChartOption {
    /*锚点*/
    public Anchor anchor;
    /*数据*/
    public List<Point> list;
    public Set<Charts> charts;

    public ChartOption() {
        charts = new HashSet<>();
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
//                chartParents.add(new DataArea(AdjustData.canvasModel.list));
                break;
            case POINTS:
                chart=new Points();
                break;
            case CURVE:
//                chartParents.add(new Curve(AdjustData.toPoints(canvasModel.list)));
                break;
//            case POLILINE:
//                chart=
//                charts.add(new Polyline(canvasModel));
//                break;
//            case DASHLINE:
//                charts.add(new DashLine(canvasModel));
//                break;
            default:
                break;
        }
        charts.add(chart);
    }
}
