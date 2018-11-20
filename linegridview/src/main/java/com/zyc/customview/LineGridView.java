package com.zyc.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

public class LineGridView extends GridView {

    private int rownum;
    private boolean lineShow;
    private int lineColor;
    private float lineWidth;

    //实现构造方法
    public LineGridView(Context context) {
        this(context, null);
    }

    public LineGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.linegridview);
        lineColor = mTypedArray.getColor(R.styleable.linegridview_lineColor, 0xa0000000);
        lineShow = mTypedArray.getBoolean(R.styleable.linegridview_lineShow, true);
        lineWidth = mTypedArray.getFloat(R.styleable.linegridview_lineWidth, 1.0f);

    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineShow(boolean lineShow) {
        this.lineShow = lineShow;
    }

    public boolean isLineShow() {
        return lineShow;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (lineShow) {
            int colnum = getNumColumns(); //获取列数
            int total = getChildCount();  //获取Item总数

            //计算行数
            rownum = total / colnum;
            if (total % colnum != 0) {
                rownum = (total / colnum) + 1; //当余数不为0时，要把结果加上1
            }
            Paint localPaint; //设置画笔
            localPaint = new Paint();
            localPaint.setStyle(Paint.Style.STROKE); //画笔实心
            localPaint.setColor(lineColor);//画笔颜色
            localPaint.setStrokeWidth(lineWidth);


            View view0 = getChildAt(0); //第一个view
            View viewColLast = getChildAt(colnum - 1);//第一行最后一个view
            View viewRowLast = getChildAt((rownum - 1) * colnum); //第一列最后一个view

            for (int i = 1, c = 1; i < rownum || c < colnum; i++, c++) {
                //画横线
                canvas.drawLine(view0.getLeft(), view0.getBottom() * i, viewColLast.getRight(), viewColLast.getBottom() * i, localPaint);
                //画竖线
                canvas.drawLine(view0.getRight() * c, view0.getTop(), viewRowLast.getRight() * c, viewRowLast.getBottom(), localPaint);
            }
        }
    }
}
