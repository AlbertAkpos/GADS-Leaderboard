package me.alberto.gadsleaderboard.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.alberto.gadsleaderboard.screens.learningleader.LearnLeaderFragment

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = LearnLeaderFragment()
        fragment.arguments = Bundle().apply {
            putInt(FRAG_TYPE, position + 1)
        }
        return fragment
    }

    companion object {
        const val FRAG_TYPE = "FRAG_TYPE"
        const val CATEGORY = "fragment_category"
    }
}