package com.jer.ch2_ch3.ch3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jer.ch2_ch3.databinding.ItemViewIgBinding

class IgAdapter(private val context: Context): ListAdapter<Musician, IgAdapter.IgViewHolder>(DIFF_CALLBACK) {

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


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailUserIGActivity::class.java )
            intent.putExtra("username", user.username)
            context.startActivity(intent)
            Toast.makeText(context, "Kamu memilih ${user.username}", Toast.LENGTH_SHORT).show()
        }
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