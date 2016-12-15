package com.example.vanes.sierpinski_android

/**
  * Created by vanes on 13.12.2016.
  */

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

class SierpinskiView(val context: Context, abc: Triangle) extends View(context) {
  private[sierpinski_android] val paint: Paint = new Paint
  private[sierpinski_android] val paintStart: Paint = new Paint
  private[sierpinski_android] val leftCounter: Int = 0
  private[sierpinski_android] val rightCounter: Int = 0
  private[sierpinski_android] val bottomCounter: Int = 0

  /*def this(context: Context) {
    this()
    super (context)
  }

  def this(context: Context, attrs: AttributeSet) {
    this()
    super (context, attrs)
  }*/

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val a: Point = new Point(0, 0 + 100)
    val b: Point = new Point(1080, 0 + 100)
    val c: Point = new Point(540, height(1080) + 100)
    val start: Triangle = new Triangle(a, b, c)
    paint.setStrokeWidth(2)
    paintStart.setStrokeWidth(7)
    drawTriangle(start, canvas, paintStart)
    val e: Point = new Point(start.a.x + length(start) / 4, start.a.y + height2(start) / 2)
    val f: Point = new Point(start.b.x - length(start) / 4, start.b.y + height2(start) / 2)
    val g: Point = new Point(start.c.x, start.c.y - height2(start))
    val second: Triangle = new Triangle(e, f, g)
    drawTriangle(second, canvas, paint)
    left(second, canvas, paint, leftCounter)
    right(second, canvas, paint, rightCounter)
    bottom(second, canvas, paint, bottomCounter)
  }

  def height(i: Int): Int = {
    return ((i / 2) * Math.sqrt(3)).toInt
  }

  def height2(t: Triangle): Int = {
    val len: Int = t.b.x - t.a.x
    return height(len)
  }

  def length(t: Triangle): Int = {
    return t.b.x - t.a.x
  }

  def drawTriangle(t: Triangle, k: Canvas, p: Paint) {
    k.drawLine(t.a.x, t.a.y, t.b.x, t.b.y, p)
    k.drawLine(t.a.x, t.a.y, t.c.x, t.c.y, p)
    k.drawLine(t.b.x, t.b.y, t.c.x, t.c.y, p)
  }

  def left(t: Triangle, k: Canvas, p: Paint, co: Int) {
    val count = co + 1
    val a: Point = new Point(t.a.x - length(t) / 4, t.a.y - height2(t) / 2)
    val b: Point = new Point(t.a.x + length(t) / 4, t.a.y - height2(t) / 2)
    val c: Point = new Point(t.a.x, t.a.y - height2(t))
    val n: Triangle = new Triangle(a, b, c)
    drawTriangle(n, k, p)
    if (count < 7) {
      left(n, k, p, count)
      right(n, k, p, count)
      bottom(n, k, p, count)
    }
  }

  def right(t: Triangle, k: Canvas, p: Paint, co: Int) {
    val count = co + 1
    val a: Point = new Point(t.b.x - length(t) / 4, t.b.y - height2(t) / 2)
    val b: Point = new Point(t.b.x + length(t) / 4, t.b.y - height2(t) / 2)
    val c: Point = new Point(t.b.x, t.b.y - height2(t))
    val n: Triangle = new Triangle(a, b, c)
    drawTriangle(n, k, p)
    if (count < 7) {
      left(n, k, p, count)
      right(n, k, p, count)
      bottom(n, k, p, count)
    }
  }

  def bottom(t: Triangle, k: Canvas, p: Paint, co: Int) {
    val count = co + 1
    val a: Point = new Point(t.a.x + length(t) / 4, t.a.y + height2(t) / 2)
    val b: Point = new Point(t.b.x - length(t) / 4, t.a.y + height2(t) / 2)
    val c: Point = new Point(t.a.x + length(t) / 2, t.a.y)
    val n: Triangle = new Triangle(a, b, c)
    drawTriangle(n, k, p)
    if (count < 7) {
      left(n, k, p, count)
      right(n, k, p, count)
      bottom(n, k, p, count)
    }
  }
}
