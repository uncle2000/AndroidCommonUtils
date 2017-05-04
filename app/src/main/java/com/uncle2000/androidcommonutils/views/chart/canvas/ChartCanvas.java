//package com.uncle2000.androidcommonutils.views.chart.canvas;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.util.AttributeSet;
//import android.view.View;
//
//import com.uncle2000.androidcommonutils.views.chart.Constant;
//import com.uncle2000.androidcommonutils.views.chart.chart.Charts;
//import com.uncle2000.androidcommonutils.views.chart.coorsys.BlankCoorSystem;
//import com.uncle2000.androidcommonutils.views.chart.coorsys.DescartesCoorSystem;
//import com.uncle2000.androidcommonutils.views.chart.chart.DashLine;
//import com.uncle2000.androidcommonutils.views.chart.chart.Points;
//import com.uncle2000.androidcommonutils.views.chart.chart.Polyline;
//import com.uncle2000.androidcommonutils.views.chart.model.CanvasModel;
//import com.uncle2000.androidcommonutils.views.chart.model.CoorSysModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.uncle2000.androidcommonutils.views.chart.Constant.BLANK_COORDINATE_SYSTEM;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.CURVE;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.DASHLINE;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.DATAAREA;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.DESCARTES_COORDINATE_SYSTEM;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.POINTS;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.POLILINE;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.RADAR_COORDINATE_SYSTEM;
//import static com.uncle2000.androidcommonutils.views.chart.Constant.TABLE_COORDINATE_SYSTEM;
//
//
///**
// * 图表的View类 负责将图表画到canvas上
// * Created by 2000 on 2017/4/26.
// */
//
//public class ChartCanvas extends View {
//    private BlankCoorSystem coorSystem;
//    private List<Charts> chartParents;
//
//    private CanvasModel canvasModel;
//    private CoorSysModel coorSysModel;
//    @Constant.CoordinateSystem
//    private int system;
//    @Constant.DataLooks
//    private int[] looks;
//
//    public ChartCanvas(Context context) {
//        this(context, null);
//    }
//
//    public ChartCanvas(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(context);
//    }
//
//    public ChartCanvas(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        init(context);
//    }
//
//    public void init(Context context) {
//    }
//
//    public void initData(CanvasModel canvasModel,
//                         @Constant.CoordinateSystem int system,
//                         @Constant.DataLooks int... looks) {
//        this.looks = looks;
//        this.system = system;
//        this.canvasModel = canvasModel;
//        coorSysModel = new CoorSysModel(canvasModel.anchor);
//    }
//
//    private void initChartData() {
//        if (this.chartParents == null) {
//            this.chartParents = new ArrayList<>();
//        }
//    }
//
//    private void chooseCoorSystem(@Constant.CoordinateSystem int system) {
//        switch (system) {
//            case BLANK_COORDINATE_SYSTEM:
//                coorSystem = new BlankCoorSystem(coorSysModel);
//                break;
//            case DESCARTES_COORDINATE_SYSTEM:
//                coorSystem = new DescartesCoorSystem(coorSysModel);
//                break;
//            case TABLE_COORDINATE_SYSTEM:
//                coorSystem = new BlankCoorSystem(coorSysModel);
//                break;
//            case RADAR_COORDINATE_SYSTEM:
////                coorSystem = new RadarCoorStstem(canvasModel, 45);
//                break;
//        }
//    }
//
//    private void addChartData(@Constant.DataLooks int looks) {
//        initChartData();
//        switch (looks) {
//            case DATAAREA:
////                chartParents.add(new DataArea(AdjustData.canvasModel.list));
//                break;
//            case POINTS:
//                chartParents.add(new Points(canvasModel));
//                break;
//            case CURVE:
////                chartParents.add(new Curve(AdjustData.toPoints(canvasModel.list)));
//                break;
//            case POLILINE:
//                chartParents.add(new Polyline(canvasModel));
//                break;
//            case DASHLINE:
//                chartParents.add(new DashLine(canvasModel));
//                break;
//            default:
//                break;
//        }
//
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//
//        int width;
//        int height;
//
//        if (heightMode == MeasureSpec.EXACTLY) {
//            height = heightSize;
//        } else {
//            height = canvasModel.getWarpHeight();
//        }
//        if (widthMode == MeasureSpec.EXACTLY) {
//            width = widthSize;
//        } else {
//            width = canvasModel.getWarpWidth();
//        }
//
//        setMeasuredDimension(width, height);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        coorSysModel.width = canvasModel.width = getWidth();
//        coorSysModel.height = canvasModel.height = getHeight();
//        chooseCoorSystem(system);
//        if (null != looks)
//            for (int l : looks) {
//                addChartData(l);
//            }
//
//
//        if (null != chartParents) {
//            for (Charts cd : chartParents) {
//                cd.draw(canvas);
//            }
//        }
//
//        if (coorSystem != null)
//            coorSystem.draw(canvas);
//    }
//
//
//    /*********************************************************************************************/
////    public List<Charts> getChartData() {
////        return chartParents;
////    }
////
////    public void setChartData(Charts... chartParents) {
////        initChartData();
////        this.chartParents = Arrays.asList(chartParents);
////    }
////
////    public void setChartData(@Constant.DataLooks int... looks) {
////        this.looks = looks;
////    }
////
////    public void setCoorSystem(@Constant.CoordinateSystem int system) {
////        this.system = system;
////    }
////
////    public CoorSysModel getCoorSysModel() {
////        if (null == coorSysModel) {
////            throw new ExceptionInInitializerError("must after setCanvasModel()");
////        }
////        return coorSysModel;
////    }
//}
