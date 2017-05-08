package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Size;

import com.uncle2000.androidcommonutils.views.chart.Constant;
import com.uncle2000.androidcommonutils.views.chart.utils.AdjustData;

import java.util.List;

/**
 * Created by 2000 on 2017/5/5.
 */

public class RadarOption extends NormalOption {
    public List<Path> list;
    public float scale = Constant.DEFALT_AXIS_RADAR_SCALE;
    public int length = Constant.DEFALT_ARRAW_LENGTH;
    public int axisNum = Constant.DEFALT_AXIS_RADAR_NUM;

    public RadarOption(List<Float> list, Anchor anchor, @Size(min = 3) int axisNum, float scale, int length) {
        super(anchor);
        this.scale = scale;
        this.length = length;
        this.axisNum = axisNum;
        this.list = AdjustData.adjustData2RadarPx(list, anchor, axisNum, scale);
    }
}
