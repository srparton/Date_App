package com.example.dateapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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
    var dateAmount = 0 //how many dates used
    var datesArray = arrayOfNulls<String>(3)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pad = findViewById<Button>(R.id.pickADate)
        val show = findViewById<Button>(R.id.show)

        pad.setOnClickListener {
            if (dateAmount >= 3) {
                Toast.makeText(this, "Already Picked 3 dates",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var remSting =(2 - dateAmount).toString() +  " Remaining clicks" // may not be correct amount
            Toast.makeText(this,remSting,Toast.LENGTH_SHORT).show()
            val cald = Calendar.getInstance()
            val year = cald.get(Calendar.YEAR)
            val month = cald.get(Calendar.MONTH)
            val day = cald.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this,
                {view, year,monthOfYear, dayOfMonth -> savePick(year, monthOfYear,dayOfMonth)},
                year,
                month,
                day
            )
            datePicker.show()
        }
        show.setOnClickListener{
            var i = 0
            val a1 = findViewById<TextView>(R.id.activity1Date)
            val a2 = findViewById<TextView>(R.id.activity2Date)
            val a3 = findViewById<TextView>(R.id.activity3Date)
            a1.text = datesArray[0]
            a2.text = datesArray[1]
            a3.text = datesArray[2]
        }
    }
    private fun savePick(yy: Int, mm: Int, dd: Int){
        var d = Date()
        if (dateAmount >=3)
            return
        datesArray[dateAmount] = "Year ->" + yy + "Month-> " + mm + "Day ->" + dd
        dateAmount += 1
        return
    }
}