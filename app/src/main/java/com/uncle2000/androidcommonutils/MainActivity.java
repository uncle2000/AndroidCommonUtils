package com.uncle2000.androidcommonutils;

import android.graphics.Paint;
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
import com.uncle2000.androidcommonutils.views.chart.datalooks.Points;
import com.uncle2000.androidcommonutils.views.chart.datalooks.Polyline;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

import java.util.ArrayList;
import java.util.List;

import static com.uncle2000.androidcommonutils.views.chart.ChartCanvas.DESCARTES_COORDINATE_SYSTEM;

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

        List<Point> sa = new ArrayList<>();
        for (int i = 0; i < DefaultData.chartData.length; i++) {
            sa.add(i, DefaultData.chartData[i]);
        }

        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint.setStrokeWidth(3f);
        paint2.setStrokeWidth(20f);
        Polyline p = new Polyline(AdjustData.toRolyline(sa), paint);
        Points points = new Points(AdjustData.toPoints(sa), paint2);

//        Anchor anchor = new Anchor(200, 600);
//        anchor.mathCoor = new Point(0, 0);
//        chartCanvas.setAnchor(anchor);

        chartCanvas.setChartData(p, points);
        chartCanvas.showCoorSystem(DESCARTES_COORDINATE_SYSTEM);
//        chartCanvas.setDataScale(100);
//        chartCanvas.reload();
    }
}