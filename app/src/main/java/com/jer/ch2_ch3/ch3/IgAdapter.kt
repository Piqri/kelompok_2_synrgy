package com.jer.ch2_ch3.ch3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jer.ch2_ch3.R
import com.jer.ch2_ch3.databinding.ItemViewIgBinding

class IgAdapter(private val context: Context): ListAdapter<Musician, IgAdapter.IgViewHolder>(DIFF_CALLBACK) {


    private lateinit var  fragmentManager: FragmentManager
    class IgViewHolder(val binding: ItemViewIgBinding): RecyclerView.ViewHolder(binding.root) {
        val allMusician = AllMusician()
        fun bind(user: Musician) {
            binding.tvUsername.text = user.username

            Glide.with(itemView.context)
                .load(user.photoProfil)
                .into(binding.ivPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IgViewHolder {
        val binding = ItemViewIgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root
        return IgViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IgViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)


        holder.itemView.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {

                val activity = v!!.context as AppCompatActivity
                val detailFragment = DetailFragment()
                val intent = Intent(context, DetailFragment::class.java )
                intent.putExtra("username", user.username)

                activity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container_ig, detailFragment)
                    .addToBackStack(null)
                    .commit()

                Toast.makeText(context, "Kamu memilih ${user.username}", Toast.LENGTH_SHORT).show()

            }
//            val intent = Intent(context, DetailUserIGActivity::class.java )


//            val detailFragment = DetailFragment()
//            fragmentManager
//                .beginTransaction()
//                .replace(R.id.frame_container_ig, detailFragment)
//                .addToBackStack(null)
//                .commit()


        })
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Musician>() {
            override fun areItemsTheSame(oldItem: Musician, newItem: Musician): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Musician, newItem: Musician): Boolean {
                return oldItem == newItem
            }

        }
    }

}