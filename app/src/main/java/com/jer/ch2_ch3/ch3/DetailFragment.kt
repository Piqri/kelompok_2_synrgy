package com.jer.ch2_ch3.ch3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {


    private var _binding: FragmentDetailBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var musician: Musician
    private val viewModel: JustViewModel = JustViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val username = Intent()
//        username.getStringExtra("username")
//
//        binding.tvNameDetail.text = musician.username

        binding.btnIg.setOnClickListener{
//            val url  = "https://www.instagram.com/${musician.username}"
            val url = "https://www.instagram.com/jeraa__"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)

        }


        binding.btnMoveToNav.setOnClickListener {
//            val intent = Intent(context, Fragment1Nav::class.java)
//            startActivity(intent)
            val fragmentManager = parentFragmentManager
            val userFrag = Fragment1Nav()
            fragmentManager.beginTransaction().apply {
                replace(R.id.frame_container_ig, userFrag)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnToFrag.setOnClickListener {
//            val moveToFrag = Intent(context, UserFragment::class.java)
//            startActivity(moveToFrag)


            val fragmentManager = parentFragmentManager
            viewModel.funcToFragment(fragmentManager)




        }

    }





}