package me.alberto.gadsleaderboard.screens.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.alberto.gadsleaderboard.databinding.ConfirmSubmissionLayoutBinding

class ConfirmDialog : DialogFragment() {

    private var listener: ConfirmListener? = null

    private lateinit var binding: ConfirmSubmissionLayoutBinding

    companion object {
        fun newInstance(listener: ConfirmListener): ConfirmDialog {
            val fragment = ConfirmDialog()
            fragment.listener = listener
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ConfirmSubmissionLayoutBinding.inflate(layoutInflater)
        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(binding.root)
        binding.close.setOnClickListener { dismiss() }
        binding.confirmSubmit.setOnClickListener {
            listener?.onConfirm()
            dismiss()
        }

        return builder.create()
    }


    interface ConfirmListener {
        fun onConfirm()
    }

}