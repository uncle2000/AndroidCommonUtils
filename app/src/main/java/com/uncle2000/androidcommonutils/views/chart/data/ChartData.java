package com.uncle2000.androidcommonutils.views.chart.data;

import android.app.ActivityGroup;
import android.graphics.Canvas;

import com.uncle2000.androidcommonutils.views.chart.descartes.coordinate.Anchor;

/**
 * Created by 2000 on 2017/4/26.
 */

public class ChartData {
    protected Anchor anchor = new Anchor();

    public Anchor getAnchor() {
        return anchor;
    }

    public void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public void draw(Canvas canvas) {

    }
}
