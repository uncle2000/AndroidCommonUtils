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

public class NormalOption {
    /*锚点*/
    public Anchor anchor;
    /*********************************************************************************************/
    public int chartPadding = Constant.DEFALT_CHART_PADDING;

    public NormalOption(Anchor anchor) {
        this.anchor = anchor;
    }
}
