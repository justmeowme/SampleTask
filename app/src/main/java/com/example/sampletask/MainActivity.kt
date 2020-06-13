package com.example.sampletask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Rational
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mType1 = "RUB"
        var mType2 = "USD"

        val mListOfTypes = listOf("RUB", "USD", "EUR", "UAH", "GBP")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mListOfTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        list1.adapter = adapter
        list2.adapter = adapter

        list1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long) {
                mType1 = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        list2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long) {
                mType2 = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        var mUsd: Double;
        mUsd = 69.0;
        var mEur: Double;
        mEur = 77.0;
        var mUah: Double;
        mUah = 2.6;
        var mGbp: Double;
        mGbp = 87.1;


        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var mFirst = findViewById<EditText>(R.id.first_number)
                var count = mFirst.text.toString().toInt();
                var ans: Double;
                ans = 0.0;
                if (mType1=="RUB"){
                    if (mType2=="RUB"){
                        ans = count*1.0;
                    }
                    if (mType2=="USD"){
                        ans = count*mUsd;
                    }
                    if (mType2=="EUR"){
                        ans = count*mEur;
                    }
                    if (mType2=="UAH"){
                        ans = count*mUah;
                    }
                    if (mType2=="GPB"){
                        ans = count*mGbp;
                    }
                }
                if (mType1=="USD"){
                    if (mType2=="RUB"){
                        ans = mUsd*count;
                    }
                    if (mType2=="USD"){
                        ans = count*1.0;
                    }
                    if (mType2=="EUR"){
                        ans = mUsd*count/mEur;
                    }
                    if (mType2=="UAH"){
                        ans = mUsd*count/mUah;
                    }
                    if (mType2=="GPB"){
                        ans = mUsd*count/mGbp;
                    }
                }
                if (mType1=="EUR"){
                    if (mType2=="RUB"){
                        ans = count*mEur;
                    }
                    if (mType2=="USD"){
                        ans = mEur*count/mUsd;
                    }
                    if (mType2=="EUR"){
                        ans = count*1.0;
                    }
                    if (mType2=="UAH"){
                        ans = mEur*count/mUah;
                    }
                    if (mType2=="GPB"){
                        ans = mEur*count/mGbp;
                    }
                }
                if (mType1=="UAH"){
                    if (mType2=="RUB"){
                        ans = count*mUah;
                    }
                    if (mType2=="USD"){
                        ans = mUah*count/mUsd;
                    }
                    if (mType2=="EUR"){
                        ans = mUah*count/mEur;
                    }
                    if (mType2=="UAH"){
                        ans = count*1.0;
                    }
                    if (mType2=="GPB"){
                        ans = mUah*count/mGbp;
                    }
                }
                if (mType1=="GBP"){
                    if (mType2=="RUB"){
                        ans = count*mGbp;
                    }
                    if (mType2=="USD"){
                        ans = mGbp*count/mUsd;
                    }
                    if (mType2=="EUR"){
                        ans = mGbp*count/mEur;
                    }
                    if (mType2=="GBP"){
                        ans = count*1.0;
                    }
                    if (mType2=="UAH"){
                        ans = mGbp*count/mUah;
                    }
                }

                Math.round(ans*100)/100.0;

                val x = ans.toString();
                var mSecond = findViewById<EditText>(R.id.second_number);
                second_number.setText(x);
            }
        })
    }
}

