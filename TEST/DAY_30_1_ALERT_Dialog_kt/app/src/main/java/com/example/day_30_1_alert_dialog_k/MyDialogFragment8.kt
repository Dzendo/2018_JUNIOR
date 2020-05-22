package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
// AlertDialog с собственной разметкой
class MyDialogFragment8 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        val inflater = activity!!.layoutInflater
        val view = inflater.inflate(R.layout.fragment_custom, null)
        builder.setView(view)
        // Остальной код
        return builder.create()
    }
}
