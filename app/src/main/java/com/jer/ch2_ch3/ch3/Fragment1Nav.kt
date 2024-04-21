package com.jer.ch2_ch3.ch3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.FragmentFragment1NavBinding


class Fragment1Nav : Fragment() {

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var binding: FragmentFragment1NavBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragment1NavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        binding.btnToNav.setOnClickListener {

            if (binding.edtToNav.text.isNullOrEmpty()) {
                binding.edtToNav.error = "Filed ini tidak boleh kosong"
            } else {
                val toFragment2 = Fragment1NavDirections.actionFragment1NavToFragment2()
                toFragment2.someText = binding.edtToNav.text.toString()
                it.findNavController().navigate(toFragment2)
            }
//            val bundle = Bundle()
//            bundle.putString(EXTRA_NAME, "first text")
//            it.findNavController().navigate(R.id.action_fragment1Nav_to_fragment2)
        }

        super.onViewCreated(view, savedInstanceState)
    }

}