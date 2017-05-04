package com.uncle2000.androidcommonutils.views.chart;

import android.content.Context;
import android.graphics.Point;

import com.uncle2000.androidcommonutils.views.chart.coorsys.BlankCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.coorsys.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

import java.util.List;

/**
 * Created by 2000 on 2017/5/4.
 */

public class Blank {

    Context context;

    public void init() {

        /*锚点*/
        Anchor anchor = new Anchor(100, 600, 0, 0);
        /*数据*/
        List<Point> list = AdjustData.adjustData2Px(DefaultData.chartData, anchor, 100, 100);


        ChartOption chartOption = null;

        BlankCoorSystem system1 = new BlankCoorSystem(context, chartOption);

        BlankCoorSystem system2 = new DescartesCoorSystem(context, chartOption);


















        //
    }
}
