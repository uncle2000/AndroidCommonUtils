package com.uncle2000.androidcommonutils.views.chart;

import android.graphics.Point;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 2000 on 2017/5/4.
 */

public class Constant {
    public static final List<Point> defaultData = Arrays.asList(
            new Point(10000, 28000),
            new Point(20000, 32000),
            new Point(30000, 20000),
            new Point(40000, 40000),
            new Point(50000, 10000),
            new Point(60000, 10000),
            new Point(70000, 22000),
            new Point(80000, 25000),
            new Point(90000, 30000));

    public static final List<Float> defaultDataRadar = Arrays.asList(
            /*2f, 2f, 2f, 5f, 5f, 5f, 8f, 8f, 8f, 8f, 8f,*/ 2f, 10f, 3f, 12f, 9f, 2f, 15f, 9f, 6f, 3f
    );


    public static final int DEFALT_CHART_WIDTH = 800;
    public static final int DEFALT_CHART_HEIGHT = 600;
    public static final int DEFALT_CHART_PADDING = 50;
    public static final int DEFALT_CHART_X_SCALE = 1;
    public static final int DEFALT_CHART_y_SCALE = 1;

    public static final int DEFALT_ANCHOR_X = 100;
    public static final int DEFALT_ANCHOR_Y = 500;
    public static final int DEFALT_ANCHOR_MATH_X = 0;
    public static final int DEFALT_ANCHOR_MATH_Y = 0;
    public static final float DEFALT_ANCHOR_TEXT_SIZE = 38f;
    public static final int DEFALT_ANCHOR_TEXT_OFFSET_X = 20;
    public static final int DEFALT_ANCHOR_TEXT_OFFSET_Y = 20;

    public static final int DEFALT_AXIS_X_LENGHT = 600;
    public static final int DEFALT_AXIS_Y_LENGHT = 300;
    public static final int DEFALT_AXIS_OFFSET_X = 15;
    public static final int DEFALT_AXIS_OFFSET_Y = 15;

    public static final int DEFALT_ARRAW_ANGLE = 30;
    public static final int DEFALT_ARRAW_LENGTH = 30;

    public static final int DEFALT_AXIS_RADAR_LENGHT = 500;
    public static final int DEFALT_AXIS_RADAR_NUM = 5;
    public static final int DEFALT_AXIS_RADAR_SCALE = 1;


//    public static final int BLANK_COORDINATE_SYSTEM = 0;
//    public static final int DESCARTES_COORDINATE_SYSTEM = 1;
//    public static final int TABLE_COORDINATE_SYSTEM = 2;
//    public static final int RADAR_COORDINATE_SYSTEM = 3;
//
//    @IntDef({BLANK_COORDINATE_SYSTEM,
//            DESCARTES_COORDINATE_SYSTEM,
//            TABLE_COORDINATE_SYSTEM,
//            RADAR_COORDINATE_SYSTEM})
//    @Retention(RetentionPolicy.SOURCE)
//    public @interface CoordinateSystem {
//    }

    public static final int CHART_DATA = 0;
    public static final int DATA_ZONE = 1;
    public static final int POINTS = 2;
    public static final int CURVE = 3;
    public static final int POLILINE = 4;
    public static final int DASHLINE = 5;
    public static final int CROSSLINE = 6;
    public static final int HORIZONTAL = 7;
    public static final int PILLAR = 8;
    public static final int WATERFALL = 9;
    public static final int AREA = 10;

    @IntDef({CHART_DATA,
            DATA_ZONE,
            POINTS,
            CURVE,
            POLILINE,
            DASHLINE,
            CROSSLINE,
            HORIZONTAL,
            PILLAR,
            WATERFALL,
            AREA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataLooks {
    }
}
