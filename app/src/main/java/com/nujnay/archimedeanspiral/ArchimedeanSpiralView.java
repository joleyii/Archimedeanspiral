package com.nujnay.archimedeanspiral;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 123 on 2017/9/24.
 */

public class ArchimedeanSpiralView extends View {
    private float width;
    private float hight;
    private Paint paint1;

    public ArchimedeanSpiralView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(dp2px(1));

    }

    boolean first = true;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        for (int i = 5445; i > 0; i--) {
            double angle = i * Math.PI / 512;
            double radius = 1 * angle;
            if (radius < width / 50) {
                int x = (int) Math.round(radius * angle * Math.cos(angle + 5));
                int y = (int) Math.round(radius * angle * Math.sin(angle + 5));
                if (first) {
                    first = false;
                    path.moveTo(width / 2 + x, hight / 2 + y);
                } else {
                    path.lineTo(width / 2 + x, hight / 2 + y);
                }
            }
        }
        canvas.drawPath(path, paint1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        hight = getMeasuredHeight();
    }

    public float dp2px(float dp) {
        float density = getResources().getDisplayMetrics().density;
        return dp * density;
    }

}
