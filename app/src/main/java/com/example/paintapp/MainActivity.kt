package com.example.paintapp

import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        var path = android.graphics.Path()
        var paint = Paint()
        var selectedPaint = "pencil";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pencil = findViewById<ImageView>(R.id.pencil)
        val arrow = findViewById<ImageView>(R.id.arrow)
        val rectangle = findViewById<ImageView>(R.id.square)
        val circle = findViewById<ImageView>(R.id.circle)
        val color = findViewById<ImageView>(R.id.color)

        pencil.setOnClickListener {
            selectedPaint = "pencil";
        }

        arrow.setOnClickListener {
            selectedPaint = "arrow";
        }

        rectangle.setOnClickListener {
            selectedPaint = "rectangle";
        }

        circle.setOnClickListener {
            selectedPaint = "circle";
        }

        color.setOnClickListener {

        }
    }
}