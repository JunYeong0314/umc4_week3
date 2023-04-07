package com.kkmtk00314.study_2

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.kkmtk00314.study_2.databinding.ActivityMainBinding
import com.kkmtk00314.study_2.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity(){
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var getResultText:ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnIntent.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", "message from Main")
            getResultText.launch(intent)
        }
        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("String")
                Toast.makeText(this, data, Toast.LENGTH_LONG).show()
            }
        }

    }
}