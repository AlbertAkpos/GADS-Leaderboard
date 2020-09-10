package me.alberto.gadsleaderboard.screens.submission

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.alberto.gadsleaderboard.LeaderApp
import me.alberto.gadsleaderboard.R
import me.alberto.gadsleaderboard.databinding.FragmentSubmissionBinding
import me.alberto.gadsleaderboard.screens.dialog.ProgressDialog
import me.alberto.gadsleaderboard.screens.dialog.SuccessStatusDialog
import javax.inject.Inject

class SubmissionFragment : Fragment() {

    private lateinit var binding: FragmentSubmissionBinding
    private lateinit var toolbar: Toolbar
    private lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SubmissionViewModel> { viewModelFactory }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LeaderApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubmissionBinding.inflate(inflater, container, false)
        setupActionbar()
        bindViewModel()
        setupObservers()
        return binding.root
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setupObservers() {
        viewModel.success.observe(viewLifecycleOwner, Observer { submitSuccess ->
            submitSuccess ?: return@Observer
            //show dialog based on submitSuccess value
            showSuccessStatusDialog(
                submitSuccess,
                if (submitSuccess) getString(R.string.submission_success)
                else
                    getString(R.string.submission_failure)
            )

        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { showLoading ->
            showLoading ?: return@Observer
            if (showLoading) {
                showProgressDialog()
            } else {
                hideProgressDialogue()
            }

        })
    }


    private fun setupActionbar() {
        toolbar = binding.submissionToolbar.subToolbar
        toolbar.setNavigationIcon(R.drawable.ic_left_arrow)
        toolbar.setNavigationOnClickListener { activity?.onBackPressed() }
    }

    private fun showProgressDialog() {
        progressDialog = ProgressDialog.newInstance()
        progressDialog.show(requireActivity().supportFragmentManager, progressDialog.javaClass.name)
    }

    private fun hideProgressDialogue() {
        if (::progressDialog.isInitialized) progressDialog.dismiss()
    }

    private fun showSuccessStatusDialog(success: Boolean, message: String) {
        val dialog = SuccessStatusDialog.newInstance(success, message)
        dialog.show(requireActivity().supportFragmentManager, dialog.javaClass.name)
    }
}