package me.alberto.gadsleaderboard.screens.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.alberto.gadsleaderboard.databinding.ProgressLayoutBinding

class ProgressDialog : DialogFragment() {

    private lateinit var binding: ProgressLayoutBinding

    companion object {
        fun newInstance() = ProgressDialog()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = ProgressLayoutBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(binding.root)
        return builder.create()
    }

}