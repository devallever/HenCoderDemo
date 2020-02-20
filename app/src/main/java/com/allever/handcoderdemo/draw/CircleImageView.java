package com.allever.handcoderdemo.draw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;

import androidx.annotation.IdRes;
import androidx.appcompat.widget.AppCompatImageView;

import com.allever.lib.common.util.DisplayUtils;

public class CircleImageView extends AppCompatImageView {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();

    private int mBorderWidth = DisplayUtils.INSTANCE.dip2px(1);
    private int mBorderColor = 0;

    private PorterDuff.Mode mPorterDuffMode = PorterDuff.Mode.DST_IN;
    private Xfermode mXfermode = new PorterDuffXfermode(mPorterDuffMode);

    public CircleImageView(Context context) {
        super(context);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int result = width > height ? height: width;
        setMeasuredDimension(result, result);
    }

    private void init() {
        mBorderColor = Color.parseColor("#ffffff");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);

        float width = getMeasuredWidth();
        float height = getMeasuredHeight();

        //缩小画布
//        float sx = 1f * (width - 2 * mBorderWidth) / width;
//        float sy = 1f * (height - 2 * mBorderWidth) / height;
//        canvas.scale(sx, sy, width /2f, height /2f);

        float sx = 1.0f * (width - 2 * mBorderWidth) / width;
        float sy = 1.0f * (height - 2 * mBorderWidth) / height;
        // 缩小画布，使图片内容不被border、padding覆盖
        canvas.scale(sx, sy, width / 2.0f, height / 2.0f);

        super.onDraw(canvas);

        float x = width  / 2;
        float y = height  / 2;
        float r = x > y ? y: x;
        mPath.addCircle(x, y, r, Path.Direction.CW);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(mXfermode);
        canvas.drawPath(mPath, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();

        drawBorder(canvas);
    }

    private void drawBorder(Canvas canvas) {
        mPaint.reset();

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mBorderWidth);
        mPaint.setColor(mBorderColor);
        float x = getMeasuredWidth() / 2;
        float y = getMeasuredHeight() / 2;
        float r = x > y ? y: x;
        r = r - mBorderWidth / 2;
        canvas.drawCircle(x, y, r, mPaint);
    }

    public void setBorderWidth(int width) {
        mBorderWidth = width;
        invalidate();
    }

    @SuppressLint("ResourceType")
    public void setBorderColor(@IdRes int color) {
        if (color != 0) {
            mBorderColor = getResources().getColor(color);
        }
    }
}
