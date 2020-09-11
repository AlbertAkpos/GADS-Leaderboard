package me.alberto.gadsleaderboard.screens.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.alberto.gadsleaderboard.R
import me.alberto.gadsleaderboard.databinding.SubmitDialogLayoutBinding

class SuccessStatusDialog : DialogFragment() {
    private val success by lazy {
        requireArguments().getBoolean(SUCCESS_STATUS)
    }

    private val message by lazy {
        requireArguments().getString(MESSAGE)
    }

    private lateinit var binding: SubmitDialogLayoutBinding

    companion object {

        private const val SUCCESS_STATUS = "success_status"
        private const val MESSAGE = "message"

        fun newInstance(success: Boolean, message: String): SuccessStatusDialog {
            val bundle = Bundle()
            bundle.putString(MESSAGE, message)
            bundle.putBoolean(SUCCESS_STATUS, success)
            val dialogFragment = SuccessStatusDialog()
            dialogFragment.arguments = bundle
            return dialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = SubmitDialogLayoutBinding.inflate(layoutInflater)
        val dialog = MaterialAlertDialogBuilder(requireContext())
        setupViews()
        dialog.setView(binding.root)
        return dialog.create()
    }

    private fun setupViews() {
        binding.message.text = message
        success?.let {
            if (it) {
                binding.successStatus.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_tick)
                )
            } else {
                binding.successStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_warning
                    )
                )
            }
        }
    }

}