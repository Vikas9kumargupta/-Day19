package com.example.day19

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.day19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close tha App?")
            builder1.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            builder1.setPositiveButton("YES", DialogInterface.OnClickListener{
                dialogInterface, i ->   //What action should be performed when Yes is clicked ?
                finish()
            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener{
              dialogInterface, i ->
                Toast.makeText(this,"You want to continue the App",Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
        binding.btn2.setOnClickListener{
            val options = arrayOf("Gulab Jamun", "Rasmallai", "KajuKatli", "Rasgulla")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener{
                dialog, which ->
                //What action should be performed when user clicks on any option
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener{ dialogInterface, which ->
                Toast.makeText(this, "Your selected item is Submitted", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, which ->
                //What action should be performed when Yes is clicked?
                Toast.makeText(this,"You want to continue the App",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }
        binding.btn3.setOnClickListener{
            val options = arrayOf("Gulab Jamun", "Rasmallai", "KajuKatli", "Rasgulla")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener{ dialogInterface, which ->
                Toast.makeText(this, "Your selected item is Submitted", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, which ->
                //What action should be performed when Yes is clicked?
                Toast.makeText(this,"You want to continue the App",Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }
    }
}