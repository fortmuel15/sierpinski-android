package com.example.vanes.sierpinski_android

import android.content.Context
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity extends AppCompatActivity {
  private[sierpinski_android] var sv: SierpinskiView = null

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val g: Point = new Point(0,0)
    val a: Point = new Point(0,0)
    val y: Point = new Point(0,0)

    val ihs: Triangle = new Triangle(g,a,y)

    sv = new SierpinskiView(this, ihs)
    setContentView(sv)
  }
}
