package com.gofar.library;

/**
 * @author lcf
 * @date 30/11/2018 下午 5:58
 * @since 1.0
 */
public class PieChartItemData extends ChartItemData {
    private float startAngle;
    private float sweepAngle;

    public float getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }
}