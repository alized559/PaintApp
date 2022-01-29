package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paint
import com.example.paintapp.MainActivity.Companion.path
import com.example.paintapp.MainActivity.Companion.selectedPaint

class Paint : View {

    companion object {
        var paths = ArrayList<Path>()
        var colors = ArrayList<Int>()
        var currentColor = Color.BLACK
    }

    var params : ViewGroup.LayoutParams? = null

    constructor(context: Context) : this(context, null) {
        paint()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        paint()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        paint()
    }

    private fun paint() {
        paint.isAntiAlias = true
        paint.color = currentColor
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (selectedPaint.equals("pencil")) {
            var x = event.x
            var y = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    path.moveTo(x, y)
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(x, y)
                    paths.add(path)
                    colors.add(currentColor)
                }
                else -> return false
            }
            postInvalidate()
        } else if (selectedPaint.equals("arrow")) {

        }
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in paths.indices) {
            paint.setColor(colors[i])
            canvas.drawPath(paths[i], paint)
            invalidate()
        }
    }
}