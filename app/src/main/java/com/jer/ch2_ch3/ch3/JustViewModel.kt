package com.jer.ch2_ch3.ch3

import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.jer.ch2_ch3.R

class JustViewModel: ViewModel() {

    fun funcToFragment(fragManager: FragmentManager) {
        val fragmentManager = fragManager
        val instFragmentDetailUser = UserFragment()
        val fragment = fragmentManager.findFragmentByTag(UserFragment::class.java.simpleName)

        if (fragment !is UserFragment) {
            Log.d("MyFlexibleFragment", "Fragment name: " + UserFragment::class.java.simpleName)

            fragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_container_ig,
                    instFragmentDetailUser,
                    UserFragment::class.java.simpleName
                )
                .addToBackStack(null)
                .commit()
        }
    }
}