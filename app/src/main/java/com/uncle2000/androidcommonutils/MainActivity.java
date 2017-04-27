package com.uncle2000.androidcommonutils;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;
import com.uncle2000.androidcommonutils.views.chart.ChartCanvas;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.descartes.RadarCoorStstem;
import com.uncle2000.androidcommonutils.views.chart.datalooks.Curve;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.descartes.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*测试文件时需要的动态授权*/
        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);

        /*****************************************************************************************/
        ChartCanvas chartCanvas = (ChartCanvas) findViewById(R.id.fl);

        SparseArray<Point> sa = new SparseArray<>();
        for (int i = 0; i < DefaultData.chartData.length; i++) {
            sa.put(i, DefaultData.chartData[i]);
        }

        Curve curve = new Curve(AdjustData.toPoints(sa));
        Anchor anchor = new Anchor(200, 600);
        DescartesCoorSystem descartesCoorSystem = new DescartesCoorSystem(anchor);
        RadarCoorStstem radarCoorStstem = new RadarCoorStstem(anchor, 30);
        chartCanvas.setCoorSystem(radarCoorStstem);
        chartCanvas.setChartData(curve);
    }
}