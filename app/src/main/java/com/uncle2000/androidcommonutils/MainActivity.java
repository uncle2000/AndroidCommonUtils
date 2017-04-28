package com.uncle2000.androidcommonutils;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;
import com.uncle2000.androidcommonutils.views.chart.ChartCanvas;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.Anchor;
import com.uncle2000.androidcommonutils.views.chart.coorsystem.descartes.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.datalooks.DashLine;
import com.uncle2000.androidcommonutils.views.chart.datalooks.Points;
import com.uncle2000.androidcommonutils.views.chart.datalooks.Polyline;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;
import com.uncle2000.androidcommonutils.views.chart.utils.DefaultData;

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

//        List<Point> sa = new ArrayList<>();
//        for (int i = 0; i < DefaultData.chartData.length; i++) {
//            sa.add(i, DefaultData.chartData[i]);
//        }


        Anchor anchor = new Anchor(50, 650);
        anchor.mathCoor = new Point(0, 0);
        chartCanvas.setAnchor(anchor);

        Paint paint = new Paint();
        Paint paint2 = new Paint();
        paint.setStrokeWidth(3f);
        paint2.setStrokeWidth(20f);
        List<Point> po = AdjustData.adjustData2Px(DefaultData.chartData, anchor, 100);
        DashLine d=new DashLine(AdjustData.toDash(po,50,650));
        Polyline p = new Polyline(AdjustData.toRolyline(po));
        Points points = new Points(AdjustData.toPoints(po));


        chartCanvas.setChartData(d,p, points);
        chartCanvas.drawCoorSystem(DESCARTES_COORDINATE_SYSTEM);
        ((DescartesCoorSystem) chartCanvas.getCoorSystem()).yCoorAxis.getAxisModel().setShowArraw(false);
//        chartCanvas.setDataScale(100);
//        chartCanvas.reload();
    }
}