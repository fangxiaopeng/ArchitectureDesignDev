package com.fxp.contact.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import java.util.List;

/**
 * Title:       WaterMarkBg
 * <p>
 * Package:     com.fxp.contact.core.widget
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/2/15 11:04 AM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/2/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class WaterMarkBg extends Drawable {

    private Paint paint = new Paint();
    private List<String> labels;
    private Context context;
    private int degress;//角度
    private int fontSize;//字体大小 单位sp
    private int concentration;//密集度
    private String canvasColor;

    /**
     * 初始化构造
     * @param context 上下文
     * @param labels 水印文字列表 多行显示支持
     * @param degress 水印角度
     * @param fontSize 水印文字大小
     * @param concentration 密集度
     */
    public WaterMarkBg(Context context, List<String> labels, int degress, int fontSize, int concentration, String canvasColor) {
        this.labels = labels;
        this.context = context;
        this.degress = degress;
        this.fontSize = fontSize;
        this.concentration = concentration;
        this.canvasColor = canvasColor;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

        DisplayMetrics curMetrics = context.getResources().getDisplayMetrics();
        int width = curMetrics.widthPixels;
        int height = curMetrics.heightPixels;

        if(canvasColor != null)
            canvas.drawColor(Color.parseColor(canvasColor));
        paint.setColor(Color.parseColor("#50AEAEAE"));

        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(context,fontSize));
        canvas.save();
        canvas.rotate(degress);
        float textWidth = paint.measureText(labels.get(labels.size()-1));
        int index = 0;
        for (int positionY = height / concentration; positionY <= height; positionY += height / concentration) {
            float fromX = -width + (index++ % 2) * textWidth;
            for (float positionX = fromX; positionX < width; positionX += textWidth * 2) {
                int spacing  = 0;//间距
                for(String label:labels){
                    paint.setTextAlign(Paint.Align.CENTER);
                    canvas.drawText(label, positionX, positionY+spacing, paint);
                    spacing = spacing+40;
                }

            }
        }
        canvas.restore();
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }


    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
