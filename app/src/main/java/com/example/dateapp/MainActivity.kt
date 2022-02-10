package com.example.dateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*

/*
   purpose: This app allows user to choose 3 dates and will then display
            those date by day of the week, year, month, day of the month
            format.
   Work: Spencer -
         Braxton -
   app name: Date App
   minSDK 21, targetSDK 31
   author(s): Spencer Parton and Braxton Elrod
   version 02/10/2022
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
                var datePicker = findViewById<DatePicker>(R.id.datePicker1)
        var txv = findViewById<TextView>(R.id.textView1)
        var btnGet = findViewById<Button>(R.id.button1)
        var yy:Int = 0
        var mm:Int = 0
        var dd:Int = 0
        val calendar:Calendar = Calendar.getInstance()
        datePicker.init(calendar[Calendar.YEAR],
        calendar[Calendar.MONTH],
        calendar[Calendar.DAY_OF_MONTH]){
            datePicker, year, month, dayOnMonth ->
                yy = year
                mm = month + 1
                dd = dayOnMonth
        }
        btnGet.setOnClickListener(){
            txv.text = "Selected Date:" + mm + "/" + dd + "/" + yy
        }
    }
}