package com.jer.ch2_ch3.ch3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        val value = arguments?.getString("text_from_edit")
//        val tvResult: TextView = view.findViewById(R.id.tv_result)
        binding.tvResult.text = value
        super.onViewCreated(view, savedInstanceState)

//        val tvResultNav: TextView = view.findViewById(R.id.tv_result_from_nav)

        val name = Fragment2Args.fromBundle(arguments as Bundle).someText

        binding.tvResultFromNav.text = name
    }


}