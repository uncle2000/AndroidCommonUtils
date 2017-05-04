package com.uncle2000.androidcommonutils;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;
import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.coorsys.BlankCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.coorsys.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.ChartOption;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.root_view);

        /*测试文件时需要的动态授权*/
        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);

        /*****************************************************************************************/
        Anchor anchor = new Anchor(100, 900, 0, 0);
        List<Point> list = AdjustData.adjustData2Px(DefaultData.chartData, anchor, 100, 100);
        ChartOption chartOption = new ChartOption();
        chartOption.anchor = anchor;
        chartOption.list = list;
        chartOption.setCharts(Constant.POINTS);

        BlankCoorSystem system = new DescartesCoorSystem(this, chartOption);
        ll.addView(system);


//        CanvasModel canvasModel = new CanvasModel(this, 100, 100);
//        CoorSysModel coorSysModel = new CoorSysModel(anchor);
//        ChartCanvas chartCanvas = (ChartCanvas) findViewById(R.id.fl);
//        chartCanvas.initData(canvasModel, DESCARTES_COORDINATE_SYSTEM);
//        chartCanvas.setChartData(POINTS, POLILINE, DASHLINE);
        /*****************************************************************************************/
    }
}