package com.kkmtk00314.study_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewbinding.ViewBinding
import com.kkmtk00314.study_2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        val data = extras!!["text"] as String

        viewBinding.tvSecondtext.text = data

        viewBinding.btn2Intent.setOnClickListener {
            val intent = Intent(this, ThridActivity::class.java)
            startActivity(intent)
        }

        viewBinding.btn2Back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("String","String")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}