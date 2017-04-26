package com.uncle2000.androidcommonutils.views.chart.utils;

import android.graphics.Point;

/**
 * Created by 2000 on 2017/4/18.
 */

public class Utils {

    /**
     * 折线，波浪，饼，雷达，面积，瀑布，圆环，表格 的数据都是有一个范围
     *
     * @return
     */
//    public static List<DataElement> mkDataE(int[] dataSource) {
//        List<DataElement> DataE = null;
//        for (int i = 0; i < dataSource.length - 1; i++) {
//            DataElement dataElement = new DataElement(dataSource[i], dataSource[i + 1]);
//            DataE.add(dataElement);
//        }
//        return DataE;
//    }
    public static int[] getMaxMin(Point[] src) {
        int maxX = Integer.MIN_VALUE,
                minX = Integer.MAX_VALUE,
                maxY = Integer.MIN_VALUE,
                minY = Integer.MAX_VALUE;
        for (Point p : src) {
            if (maxX < p.x) {
                maxX = p.x;
            }
            if (minX > p.x) {
                minX = p.x;
            }
            if (maxY < p.y) {
                maxY = p.y;
            }
            if (minY > p.y) {
                minY = p.y;
            }
        }

        int[] box = new int[]{minX, maxX, minY, maxY};
        return box;
    }

    public static void adjustData(float lPadding, float tPadding) {
        ChartData.chartDataCopy = new Point[ChartData.chartData.length];
        int[] a = Utils.getMaxMin(ChartData.chartData);
        for (int i = 0; i < ChartData.chartData.length; i++) {
            Point p = new Point(ChartData.chartData[i].x - a[0] + (int) lPadding,
                    ChartData.chartData[i].y - a[2] + (int) tPadding);
            ChartData.chartDataCopy[i] = p;
        }
    }

    public static Point getPoint(Point startP, int angle, int r) {
        angle %= 360;
        angle -= 90;
        int x = (int) (Math.cos(Math.PI * angle / 180) * r) + startP.x;
        int y = (int) (Math.sin(Math.PI * angle / 180) * r) + startP.y;
        return new Point(x, y);
    }

    public static Point getPoint(int x1, int y1, int angle, int r) {
        angle %= 360;
        angle -= 90;
        int x = (int) (Math.cos(Math.PI * angle / 180) * r) + x1;
        int y = (int) (Math.sin(Math.PI * angle / 180) * r) + y1;
        return new Point(x, y);
    }
}

