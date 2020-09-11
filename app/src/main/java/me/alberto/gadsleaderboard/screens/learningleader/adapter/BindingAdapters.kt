package me.alberto.gadsleaderboard.screens.learningleader.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.alberto.gadsleaderboard.app.data.model.Leader

@BindingAdapter("app:imageSrc")
fun ImageView.loadImageFromUrl(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}

@BindingAdapter("app:leadersList")
fun RecyclerView.loadLeaders(list: List<Leader>?) {
    val adapter = adapter as LeadersAdapter
    adapter.submitList(list)
}