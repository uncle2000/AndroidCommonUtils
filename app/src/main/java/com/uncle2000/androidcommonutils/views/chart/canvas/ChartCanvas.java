package com.uncle2000.androidcommonutils.views.chart.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.view.View;

import com.uncle2000.androidcommonutils.views.chart.coorsys.BlankCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.coorsys.DescartesCoorSystem;
import com.uncle2000.androidcommonutils.views.chart.chart.ChartData;
import com.uncle2000.androidcommonutils.views.chart.chart.DashLine;
import com.uncle2000.androidcommonutils.views.chart.chart.Points;
import com.uncle2000.androidcommonutils.views.chart.chart.Polyline;
import com.uncle2000.androidcommonutils.views.chart.model.CanvasModel;
import com.uncle2000.androidcommonutils.views.chart.model.CoorSysModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 图表的View类 负责将图表画到canvas上
 * Created by 2000 on 2017/4/26.
 */

public class ChartCanvas extends View {
    public static final int BLANK_COORDINATE_SYSTEM = 0;
    public static final int DESCARTES_COORDINATE_SYSTEM = 1;
    public static final int TABLE_COORDINATE_SYSTEM = 2;
    public static final int RADAR_COORDINATE_SYSTEM = 3;

    @IntDef({BLANK_COORDINATE_SYSTEM,
            DESCARTES_COORDINATE_SYSTEM,
            TABLE_COORDINATE_SYSTEM,
            RADAR_COORDINATE_SYSTEM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CoordinateSystem {
    }

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


    /**
     * 坐标系的基类，除非你不准备画坐标轴
     */
    private BlankCoorSystem coorSystem;
    private List<ChartData> chartData;

    private CanvasModel canvasModel;
    private CoorSysModel coorSysModel;

    public ChartCanvas(Context context) {
        this(context, null);
    }

    public ChartCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
    }

    public void initData(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
        coorSysModel = new CoorSysModel(canvasModel.anchor);
        coorSysModel.width = canvasModel.width;
        coorSysModel.height = canvasModel.height;
    }

    private void initChartData() {
        if (this.chartData == null) {
            this.chartData = new ArrayList<>();
        }
    }

    public void chooseCoorSystem(@CoordinateSystem int system) {
        switch (system) {
            case BLANK_COORDINATE_SYSTEM:
                coorSystem = new BlankCoorSystem(coorSysModel);
                break;
            case DESCARTES_COORDINATE_SYSTEM:
                coorSystem = new DescartesCoorSystem(coorSysModel);
                break;
            case TABLE_COORDINATE_SYSTEM:
                coorSystem = new BlankCoorSystem(coorSysModel);
                break;
            case RADAR_COORDINATE_SYSTEM:
//                coorSystem = new RadarCoorStstem(canvasModel, 45);
                break;
        }
    }

    public void addChartData(@DataLooks int looks) {
        initChartData();
        switch (looks) {
            case DATAAREA:
//                chartData.add(new DataArea(AdjustData.canvasModel.list));
                break;
            case POINTS:
                chartData.add(new Points(canvasModel));
                break;
            case CURVE:
//                chartData.add(new Curve(AdjustData.toPoints(canvasModel.list)));
                break;
            case POLILINE:
                chartData.add(new Polyline(canvasModel));
                break;
            case DASHLINE:
                chartData.add(new DashLine(canvasModel));
                break;
            default:
                break;
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = canvasModel.getWarpHeight();
        }

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = canvasModel.getWarpWidth();
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (null != chartData) {
            for (ChartData cd : chartData) {
                cd.draw(canvas);
            }
        }

        if (coorSystem != null)
            coorSystem.draw(canvas);
    }


    /*********************************************************************************************/
    public List<ChartData> getChartData() {
        return chartData;
    }

    public void setChartData(ChartData... chartData) {
        initChartData();
        this.chartData = Arrays.asList(chartData);
    }

    public void setChartData(@DataLooks int... looks) {
        for (int l : looks) {
            addChartData(l);
        }
    }

    public CoorSysModel getCoorSysModel() {
        if (null == coorSysModel) {
            throw new ExceptionInInitializerError("must after setCanvasModel()");
        }
        return coorSysModel;
    }
}
