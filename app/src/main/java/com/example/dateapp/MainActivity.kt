package com.example.dateapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.util.*

/*
   purpose: This app allows user to choose 3 dates and will then display
            those date by day of the week, year, month, day of the month
            format.
   Work: Spencer - Created project, added logic for finding DayOfWeek, padded
         date and formatted layout.
         Braxton -
   Learning: Spencer - In this project I learned more about API requirements. Some
                       of the more modern methods of finding the date or the day of
                       the week were not supported. IE LocalDate class. I also learned
                       more about the Calendar Class and its extension the GregorianCalendar
                       as I explored how to find the day of the week and to properly format
                       our date output. I probably wound up coding about 40% of this project
                       with Braxton coding the other 60%.
             Braxton -
   app name: Date App
   minSDK 21, targetSDK 31
   author(s): Spencer Parton and Braxton Elrod
   version 02/10/2022
 */

class MainActivity : AppCompatActivity() {
    var dateAmount = 0 //how many dates used
    var datesArray = arrayOfNulls<String>(3)
    var weekDayName = arrayOf<String>("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")

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

            var remSting =(3 - dateAmount).toString() +  " Remaining Picks"
            Toast.makeText(this,remSting,Toast.LENGTH_SHORT).show()
            val cald = Calendar.getInstance()
            val year = cald.get(Calendar.YEAR)
            val month = cald.get(Calendar.MONTH)
            val day = cald.get(Calendar.DAY_OF_MONTH)
            val datePicker = DatePickerDialog(this,
                {view, year, monthOfYear, dayOfMonth -> savePick(year, monthOfYear,dayOfMonth)},
                year,
                month,
                day,
            )

            datePicker.show()
        }
        show.setOnClickListener{
            val a1 = findViewById<TextView>(R.id.activity1Date)
            val a2 = findViewById<TextView>(R.id.activity2Date)
            val a3 = findViewById<TextView>(R.id.activity3Date)
            a1.text = datesArray[0]
            a2.text = datesArray[1]
            a3.text = datesArray[2]
        }
    }

//    private fun DatePickerDialog(mainActivity: MainActivity, i: Int, year: Int, i1: Int, day: Int, wkDay: Int): DatePickerDialog {
//
//    }

    private fun savePick(yy: Int, mm: Int, dd: Int){

        var mon = mm + 1
        var date = GregorianCalendar(yy,mm,dd)
        val wkDayInt = date.get(Calendar.DAY_OF_WEEK)
        Log.d("wkDayInt","wkDayInt = "+wkDayInt)
        val wkDay = weekDayName[wkDayInt-1]
        Log.d("wkDay","wkDay: "+wkDay)
        if (dateAmount >=3)
            return
//        val unformatted = "is on " + wkDay + ", " +yy + "/" + mon + "/" + dd
//        val formatted =
//        Log.d("formated","Formatted:"+formatted)
        datesArray[dateAmount] = String.format("is on " + wkDay + ", " +"%02d" + "/" + "%02d" + "/" + "%02d",yy,mon,dd)
        dateAmount += 1
        return
    }
}