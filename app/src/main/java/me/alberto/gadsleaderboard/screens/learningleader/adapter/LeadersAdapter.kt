package me.alberto.gadsleaderboard.screens.learningleader.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.alberto.gadsleaderboard.app.data.model.Leader
import me.alberto.gadsleaderboard.databinding.LeaderItemBinding

class LeadersAdapter :
    ListAdapter<Leader, RecyclerView.ViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuItemHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MenuItemHolder) holder.bind(getItem(position))
    }

    class MenuItemHolder(private val binding: LeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            leader: Leader
        ) {
            binding.leader = leader
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val view =
                    LeaderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MenuItemHolder(view)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Leader>() {
        override fun areItemsTheSame(oldItem: Leader, newItem: Leader): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Leader, newItem: Leader): Boolean {
            return oldItem == newItem
        }
    }


}