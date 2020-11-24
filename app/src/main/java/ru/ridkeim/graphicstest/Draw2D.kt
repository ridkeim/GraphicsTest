package ru.ridkeim.graphicstest

import android.content.Context
import android.graphics.*
import android.os.Build
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class Draw2D(context: Context?) : View(context) {
    private val paint = Paint()
    private val bitmap : Bitmap
    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            isForceDarkAllowed = false
        }
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat_bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCanvas(canvas)
        drawSun(canvas)
        drawGrass(canvas)
        drawCat(canvas)
    }

    private fun drawCat(canvas: Canvas?) {
        canvas?.drawBitmap(
            bitmap,
            (width - bitmap.width).toFloat(),
            (height - bitmap.height - 10).toFloat(),
            paint
        )
    }

    private fun drawGrass(canvas: Canvas?) {
        paint.color = Color.GREEN
        canvas?.drawRect(
            0f,
            height - (min(width, height) * 0.1f),
            width.toFloat(),
            height.toFloat(),
            paint
        )
    }

    private fun drawSun(canvas: Canvas?) {
        paint.isAntiAlias = true
        paint.color = Color.YELLOW
        val radius = min(width,height)*0.2f
        canvas?.drawCircle(width.toFloat(), 0f, radius, paint)
        val oldWidth =  paint.strokeWidth
        paint.strokeWidth = 3f
        for (i in 5..90 step 10){
            val rad = (i*PI/180).toFloat()
            val startX = cos(rad)
            val startY = sin(rad)
            canvas?.drawLine(width-startX*radius, startY*radius, width-2*startX*radius, 2*startY*radius,paint)
        }
        paint.strokeWidth = oldWidth
    }

    private fun drawCanvas(canvas: Canvas?) {
        paint.style = Paint.Style.FILL
        paint.color = Color.CYAN
        canvas?.drawPaint(paint)
    }


}