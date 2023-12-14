package com.example.calendar3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.app.Activity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ScrollView
import android.graphics.Color
import android.view.View

class MainActivity : AppCompatActivity() {
    val ADD_EVENT_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Para ni sa Exit
        val exitImageView: ImageView = findViewById(R.id.exit)
        exitImageView.setOnClickListener {
            Toast.makeText(this, "You are now leaving our app", Toast.LENGTH_SHORT).show()
            finish()
        }

        //Para sa add event
        val event: Button = findViewById(R.id.addEvent)
        event.setOnClickListener{
            val intent = Intent(this, Event::class.java)
            startActivityForResult(intent, ADD_EVENT_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_EVENT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra("title")
            val description = data?.getStringExtra("description")
            val date = data?.getStringExtra("date")

            val eventTextView = TextView(this)
            eventTextView.setPadding(26, 0, 16, 8)
            eventTextView.textSize = 16f
            eventTextView.setTextColor(Color.BLACK)

            val newText = "Title: $title \tDescription: $description\nDate: $date"
            eventTextView.text = newText

            val scrollView = findViewById<ScrollView>(R.id.scroll)
            val linearLayout = scrollView.findViewById<LinearLayout>(R.id.scrollLinearLayout)
            linearLayout.addView(eventTextView)

            scrollView.post { scrollView.fullScroll(View.FOCUS_UP)  }
        }
    }
}