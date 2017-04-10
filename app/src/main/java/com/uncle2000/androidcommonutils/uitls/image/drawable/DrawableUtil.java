package com.uncle2000.androidcommonutils.uitls.image.drawable;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import java.util.Random;

/**
 * Created by 2000 on 2017/4/10.
 */

public class DrawableUtil {
    /**
     * 创建随机背景的drawable
     *
     * @return
     */

//    TextView tv = new TextView(this);
//    GradientDrawable pressDrawable = DrawableUtil.createDrawable(0xffcecece);
//    GradientDrawable randomDrawable = DrawableUtil.createRandomDrawable();
//    StateListDrawable stateListDrawable = DrawableUtil.createStateDrawable(pressDrawable, randomDrawable);
//    textView.setBackgroundDrawable(stateListDrawable);
    public static GradientDrawable createDrawable() {
        GradientDrawable drawable = new GradientDrawable();
//        drawable.setCornerRadius(Util.px2dip(5));//><
        Random random = new Random();
        int red = random.nextInt(200) + 20;
        int green = random.nextInt(200) + 20;
        int blue = random.nextInt(200) + 20;
        int color = Color.rgb(red, green, blue);
        drawable.setColor(color);
        return drawable;
    }

    /**
     * 使用代码实现状态选择器
     *
     * @param press
     * @param normal
     * @return
     */
    public static StateListDrawable createStateDrawable(Drawable press, Drawable normal) {
        StateListDrawable drawable = new StateListDrawable();
        //按下
        drawable.addState(new int[]{android.R.attr.state_pressed}, press);
        //正常
        drawable.addState(new int[]{}, normal);
        return drawable;
    }
}
