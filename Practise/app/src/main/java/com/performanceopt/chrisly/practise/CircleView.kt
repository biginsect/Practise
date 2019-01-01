package com.performanceopt.chrisly.practise

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author big insect
 * @date 2019/1/1.
 */
class CircleView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var defaultSize: Int
    private val mPaint: Paint = Paint()
    private val centerX: Int
    private val centerY: Int

    init {
        mPaint.color = Color.GREEN
        val a = context.obtainStyledAttributes(attrs, R.styleable.CircleView)
        defaultSize = a.getDimensionPixelSize(R.styleable.CircleView_default_size, 50)
        centerX = a.getDimensionPixelSize(R.styleable.CircleView_center_x, 0)
        centerY = a.getDimensionPixelSize(R.styleable.CircleView_center_y, 0)
        a.recycle()
    }

    private fun getSize(defSize: Int, measureSpec: Int): Int {
        var mySize = defSize
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        when (mode) {
            MeasureSpec.UNSPECIFIED -> mySize = defSize
            MeasureSpec.AT_MOST -> mySize = size
            MeasureSpec.EXACTLY -> mySize = size
        }

        return mySize
    }

    /**
     * 测量宽和高，之后会调用onLayout()，确定当前view在父容器中的位置}
     * */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = getSize(defaultSize, widthMeasureSpec)
        var height = getSize(defaultSize, heightMeasureSpec)

        if (width < height) {
            height = width
        } else {
            width = height
        }

        setMeasuredDimension(width, height)
    }

    /**
     * 绘制view，在onMeasure、onLayout、onDraw中最后执行
     * 确定圆心得位置：当指定的x or y 都小于r时指定位置为（r + left, r + top）
     * */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val radius = measuredHeight / 2

        canvas?.drawCircle(centerX.toFloat(), centerY.toFloat(), radius.toFloat(), mPaint)
    }
}