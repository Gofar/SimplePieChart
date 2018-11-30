package com.gofar.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * @author lcf
 * @date 30/11/2018 下午 3:25
 * @since 1.0
 */
public class PieChartView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();
    private float mBorder;
    private List<PieChartItemData> mData;
    private int mOutBorderColor;

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();
        // 减去内边距，计算中心点
        float centerX = (width - getPaddingLeft() - getPaddingRight()) / 2;
        float centerY = (height - getPaddingTop() - getPaddingBottom()) / 2;
        float radius = Math.min(centerX, centerY);
        if (mBorder <= 0) {
            // 默认边框宽度为半径的1/5
            mBorder = radius / 5;
        }

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mBorder);
        float outRadius = radius - mBorder / 2;
        float inLeft = centerX - outRadius + mBorder;
        float inRight = centerX + outRadius - mBorder;
        float inTop = centerY - outRadius + mBorder;
        float inBottom = centerY + outRadius - mBorder;

        if (mData != null && !mData.isEmpty()) {
            mPaint.setColor(mOutBorderColor);
            canvas.drawCircle(centerX, centerY, outRadius, mPaint);
            for (PieChartItemData data : mData) {
                mPaint.setColor(data.getColor());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    canvas.drawArc(inLeft, inTop, inRight, inBottom, data.getStartAngle() - 0.5f, data.getSweepAngle() + 0.5f, false, mPaint);
                } else {
                    mRectF.set(inLeft, inTop, inRight, inBottom);
                    canvas.drawArc(mRectF, data.getStartAngle() - 0.5f, data.getSweepAngle() + 0.5f, false, mPaint);
                }
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int length = Math.min(widthSize, heightSize);
        setMeasuredDimension(length, length);
    }

    public void setOutBorderColor(int outBorderColor) {
        mOutBorderColor = outBorderColor;
    }

    public void setData(List<PieChartItemData> data) {
        mData = data;
        invalidate();
    }
}
