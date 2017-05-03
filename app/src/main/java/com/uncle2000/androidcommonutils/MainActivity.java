package com.uncle2000.androidcommonutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;
import com.uncle2000.androidcommonutils.views.chart.ChartCanvas;
import com.uncle2000.androidcommonutils.views.chart.RangeModel;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

import static com.uncle2000.androidcommonutils.views.chart.ChartCanvas.DASHLINE;
import static com.uncle2000.androidcommonutils.views.chart.ChartCanvas.DESCARTES_COORDINATE_SYSTEM;
import static com.uncle2000.androidcommonutils.views.chart.ChartCanvas.POINTS;
import static com.uncle2000.androidcommonutils.views.chart.ChartCanvas.POLILINE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*测试文件时需要的动态授权*/
        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);

        /*****************************************************************************************/
        RangeModel rangeModel = new RangeModel(this, DefaultData.chartData,
                800, 600, 100, 100, 100, 600, 0, 0);

        ChartCanvas chartCanvas = (ChartCanvas) findViewById(R.id.fl);
        chartCanvas.setRangeModel(rangeModel);
        chartCanvas.setChartData(POINTS, POLILINE, DASHLINE);
        chartCanvas.chooseCoorSystem(DESCARTES_COORDINATE_SYSTEM);
        /*****************************************************************************************/

    }
}