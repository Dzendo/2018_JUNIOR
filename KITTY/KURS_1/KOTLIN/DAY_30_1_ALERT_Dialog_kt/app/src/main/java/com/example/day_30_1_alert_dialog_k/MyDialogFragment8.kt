package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.os.Bundle

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.day_30_1_alert_dialog_k.databinding.FragmentCustomBinding

// AlertDialog с собственной разметкой
class MyDialogFragment8 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val view = FragmentCustomBinding.inflate(layoutInflater)
        builder.setView(view.root)
        // Остальной код
        return builder.create()
    }
}
