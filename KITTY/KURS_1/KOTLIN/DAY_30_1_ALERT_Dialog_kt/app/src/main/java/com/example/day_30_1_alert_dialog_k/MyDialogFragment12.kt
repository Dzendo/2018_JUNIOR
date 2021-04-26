package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.widget.ImageView
import com.bumptech.glide.Glide


// AlertDialog с собственной разметкой
class MyDialogFragment12(private val url: String) : DialogFragment() {
    //private val url = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val image = ImageView(activity)

         Glide.with(requireActivity())
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .override(1280, 960)
            .into(image)

        val builder: AlertDialog = AlertDialog.Builder(requireActivity())
            .setView(image).create()


       /* val builder = android.app.AlertDialog.Builder(activity)
        builder.setMessage(" миллион коту?")
            .setIcon(R.drawable.ic_pets_black_24dp)
            .setTitle("Важно! Максимальный перепост")
            .setPositiveButton("OK") { dialog, id -> (activity as MainActivity).okClicked() }
            .setNegativeButton("Отмена") { dialog, id -> (activity as MainActivity).cancelClicked() }
        */
        return builder
    }
}
