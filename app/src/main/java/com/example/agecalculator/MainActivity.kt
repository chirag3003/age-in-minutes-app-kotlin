package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }


    }
    fun clickDatePicker(){
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val Dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view, year,month,date ->
                val sDate = findViewById<TextView>(R.id.date)
                val minDiff = findViewById<TextView>(R.id.min)
                val selectedDate = "${date}/${month+1}/$year"

                sDate.setText(selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val d = sdf.parse(selectedDate)
                val selDate = d.time / 60000;
                val cDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val curDate = cDate.time / 60000;
                val diff = curDate - selDate;
                minDiff.setText(diff.toString())

            },
            year,month,day
            )
        Dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        Dpd.show();
    }
}