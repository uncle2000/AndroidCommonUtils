package com.uncle2000.androidcommonutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.uncle2000.androidcommonutils.uitls.system.PermissionUtil;
import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.coorsys.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.model.Anchor;
import com.uncle2000.androidcommonutils.views.chart.model.DescartesOption;

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
        Anchor anchor = new Anchor(100, 300, 0, 20000);
        DescartesOption dop = new DescartesOption(Constant.defaultData, anchor, 100, 100);
        dop.anchor = anchor;
        dop.setCharts(
//                Constant.POINTS,
//                Constant.DATA_ZONE,
//                Constant.CROSSLINE,
//                Constant.CURVE,
//                Constant.DASHLINE,
//                Constant.PILLAR,
//                Constant.HORIZONTAL,
//                Constant.POLILINE,
                Constant.AREA
        );

        dcs.setDescartesOption(dop);
        /*****************************************************************************************/
    }
}