package com.example.wheel

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.view.animation.DecelerateInterpolator
import android.animation.ObjectAnimator




class MainActivity : AppCompatActivity() {

    private lateinit var etPercent : EditText
    private lateinit var btSubmit : Button
    private lateinit var pbLoader : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPercent = findViewById(R.id.et_percent)
        btSubmit = findViewById(R.id.bt_submit)
        pbLoader = findViewById(R.id.pb_loader)

        btSubmit.setOnClickListener {

            if(etPercent.text.isNotEmpty()){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    val per = etPercent.text.toString().toInt()
                    val animation = ObjectAnimator.ofInt(
                        pbLoader,
                        "progress",
                        0,
                        per)
                    animation.duration = 30*etPercent.text.toString().toLong()
                    animation.start()
                }
            }
        }


    }
}
