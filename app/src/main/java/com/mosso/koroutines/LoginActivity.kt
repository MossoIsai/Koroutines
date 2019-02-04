package com.mosso.koroutines

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Execute Coroutine UI
       val job = GlobalScope.launch(Dispatchers.Main){
            for ( i in 10 downTo  1){
                tvtMesagge.text = "Contador: $i"
                delay(500)
            }
            tvtMesagge.text = getString(R.string.label_done)
        }
        //cancel coroutine on click
        btnCancelCount.setOnClickListener { job.cancel()  }
    }
}
