package com.example.day_16_1_paint_k


import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class Draw2D(context: Context) : View(context) {

    private val mPaint = Paint()
    private val mRect = Rect()
    private val mBitmap: Bitmap

    init {

        // Выводим значок из ресурсов
        val res = this.resources
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.hungrycat)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = canvas.width
        val height = canvas.height

        // стиль Заливка
        mPaint.style = Paint.Style.FILL

        // закрашиваем холст белым цветом
        mPaint.color = Color.WHITE
        canvas.drawPaint(mPaint)

        // Рисуем желтый круг
        mPaint.isAntiAlias = true
        mPaint.color = Color.YELLOW
        // canvas.drawCircle(950, 30, 25, mPaint);
        canvas.drawCircle((width - 30).toFloat(), 30f, 25f, mPaint)

        // Рисуем зеленый прямоугольник
        mPaint.color = Color.GREEN
        //  canvas.drawRect(20, 650, 950, 680, mPaint);
        canvas.drawRect(0f, (canvas.height - 30).toFloat(), width.toFloat(), height.toFloat(), mPaint)

        // Рисуем текст
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mPaint.textSize = 32f
        //  canvas.drawText("Лужайка только для котов", 30, 648, mPaint);
        canvas.drawText("Лужайка только для котов", 30f, (height - 32).toFloat(), mPaint)

        // Текст под углом
        // int x = 810;
        val x = width - 170
        val y = 190

        mPaint.color = Color.GRAY
        mPaint.textSize = 27f
        val beam = "Лучик солнца!"

        canvas.save()
        // Создаем ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(-45f, x + mRect.exactCenterX(), y + mRect.exactCenterY())

        // Рисуем текст
        mPaint.style = Paint.Style.FILL
        canvas.drawText(beam, x.toFloat(), y.toFloat(), mPaint)

        // восстанавливаем холст
        canvas.restore()

        // Выводим изображение
        // canvas.drawBitmap(mBitmap, 450, 530, mPaint);
        canvas.drawBitmap(mBitmap, (width - mBitmap.width).toFloat(), (height - mBitmap.height - 10).toFloat(), mPaint)
    }
}