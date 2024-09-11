package com.example.kotlin_listview_spinner_datapass4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    val language1 = arrayOf<String>("C","C++","Java",".Net","Kotlin","Ruby",
        "Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")

    lateinit var btnSend: Button

    lateinit var etName: TextView
    lateinit var etRoll: TextView

    lateinit var lvname: String
    lateinit var spname: String


    //---global spinner

    lateinit var sv: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //DP
        btnSend = findViewById(R.id.b_datapass)
        etName = findViewById(R.id.tv_lv_data)
        etRoll = findViewById(R.id.tv_spnner_data)
        //DP

        // val language:Array<String> = resources.getStringArray(R.array.studdent_name)

        val listView = findViewById(R.id.listView) as ListView
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,language1)

        //val tvshow = findViewById(R.id.tv1) as TextView
        listView.adapter = arrayAdapter


        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            Toast.makeText(applicationContext,"click item $selectedItem its position $itemIdAtPos",
                Toast.LENGTH_SHORT).show()

            lvname=selectedItem

            etName.text=lvname
        }

        //------------------spinner----------------
        //val sv = findViewById<Spinner>(R.id.sv1)
        sv = findViewById<Spinner>(R.id.sv1)


        val arrayAdapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, language1)
        sv.adapter =arrayAdapter1







        sv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val itemIdAtPos1 = language1[position]


                spname= itemIdAtPos1

                etRoll.text=spname


                // Toast.makeText(applicationContext,"click item $selectedItem1 its position $itemIdAtPos1", Toast.LENGTH_SHORT).show()
                // Toast.makeText(applicationContext,"click item  $itemIdAtPos1", Toast.LENGTH_SHORT).show()
            }

            //-------------------------------------
        }

        //------------------------------------------------------------------
        //-----------data pass------


        btnSend.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("name", lvname)
            // bundle.putString("roll", spname)
//or
            //-------direct data pic from spinner

            var spname: String = sv.selectedItem.toString()
            bundle.putString("roll", spname)
            //-------direct data pic from spinner

            val intent = Intent(this, page2::class.java)

            intent.putExtras(bundle)

            startActivity(intent)
        }

        //--data pass


    }
}