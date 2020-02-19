package com.allever.handcoderdemo.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.print.PrinterId;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class CircleImageView extends AppCompatImageView {

    private Path mPath = new Path();
    private Paint mPaint = new Paint();

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
        init();
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        float x = width / 2;
        float y = height / 2;
        float r = x > y ? y: x;
        mPath.addCircle(x, y, r, Path.Direction.CW);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setXfermode(mXfermode);
        canvas.drawPath(mPath, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();
    }
}
