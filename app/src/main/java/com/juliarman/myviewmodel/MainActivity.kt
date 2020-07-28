package com.juliarman.myviewmodel


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyButtonEnable()
        EdBehavior()

    }

    private fun EdBehavior() {

        myEditText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                setMyButtonEnable()

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


        my_button.setOnClickListener{Toast.makeText(this@MainActivity, myEditText.text, Toast.LENGTH_SHORT).show()}

    }

    private fun setMyButtonEnable() {
        val result = myEditText.text
        my_button.isEnabled = result != null && result.toString().isNotEmpty()
    }


}