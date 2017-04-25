package com.uncle2000.androidcommonutils.views.chart.base.coordinate.axis;

import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.ColorInt;
import android.util.SparseArray;

import com.uncle2000.androidcommonutils.views.chart.base.coordinate.Anchor;
import com.uncle2000.androidcommonutils.views.chart.base.coordinate.element.CoorAxisElement;
import com.uncle2000.androidcommonutils.views.chart.base.coordinate.element.ElementModel;

/**
 * Created by 2000 on 2017/4/25.
 */

public class AxisModel {

    /**
     * 画轴的画笔
     */
    private Paint axisPaint;
    /**
     * 轴的颜色
     */
    @ColorInt
    private int color = 0xff000000;
    private float thickness = 5f;

    /**
     * 锚点 也是轴的起点
     */
    private Anchor anchor;

    /**
     * 轴的角度 注意下面四个特殊角
     * [0°↑:y- ,90°→:x+ ,180°↓:y+ ,270°←:x-]
     */
    private int angle;
    /**
     * 轴的长度
     */
    private int length = 600;
    /**
     * 轴的偏移量 会朝轴的反方向画一点
     */
    private int offset;

    /**
     * 是否显示箭头
     */
    private boolean showArraw = true;
    /**
     * 箭头的内角 长度信息
     */
    private int arrawLessL = 8;
    private int arrawLargerL = 50;
    private int arrawAngle = 38;

    /**
     * 轴上的点
     */
    private SparseArray<Point> normalP;
    /**
     * 轴上点的model
     */
    private SparseArray<ElementModel> eModels;
    private ElementModel eModel;

    public Paint getAxisPaint() {
        if (null == axisPaint) {
            axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            axisPaint.setStrokeWidth(thickness);
            axisPaint.setColor(color);
        }
        return axisPaint;
    }

    public void setAxisPaint(Paint axisPaint) {
        this.axisPaint = axisPaint;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isShowArraw() {
        return showArraw;
    }

    public void setShowArraw(boolean showArraw) {
        this.showArraw = showArraw;
    }

    public int getArrawLessL() {
        return arrawLessL;
    }

    public void setArrawLessL(int arrawLessL) {
        this.arrawLessL = arrawLessL;
    }

    public int getArrawLargerL() {
        return arrawLargerL;
    }

    public void setArrawLargerL(int arrawLargerL) {
        this.arrawLargerL = arrawLargerL;
    }

    public int getArrawAngle() {
        return arrawAngle;
    }

    public void setArrawAngle(int arrawAngle) {
        this.arrawAngle = arrawAngle;
    }

    public SparseArray<Point> getNormalP() {
        return normalP;
    }

    public void setNormalP(SparseArray<Point> normalP) {
        this.normalP = normalP;
    }

    public SparseArray<ElementModel> geteModels() {
        return eModels;
    }

    public void seteModels(SparseArray<ElementModel> eModels) {
        this.eModels = eModels;
    }

    public ElementModel geteModel() {
        return eModel;
    }

    public void seteModel(ElementModel eModel) {
        this.eModel = eModel;
    }
}
