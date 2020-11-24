package ru.ridkeim.graphicstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var draw2D: Draw2D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        draw2D = Draw2D(this)
        setContentView(draw2D)
    }
}