//    /**
//     * 遍历所有的子view去测量自己（跳过GONE类型View）
//     *
//     * @param widthMeasureSpec  父视图的宽详细测量值
//     * @param heightMeasureSpec 父视图的高详细测量值
//     */
//    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
//        final int size = mChildrenCount;
//        final View[] children = mChildren;
//        for (int i = 0; i < size; ++i) {
//            final View child = children[i];
//            if ((child.mViewFlags & VISIBILITY_MASK) != GONE) {
//                measureChild(child, widthMeasureSpec, heightMeasureSpec);
//            }
//        }
//    }
//
//    /**
//     * 测量单个视图，将宽高和padding加在一起后交给getChildMeasureSpec去获得最终的测量值
//     *
//     * @param child                   需要测量的子视图
//     * @param parentWidthMeasureSpec  父视图的宽详细测量值
//     * @param parentHeightMeasureSpec 父视图的高详细测量值
//     */
//    protected void measureChild(View child, int parentWidthMeasureSpec,
//                                int parentHeightMeasureSpec) {
//        // 取得子视图的布局参数
//        final LayoutParams lp = child.getLayoutParams();
//
//        // 通过getChildMeasureSpec获取最终的宽高详细测量值
//        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
//                mPaddingLeft + mPaddingRight, lp.width);
//        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
//                mPaddingTop + mPaddingBottom, lp.height);
//
//        // 将计算好的宽高详细测量值传入measure方法，完成最后的测量
//        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
//    }
//
//    /**
//     * 在measureChildren中最难的部分：找出传递给child的MeasureSpec。
//     * 目的是结合父view的MeasureSpec与子view的LayoutParams信息去找到最好的结果
//     * （也就是说子view的确切大小由两方面共同决定：1.父view的MeasureSpec 2.子view的LayoutParams属性）
//     *
//     * @param spec           父view的详细测量值(MeasureSpec)
//     * @param padding        view当前尺寸的的内边距和外边距(padding,margin)
//     * @param childDimension child在当前尺寸下的布局参数宽高值(LayoutParam.width,height)
//     */
//    public static int getChildMeasureSpec(int spec, int padding, int childDimension) {
//        //父view的模式和大小
//        int specMode = MeasureSpec.getMode(spec);
//        int specSize = MeasureSpec.getSize(spec);
//
//        //通过父view计算出的子view = 父大小-边距（父要求的大小，但子view不一定用这个值）
//        int size = Math.max(0, specSize - padding);
//
//        //子view想要的实际大小和模式（需要计算）
//        int resultSize = 0;
//        int resultMode = 0;
//
//        //通过1.父view的MeasureSpec 2.子view的LayoutParams属性这两点来确定子view的大小
//        switch (specMode) {
//            // 当父view的模式为EXACITY时，父view强加给子view确切的值
//            case MeasureSpec.EXACTLY:
//                // 当子view的LayoutParams>0也就是有确切的值
//                if (childDimension >= 0) {
//                    //子view大小为子自身所赋的值，模式大小为EXACTLY
//                    resultSize = childDimension;
//                    resultMode = MeasureSpec.EXACTLY;
//                    // 当子view的LayoutParams为MATCH_PARENT时(-1)
//                } else if (childDimension == LayoutParams.MATCH_PARENT) {
//                    //子view大小为父view大小，模式为EXACTLY
//                    resultSize = size;
//                    resultMode = MeasureSpec.EXACTLY;
//                    // 当子view的LayoutParams为WRAP_CONTENT时(-2)
//                } else if (childDimension == LayoutParams.WRAP_CONTENT) {
//                    //子view决定自己的大小，但最大不能超过父view，模式为AT_MOST
//                    resultSize = size;
//                    resultMode = MeasureSpec.AT_MOST;
//                }
//                break;
//
//            // 当父view的模式为AT_MOST时，父view强加给子view一个最大的值。
//            case MeasureSpec.AT_MOST:
//                // 道理同上
//                if (childDimension >= 0) {
//                    resultSize = childDimension;
//                    resultMode = MeasureSpec.EXACTLY;
//                } else if (childDimension == LayoutParams.MATCH_PARENT) {
//                    resultSize = size;
//                    resultMode = MeasureSpec.AT_MOST;
//                } else if (childDimension == LayoutParams.WRAP_CONTENT) {
//                    resultSize = size;
//                    resultMode = MeasureSpec.AT_MOST;
//                }
//                break;
//
//            // 当父view的模式为UNSPECIFIED时，子view为想要的值
//            case MeasureSpec.UNSPECIFIED:
//                if (childDimension >= 0) {
//                    // 子view大小为子自身所赋的值
//                    resultSize = childDimension;
//                    resultMode = MeasureSpec.EXACTLY;
//                } else if (childDimension == LayoutParams.MATCH_PARENT) {
//                    // 因为父view为UNSPECIFIED，所以MATCH_PARENT的话子类大小为0
//                    resultSize = 0;
//                    resultMode = MeasureSpec.UNSPECIFIED;
//                } else if (childDimension == LayoutParams.WRAP_CONTENT) {
//                    // 因为父view为UNSPECIFIED，所以WRAP_CONTENT的话子类大小为0
//                    resultSize = 0;
//                    resultMode = MeasureSpec.UNSPECIFIED;
//                }
//                break;
//        }
//        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
//    }

