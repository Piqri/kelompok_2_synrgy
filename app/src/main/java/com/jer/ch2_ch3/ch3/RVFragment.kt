package com.jer.ch2_ch3.ch3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.FragmentRVBinding


class RVFragment : Fragment() {


    private lateinit var binding: FragmentRVBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRVBinding.inflate(layoutInflater, container, false)
        return binding.root
//        return inflater.inflate(R.layout.fragment_r_v, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.recyclerView.addItemDecoration(itemDecoration)

        val allMusician = AllMusician()
        val igAdapter = IgAdapter(requireContext())
        igAdapter.submitList(allMusician)
        binding.recyclerView.adapter = igAdapter

//        val fragmentManager = parentFragmentManager
//        val detailFragment = DetailFragment()
//
//        fragmentManager
//            .beginTransaction()
//            .add(
//                R.id.frame_container_ig,
//                detailFragment
////                    DetailFragment::class.java.simpleName
//            )
//            .addToBackStack(null)
//            .commit()

        super.onViewCreated(view, savedInstanceState)
    }
}