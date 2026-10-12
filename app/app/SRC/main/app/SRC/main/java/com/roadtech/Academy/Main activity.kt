package com.roadtech.academy

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private val modules = listOf(
        "1. Computer Fundamentals",
        "2. Basic Computer Operations",
        "3. Microsoft Office",
        "4. Internet and Email",
        "5. Examinations and Certification"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scrollView = ScrollView(this)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 40, 32, 32)
            setBackgroundColor(Color.rgb(245, 248, 255))
        }

        val title = TextView(this).apply {
            text = "ROAD TECH 💻\nCOMPUTER ACADEMY"
            textSize = 27f
            setTextColor(Color.rgb(20, 55, 110))
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 20)
        }

        val welcome = TextView(this).apply {
            text = "Welcome, Future Computer Expert!\n\nStart learning computer skills step by step."
            textSize = 18f
            setTextColor(Color.DKGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 16, 0, 24)
        }

        layout.addView(title)
        layout.addView(welcome)

        val heading = TextView(this).apply {
            text = "YOUR LEARNING MODULES"
            textSize = 20f
            setTextColor(Color.rgb(20, 55, 110))
            setPadding(0, 16, 0, 16)
        }

        layout.addView(heading)

        modules.forEach { module ->
            val button = Button(this).apply {
                text = module
                textSize = 16f
                isAllCaps = false
                setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        "$module selected. Lessons coming soon!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            layout.addView(
                button,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 8, 0, 8)
                }
            )
        }

        val footer = TextView(this).apply {
            text = "\nLearn • Practise • Succeed\nRoad Tech Computer Academy"
            textSize = 15f
            gravity = Gravity.CENTER
            setTextColor(Color.GRAY)
            setPadding(0, 24, 0, 20)
        }

        layout.addView(footer)
        scrollView.addView(layout)
        setContentView(scrollView)
    }
}
