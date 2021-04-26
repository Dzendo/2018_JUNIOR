package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.day_30_1_alert_dialog_k.databinding.FragmentUrl11BindingImpl

// AlertDialog с собственной разметкой
class MyDialogFragment11 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val binding = FragmentUrl11BindingImpl.inflate(layoutInflater)

        builder.setView(binding.root)
        return builder.create()
    }
}
