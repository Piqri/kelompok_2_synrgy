package com.jer.ch2_ch3.ch3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.ActivityInstagramBinding

class InstagramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstagramBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstagramBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.layoutManager = layoutManager
//        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
//        binding.recyclerView.addItemDecoration(itemDecoration)

//        val allMusician = AllMusician()
//        val igAdapter = IgAdapter(this)
//        igAdapter.submitList(allMusician)
//        binding.recyclerView.adapter = igAdapter
//
        setMoveToDetail()


    }

    fun setMoveToDetail(){
        val fragmentManager = supportFragmentManager
        val iniFragment = RVFragment()
        val fragment = fragmentManager.findFragmentByTag(DetailFragment::class.java.simpleName)

        if (fragment !is DetailFragment) {
            Log.d("MyFlexibleFragment", "Fragment name: " + DetailFragment::class.java.simpleName)

            fragmentManager
                .beginTransaction()
                .add(
                    R.id.frame_container_ig,
                    iniFragment
//                    DetailFragment::class.java.simpleName
                )
                .addToBackStack(null)
                .commit()
        }
    }
//    fun setAdapter(user: >) {
//        val igAdapter = IgAdapter(this)
//        igAdapter.submitList(user)
//        binding.recyclerView.adapter = igAdapter
//    }
}