package com.uncle2000.androidcommonutils;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        /*测试文件时需要的动态授权*/
        PermissionUtil.requestPermissions(this, 0, android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE);

        LinearLayout ll = (LinearLayout) findViewById(R.id.root_view);
        DescartesCoorSystem dcs = (DescartesCoorSystem) findViewById(R.id.dcs);
        /*****************************************************************************************/
        Anchor anchor = new Anchor(100, 300, 0, 0);
        ChartOption chartOption = new ChartOption(DefaultData.chartData, anchor, 100, 100);
        chartOption.anchor = anchor;
        chartOption.setCharts(Constant.POINTS, Constant.DATAAREA, Constant.CROSSLINE);

        TextView textView=new TextView(this);
        textView.setBackgroundColor(0xffff00ff);
//        BlankCoorSystem system = new DescartesCoorSystem(this, chartOption);
//        ll.addView(system);
        dcs.setChartOption(chartOption);
        /*****************************************************************************************/
    }
}