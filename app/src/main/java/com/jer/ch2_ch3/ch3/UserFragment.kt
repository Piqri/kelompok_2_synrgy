package com.jer.ch2_ch3.ch3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.jer.ch2_ch3.R


class UserFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val edtUser: EditText = view.findViewById(R.id.edt_frag1)
        val btnUser: Button = view.findViewById(R.id.btn_user_frag1)
        edtUser.text.toString()



        btnUser.setOnClickListener {
            val fragment2 = Fragment2()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container_ig, fragment2, Fragment2::class.java.simpleName)
                addToBackStack(null)
                commit()
            }

            val bundle = Bundle()
            bundle.putString("text_from_edit", edtUser.text.toString())
            fragment2.arguments = bundle


        }


        super.onViewCreated(view, savedInstanceState)

    }


}