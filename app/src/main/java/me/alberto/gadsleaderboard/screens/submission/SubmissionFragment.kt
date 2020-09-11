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
import me.alberto.gadsleaderboard.app.util.extension.hideKeyboard
import me.alberto.gadsleaderboard.databinding.FragmentSubmissionBinding
import me.alberto.gadsleaderboard.screens.dialog.ConfirmDialog
import me.alberto.gadsleaderboard.screens.dialog.ConfirmDialog.ConfirmListener
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
        setupClickListeners()
        return binding.root
    }

    private fun setupClickListeners() {
        binding.submitBtn.setOnClickListener {
            it.hideKeyboard()
            val verify = viewModel.verify()
            if (verify) {
                showConfirmDialog()
            }
        }
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setupObservers() {
        viewModel.success.observe(viewLifecycleOwner, Observer { submitStatus ->
            submitStatus ?: return@Observer
            //show dialog based on submitSuccess value
            showSuccessStatusDialog(
                submitStatus,
                if (submitStatus) getString(R.string.submission_success)
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

    private fun showConfirmDialog() {
        val confirmDialog = ConfirmDialog.newInstance(object : ConfirmListener {
            override fun onConfirm() {
                viewModel.submitProject()
            }
        })
        confirmDialog.show(requireActivity().supportFragmentManager, confirmDialog.javaClass.name)
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