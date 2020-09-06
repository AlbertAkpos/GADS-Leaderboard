package me.alberto.gadsleaderboard.screens.learningleader

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.alberto.gadsleaderboard.LeaderApp
import me.alberto.gadsleaderboard.app.extension.viewModel
import me.alberto.gadsleaderboard.databinding.FragmentLearnLeaderBinding
import me.alberto.gadsleaderboard.fragment.FragmentAdapter
import me.alberto.gadsleaderboard.screens.learningleader.adapter.LeadersAdapter
import javax.inject.Inject


class LearnLeaderFragment : Fragment() {

    private val leaderType by lazy {
        requireArguments().getInt(FragmentAdapter.FRAG_TYPE)
    }

    private lateinit var binding: FragmentLearnLeaderBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory


    private lateinit var viewModel: LeaderViewModel

    override fun onAttach(context: Context) {
        (activity?.application as LeaderApp).appComponent.inject(this)
        super.onAttach(context)
        viewModel = viewModel(factory) {}
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLearnLeaderBinding.inflate(inflater, container, false)
        bindViewModel()
        getLeaderList()
        return binding.root
    }

    private fun bindViewModel() {
        binding.recyclerView.adapter = LeadersAdapter()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun getLeaderList() {
        viewModel.getLeaderList(leaderType)
    }


}