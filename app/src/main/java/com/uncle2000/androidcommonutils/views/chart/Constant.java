package com.uncle2000.androidcommonutils.views.chart;

import android.support.annotation.IntDef;

import com.uncle2000.androidcommonutils.uitls.equipment.ScreenUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 2000 on 2017/5/4.
 */

public class Constant {
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
    public static final int DATAAREA = 1;
    public static final int POINTS = 2;
    public static final int CURVE = 3;
    public static final int POLILINE = 4;
    public static final int DASHLINE = 5;
    public static final int CROSSLINE = 6;
    public static final int HORIZONTAL = 7;
    public static final int PILLAR = 8;
    public static final int WATERFALL = 9;

    @IntDef({CHART_DATA,
            DATAAREA,
            POINTS,
            CURVE,
            POLILINE,
            DASHLINE,
            CROSSLINE,
            HORIZONTAL,
            PILLAR,
            WATERFALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DataLooks {
    }
}
