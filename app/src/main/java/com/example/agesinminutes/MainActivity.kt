package com.example.agesinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { view->
            selectDatePicker(view)
        }
    }

    fun selectDatePicker(view: View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH + 1)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "The chosen date is$selectedDayOfMonth/$selectedMonth/$selectedYear"
                    , Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/$selectedMonth/$selectedYear"

                textView4.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate.time / 60000

            }
            , year
            , month
            , day).show()
    }
}