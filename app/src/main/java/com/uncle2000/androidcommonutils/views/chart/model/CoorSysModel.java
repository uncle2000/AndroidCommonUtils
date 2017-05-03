package com.uncle2000.androidcommonutils.views.chart.model;

import android.graphics.Point;
import android.util.SparseArray;

import java.util.List;

/**
 * Created by 2000 on 2017/4/25.
 */

public class CoorSysModel {
    public Anchor anchor;

    public int xDir = 1, yDir = 1;

    /**
     * 轴的角度 注意下面四个特殊角
     * [0°↑:y- ,90°→:x+ ,180°↓:y+ ,270°←:x-]
     */
    private int angle;
    private int length = 1000;


    private List<ElementModel> eModels;
    public int width;
    public int height;

    public CoorSysModel(Anchor anchor) {
        this.anchor = anchor;
    }

    /*********************************************************************************************/

    public Anchor getAnchor() {
        return anchor;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public List<ElementModel> geteModels() {
        return eModels;
    }

    public void seteModels(List<ElementModel> eModels) {
        this.eModels = eModels;
    }
}
