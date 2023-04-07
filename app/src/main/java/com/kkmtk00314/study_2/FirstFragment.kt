package com.kkmtk00314.study_2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kkmtk00314.study_2.databinding.FragmentFirstBinding

class FirstFragment: Fragment() {
    private lateinit var viewBinding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)
        return viewBinding.root
    }
    private var dataListener: DataListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataListener = context as DataListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.fragment1Btn.setOnClickListener {
            dataListener?.onDataReceived("Hello, Activity")
        }
    }

    override fun onDetach() {
        super.onDetach()
        dataListener = null
    }
}

