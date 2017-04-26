package com.uncle2000.androidcommonutils.views;

import java.util.List;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * The Chinese API is on my blog——http://www.cnblogs.com/uncle2000/.The step1 new and set the Constructed Function.The step2 set the ListDate
 * .The step3 set other option or not.
 *
 * @author wei.wang 2014.6.13
 */
public class SimplePillarsView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float ContainerTopCoordinate = 0;//YES
    private float Containerbottomcoordinate;//auto
    private int moveX;//automeasure
    private int downX;//automeasure
    private float distance = 0;//automeasure
    private float mDrawOffset = 0;//automeasure
    private float mSaveOffset = 0;//automeasure
    private float canvaswigth = 0;//measure
    private int Amount = 0;//auto +
    private List<List<String>> ListDate;//set
    private float ymax = 0;//set  >=0 如果都小于0那么不画柱子
    private float mTextHeightOffset;//auto
    private float mTextHeight;//measure
    private float charttopedge = 0;//measure
    private float chartbottomedge;//measure;chartbottomedge=min
    private float firstpoint;//measure
    private float TextSizeUpPillars;//YES
    private float TextSizeDownPillars;//YES
    private int TextColorUpPillars = 0xffffff00;//YES
    private int TextColorDownPillars = 0xffff00ff;//YES
    private int PillarsColor = 0xffffffff;//YES
    private boolean BaseLine = true;//YES
    private int BaseLinecolor = 0xff00ffff;//YES
    private int Column = 8 + 1;//YES
    private float Columnwidth = 15;//YES
    private float ContainerLeftCoordinate = 0;//YES
    private float Columnspacing = 0;//measure
    private float TextDistanceUpPillars = 10;//set
    private float TextDistanceDownPillars = 10;//set
    private float ContainerBottomDistance = 30;//YES
    private int ContainerWidht = 0;//new +
    private int Containerheight = 0;//new +
    private float density = 1;//new +
    private double textweight = 0.05;//new +
    private float Pillarsrx = 0;
    private float Pillarsry = 0;
    private int ColorLevel1 = 0xffffffff;
    private int ColorLevel2 = 0xffffff00;
    private int ColorLevel3 = 0xff00ff00;
    private float Level1 = 6;
    private float Level2 = 8;
    private int ColumnNum = 0;
    private boolean ScrollFlag = true;

    /**
     * 无论有没有柱子的数据，只要传进来高宽就会在屏幕上开辟出来一块矩形区域用来显示，该方法的后三个参数需要用户传入真实数据，
     * 作者建议在传入参数之前，将此View需要add的容器（父View）的预留长宽先开辟出一块xdp长ydp宽的地方。然后通过“dp转px”将转换后的数据传入进来这将保证不同屏幕的适配性
     * 然后通过new DisplayMetrics()来得到像素密度传入进来，这也是保证了适配性。
     *
     * @param context                                                                         上下文
     * @param Containerheight（像素）该View在手机屏幕上开辟出来的高度，无论需要显示的柱子有多少，请不要设置该参数超过屏幕的高度，否则超过屏幕的部分看不到
     * @param ContainerWidht                                                                  （像素）该View在手机屏幕上开辟出来的宽度，无论需要显示的柱子有多少，请不要设置该参数超过屏幕的宽度，否则超过屏幕的部分看不到
     * @param density                                                                         像素密度，默认为1。需要用户得到手机上的像素密度参数传入进来，是保证了不同屏幕显示相同的基础
     * @param textweight                                                                      文字的权重，取值为[0.01,0.25]。默认为0.05也就是占整个父View高度的0.05，文字有两处所有，也就是说这两处的文字占了父View的0.05*2。
     *                                                                                        如果字设置太大，那么上下的字会挤中间的柱子，字也会出现重合的地方，那么您非要设置这么大则可以将Column参数设置小来避免文字重合。
     *                                                                                        下一步请先设置setmItem()!
     */
    public SimplePillarsView(Context context, int Containerheight, int ContainerWidht, float density, double textweight) {
        super(context);
        if (ContainerWidht > 0)
            this.ContainerWidht = ContainerWidht;
        if (Containerheight > 0)
            this.Containerheight = Containerheight;
        if (density >= 1)
            this.density = density;
        Columnwidth = Columnwidth * density;
        if (textweight > 0.25)
            this.textweight = 0.25;
        else if (textweight < 0.01)
            this.textweight = 0.01;
        else
            this.textweight = textweight;
        mPaint.setTextSize((float) (Containerheight * textweight));
        mPaint.setColor(Color.BLACK);
        mPaint.setTextAlign(Align.CENTER);
        mPaint.setStyle(Style.FILL);
        mTextHeight = mPaint.getFontMetrics().bottom - mPaint.getFontMetrics().ascent;
        mTextHeightOffset = mPaint.getFontMetrics().ascent - mPaint.getFontMetrics().top;
    }

    /**
     * 无论有没有柱子的数据，只要传进来高宽就会在屏幕上开辟出来一块矩形区域用来显示，该方法的后三个参数需要用户传入真实数据，
     * 作者建议在传入参数之前，将此View需要add的容器（父View）的预留长宽先开辟出一块xdp长ydp宽的地方。然后通过“dp转px”将转换后的数据传入进来这将保证不同屏幕的适配性
     * 然后通过new DisplayMetrics()来得到像素密度传入进来，这也是保证了适配性。
     *
     * @param context                                                                         上下文
     * @param Containerheight（像素）该View在手机屏幕上开辟出来的高度，无论需要显示的柱子有多少，请不要设置该参数超过屏幕的高度，否则超过屏幕的部分看不到
     * @param ContainerWidht                                                                  （像素）该View在手机屏幕上开辟出来的宽度，无论需要显示的柱子有多少，请不要设置该参数超过屏幕的宽度，否则超过屏幕的部分看不到
     * @param density                                                                         像素密度，默认为1。需要用户得到手机上的像素密度参数传入进来，是保证了不同屏幕显示相同的基础
     */
    public SimplePillarsView(Context context, int Containerheight, int ContainerWidht, float density) {
        super(context);
        if (ContainerWidht > 0)
            this.ContainerWidht = ContainerWidht;
        if (Containerheight > 0)
            this.Containerheight = Containerheight;
        if (density >= 1)
            this.density = density;
        this.textweight = 0.05;
        mPaint.setTextSize((float) (Containerheight * textweight));
        mPaint.setColor(Color.BLACK);
        mPaint.setTextAlign(Align.CENTER);
        mPaint.setStyle(Style.FILL);
        mTextHeight = mPaint.getFontMetrics().bottom - mPaint.getFontMetrics().ascent;
        mTextHeightOffset = mPaint.getFontMetrics().ascent - mPaint.getFontMetrics().top;
    }

    /**
     * 该ListDate长度为2
     * 因为ListDate.get(0)为柱子下的文字，
     * ListDate.get(1)为柱子的长度的数据且必须为数字，该list也决定了柱子的总列数,若里面的数据
     *
     * @param ListDate 传入的数据 需要注意的是：ListDate.get(1)决定了总列数，其他的list超出则不显示，不够则自动填补为null
     *                      。下一步您可以选择设置其他参数。
     */
    public void setListDate(List<List<String>> ListDate) {
        if (ListDate.size() != 2)
            Log.e("异常！", "ListDate的长度必须为2，ListDate.get(0)为柱子的x坐标，ListDate.get(1)为柱子的高度。");
        if (ListDate.get(1).size() == 0)
            Log.e("异常！", "ListDate.get(1)的长度必须大于0.");
        for (int i = 0; i < ListDate.get(1).size(); i++) {
            if (!isNumeric(ListDate.get(1).get(i))) {
                Log.e("异常！", "ListDate.get(1)中第" + i + "个数据不是数字，自动替换为0.");
                ListDate.get(1).remove(i);
                ListDate.get(1).add(i, "0");
            }
        }
        this.ListDate = ListDate;
        Amount = ListDate.get(1).size();
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 此参数和padding相似，可以设置容器padding图标的宽度，可以不设置，默认为0。
     *
     * @param containerLeftCoordinate 大于零则拉大第一个柱子和最左右边界的距离，小于零则缩小。这里我省去了containerRightCoordinate
     * @param containerTopCoordinate  大于零则拉大最高的柱子上的文字顶部和上边界的距离，小于零则缩小。
     * @param containerBottomDistance 大于零则拉大最高的柱子下的文字底部和下边界的距离，小于零则缩小。
     */
    public void setContainerCoordinate(float containerLeftCoordinate, float containerTopCoordinate, float containerBottomDistance) {
        ContainerTopCoordinate = containerTopCoordinate;
        ContainerLeftCoordinate = containerLeftCoordinate;
        ContainerBottomDistance = containerBottomDistance;
    }

    /**
     * 该参数最好保持默认值，默认是您传入进来的list(1)中的最大数据，来保证数据能占满整个父View，如果你非要设置请注意：如果您设置的数据过大那么柱子和柱子上的空白区域就会过大，如果您设置的过小则超过您设置的该值的柱子则显示不全！
     *
     * @param ymax 传入的所有柱子数据的最大值
     */
    public void setYmax(float ymax) {
        this.ymax = ymax;
    }

    /**
     * @param textSizeUpPillars    柱子上边的文字大小,赶时间所以该方法没有启用，您还是设置文字权重吧
     * @param textColorUpPillars   柱子上边的文字颜色
     * @param textSizeDownPillars  柱子下边的文字大小,赶时间所以该方法没有启用，您还是设置文字权重吧
     * @param textColorDownPillars 柱子下边的文字颜色
     */
    public void setPillarsText(float textSizeUpPillars, int textColorUpPillars, float textSizeDownPillars, int textColorDownPillars) {
//	TextSizeUpPillars = textSizeUpPillars;
//	TextSizeDownPillars = textSizeDownPillars;
        TextColorUpPillars = textColorUpPillars;
        TextColorDownPillars = textColorDownPillars;
    }

    /**
     * 基线，就是柱子最下端的水平线。
     *
     * @param baseLine      默认为true，设置为false则不显示改基线
     * @param baseLinecolor 基线颜色
     */
    public void setBaseLine(boolean baseLine, int baseLinecolor) {
        BaseLine = baseLine;
        BaseLinecolor = baseLinecolor;
    }

    /**
     * 之所以设置该参数是为了在不同像素密度下的手机屏幕都可以有一个统一的配置。需要注意的是该设置无视containerLeftCoordinate参数。
     *
     * @param column 该View的真实区域内显示多少个完整的柱子。默认为7，也就说如果您的list(1)中有超过了7的数据，那么在您设置的该View在不超出屏幕的情况下，您能看到7根完整的柱子，之所以默认为7是因为一周有7天。
     *               还需要注意的是最右边有半根柱子是为了告诉用户有“更多的数据，您可以往右滑动”,所以才没有去遮挡那半根。
     */
    public void setColumn(int column) {
        if (column > 0)
            Column = column + 1;
    }

    /**
     * 可以让柱子有最多三种颜色，在level1和level2生效的情况下分别是[0，level1][level1，level2][level2，ymax]。
     *
     * @param level1      大于0才生效
     * @param level2      大于level1才生效（会有三种颜色），否则不生效（会有两种颜色），且ColorLevel3也不生效
     * @param ColorLevel1 小于level1的柱子的颜色
     * @param ColorLevel2 大于等于level1小于level2的柱子的颜色
     * @param ColorLevel3 大于等于level2的柱子的颜色
     */
    public void setPillarsDiffrentColor(float level1, float level2, int ColorLevel1, int ColorLevel2, int ColorLevel3) {
        if (level1 > 0) {
            this.Level1 = level1;
            if (level2 > level1)
                this.Level2 = level2;
            this.ColorLevel1 = ColorLevel1;
            this.ColorLevel2 = ColorLevel2;
            this.ColorLevel3 = ColorLevel3;
        }
    }


    /**
     * @param Pillarswidth 柱子宽默认为10px*像素密度。
     * @param PillarsColor 柱子颜色
     * @param Pillarsrx    柱子圆角之x默认为0
     * @param Pillarsry    柱子圆角之y默认为0
     *                     小提示：如果要让柱子够圆润请将柱子的Pillarsrx和Pillarsry设置和柱子宽相等。如果想要圆柱型柱子请将Pillarsry设置为0，Pillarsrx设置一点点
     */
    public void setPillars(float Pillarswidth, int PillarsColor, int Pillarsrx, int Pillarsry) {
        if (Pillarswidth > 0)
            Columnwidth = Pillarswidth * density;
        this.PillarsColor = PillarsColor;
        if (Pillarsrx > 0)
            this.Pillarsrx = Pillarsrx * density;
        if (Pillarsry > 0)
            this.Pillarsry = Pillarsry * density;
    }

    /**
     * = =是不是有点绕？建议不要去理解，去我的博客里面看图片吧亲。
     *
     * @param textDistanceUpPillars   柱子顶部和顶部文字的底部的间距
     * @param textDistanceDownPillars 柱子底部和底部文字顶部的间距
     */

    public void setTextDistanceUpPillars(float textDistanceUpPillars, float textDistanceDownPillars) {
        TextDistanceUpPillars = textDistanceUpPillars;
        TextDistanceDownPillars = textDistanceDownPillars;
    }

    private void ScrollToColumnNum() {
        if (ColumnNum == 0)
            return;
        if (ColumnNum > Column / 2 && ScrollFlag) {
            if (ColumnNum > Amount - Column / 2)
                mSaveOffset = mDrawOffset = -(firstpoint + ContainerLeftCoordinate * 2 + 2 * (Columnwidth + Columnspacing) * (Amount - Column / 2 - 1) - ContainerWidht / 2);
            else
                mSaveOffset = mDrawOffset = -(firstpoint + ContainerLeftCoordinate * 2 + 2 * (Columnwidth + Columnspacing) * (ColumnNum - 1) - ContainerWidht / 2);
            ScrollFlag = false;
        }
    }

    /**
     * 当该View绘制在屏幕上时，您可以设置将第几个柱子置于屏幕View的中间，需要注意的是columnNum<Column/2则不滑动，ColumnNum>Amount-Column/2则滑动到最后
     *
     * @param columnNum 需要滑动到第几个柱子
     */
    public void setScrollToColumnNum(int columnNum) {
        if (columnNum > 0)
            ColumnNum = columnNum;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Containerbottomcoordinate = Containerheight - ContainerBottomDistance;
        chartbottomedge = Containerbottomcoordinate - mTextHeight - TextDistanceDownPillars;
        charttopedge = ContainerTopCoordinate + TextDistanceUpPillars + mTextHeight;
        firstpoint = (ContainerWidht - ContainerLeftCoordinate * 2) / Column;
        Columnspacing = (firstpoint - Columnwidth * 2) / 2;
        canvaswigth = ContainerLeftCoordinate * 2 + (Amount + 1) * (Columnwidth * 2 + Columnspacing * 2);
        if (ymax == 0)
            for (int i = 0; i < ListDate.get(1).size(); i++) {
                if (Float.parseFloat(ListDate.get(1).get(i)) >= ymax) {
                    ymax = Float.parseFloat(ListDate.get(1).get(i));
                }
            }

        ScrollToColumnNum();


        drawback(canvas);
    }

    private void drawback(Canvas canvas) {
        mPaint.setShader(null);
        for (int i = 0; i < Amount && i != ListDate.get(0).size(); i++) {
            if (TextColorDownPillars != 0xff000000)
                mPaint.setColor(TextColorDownPillars);
            canvas.drawText(ListDate.get(0).get(i),
                    firstpoint + ContainerLeftCoordinate * 2 + (Columnwidth * 2 + Columnspacing * 2) * i + mDrawOffset,
                    Containerbottomcoordinate - mTextHeightOffset,
                    mPaint);
        }
        for (int i = 0; i < Amount; i++) {
            if (TextColorUpPillars != 0xff000000)
                mPaint.setColor(TextColorUpPillars);
            canvas.drawText(ListDate.get(1).get(i),
                    firstpoint + ContainerLeftCoordinate * 2 + (Columnwidth * 2 + Columnspacing * 2) * i + mDrawOffset,
                    getXianXingyH(Float.parseFloat(ListDate.get(1).get(i))) - charttopedge + mTextHeight,
                    mPaint);
        }
//	        canvas.save();
//	  		canvas.restore();
        for (int i = 0; i < Amount; i++) {
//	  			if(PillarsColor!=0xff000000)
//	 	        	mPaint.setColor(PillarsColor);
            if (Level1 > 0) {
                if (Level2 > Level1) {
                    if (Integer.parseInt(ListDate.get(1).get(i)) >= Level2)
                        mPaint.setColor(ColorLevel3);
                    else if (Integer.parseInt(ListDate.get(1).get(i)) >= Level1)
                        mPaint.setColor(ColorLevel2);
                    else
                        mPaint.setColor(ColorLevel1);

                } else if (Integer.parseInt(ListDate.get(1).get(i)) >= Level1)
                    mPaint.setColor(ColorLevel2);
                else
                    mPaint.setColor(ColorLevel1);
            } else
                mPaint.setColor(PillarsColor);
            canvas.drawRoundRect(new RectF(
                    firstpoint + ContainerLeftCoordinate * 2 + (Columnwidth * 2 + Columnspacing * 2) * i - Columnwidth + mDrawOffset,
                    getXianXingyH(Float.parseFloat(ListDate.get(1).get(i))),
                    firstpoint + ContainerLeftCoordinate * 2 + (Columnwidth * 2 + Columnspacing * 2) * i + Columnwidth + mDrawOffset,
                    chartbottomedge), Pillarsrx, Pillarsry, mPaint);
        }
        if (BaseLinecolor != 0xff000000)
            mPaint.setColor(BaseLinecolor);
        canvas.drawLine(
                firstpoint + ContainerLeftCoordinate * 2 - Columnwidth - Columnspacing + mDrawOffset,
                chartbottomedge,
                firstpoint + ContainerLeftCoordinate * 2 + (Columnwidth * 2 + Columnspacing * 2) * (Amount) - Columnwidth - Columnspacing + mDrawOffset,
                chartbottomedge, mPaint);
        canvas.save();
    }

    private float getXianXingyH(float h) {//柱子 高的倍数
        return (float) ((ymax - h) / ymax * (chartbottomedge - charttopedge) + charttopedge);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (ContainerWidht >= canvaswigth) {
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                break;
            case MotionEvent.ACTION_UP:
                mSaveOffset = mDrawOffset;
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                distance = moveX - downX;
                mDrawOffset = mSaveOffset + distance;
                if (mDrawOffset > 0) {
                    mDrawOffset = 0;
                } else if (mDrawOffset < ContainerWidht - ContainerLeftCoordinate * 2 - canvaswigth) {
                    mDrawOffset = ContainerWidht - ContainerLeftCoordinate * 2 - canvaswigth;
                }
                postInvalidate();
                break;
            default:
                break;
        }
        super.onTouchEvent(event);
        return true;
    }

}
