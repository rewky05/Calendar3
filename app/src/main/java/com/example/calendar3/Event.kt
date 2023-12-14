package com.example.calendar3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.Activity
import android.widget.EditText
import android.widget.TimePicker
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Toast

class Event : AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var dateDatePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        //For back
        val backEvent: ImageView = findViewById(R.id.back)
        backEvent.setOnClickListener {
            onBackPressed()
        }

        titleEditText = findViewById(R.id.titleET)
        descriptionEditText = findViewById(R.id.messageET)
        dateDatePicker = findViewById(R.id.datePicker)

        val submit: Button = findViewById(R.id.submitBtn)
        submit.setOnClickListener {
            val intent = Intent()

            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            val year = dateDatePicker.year
            val month = dateDatePicker.month
            val dayOfMonth = dateDatePicker.dayOfMonth

            val date = StringBuilder().apply {
                append(year).append("-")
                append((month + 1).toString().padStart(2, '0')).append("-")
                append(dayOfMonth.toString().padStart(2, '0'))
            }.toString()

            intent.putExtra("title", title)
            intent.putExtra("description", description)
            intent.putExtra("date", date)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}