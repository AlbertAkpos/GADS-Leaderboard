package me.alberto.gadsleaderboard.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.app_bar_main.view.*
import me.alberto.gadsleaderboard.R
import me.alberto.gadsleaderboard.activity.HostActivity
import me.alberto.gadsleaderboard.databinding.FragmentHostBinding


class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)

        initViews()
        setupActionbar()

        return binding.root
    }


    private fun setupActionbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.hostToolbar.toolbar)
    }

    private fun initViews() {
        val fragmentAdapter = FragmentAdapter(requireActivity())
        viewPager = binding.fragmentViewpager
        viewPager.adapter = fragmentAdapter
        tabLayout = binding.tabLayout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabWithViewPager()
    }

    private fun setTabWithViewPager() {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.learning_leaders)
                else -> getString(R.string.skill_leaders)
            }
        }.attach()
    }


}