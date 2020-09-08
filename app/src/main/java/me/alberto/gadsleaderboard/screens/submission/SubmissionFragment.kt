package me.alberto.gadsleaderboard.screens.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import me.alberto.gadsleaderboard.R
import me.alberto.gadsleaderboard.databinding.FragmentSubmissionBinding

class SubmissionFragment : Fragment() {

    private lateinit var binding: FragmentSubmissionBinding
    private lateinit var toolbar: Toolbar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSubmissionBinding.inflate(inflater, container, false)
        setupActionbar()
        return binding.root
    }


    private fun setupActionbar() {
        toolbar = binding.submissionToolbar.subToolbar
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow)
        toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
    }
}