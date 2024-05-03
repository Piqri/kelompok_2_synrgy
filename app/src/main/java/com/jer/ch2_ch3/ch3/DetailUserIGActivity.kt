package com.jer.ch2_ch3.ch3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.ActivityDetailUserIgactivityBinding

class DetailUserIGActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserIgactivityBinding
    private val viewModel: JustViewModel = JustViewModel()
//    private lateinit var musician :  Musician
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserIgactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = Intent()
        username.getStringExtra("username")


    //        val allmusician = AllMusician()
//        musician.username = allmusician.toString()
//        musician.photoProfil = allmusician.toString()

//        binding.tvNameDetail.text = musician.username
//        Glide.with(this)
//            .load(musician.photoProfil)
//            .into(binding.ivUserDetail)

    binding.btnIg.setOnClickListener{
//            val url  = "https://www.instagram.com/${musician.username}"
        val url = "https://www.instagram.com/jeraa__"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)

    }

    binding.btnMoveToNav.setOnClickListener {
        val intent = Intent(this@DetailUserIGActivity, ActivityForNavigation::class.java)
        startActivity(intent)
    }

        binding.btnToFrag.setOnClickListener {
//            val moveToFrag = Intent(this@DetailUserIGActivity, UserFragment::class.java)
//            startActivity(moveToFrag)
            val fragmentManager = supportFragmentManager
            viewModel.funcToFragment(fragmentManager)


        }

    }

}