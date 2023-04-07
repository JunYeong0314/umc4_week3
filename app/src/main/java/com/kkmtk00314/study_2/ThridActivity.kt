package com.kkmtk00314.study_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.kkmtk00314.study_2.databinding.ActivityThirdBinding
import com.kkmtk00314.study_2.databinding.FragmentFirstBinding

class ThridActivity : AppCompatActivity(), DataListener {
    private lateinit var viewBinding:ActivityThirdBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityThirdBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

        viewBinding.btn3Fragment1.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btn3Fragment2.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }

        supportFragmentManager.beginTransaction()
            .add(viewBinding.frameFragment.id, FirstFragment())
            .commit()
    }
    override fun onDataReceived(data: String) {
        // Fragment로부터 전달된 데이터 처리
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}