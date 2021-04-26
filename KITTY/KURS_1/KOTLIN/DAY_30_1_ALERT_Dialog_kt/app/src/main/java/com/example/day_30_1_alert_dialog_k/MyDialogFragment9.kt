package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.day_30_1_alert_dialog_k.databinding.FragmentUrlBinding
import com.squareup.picasso.Picasso

// AlertDialog с собственной разметкой
class MyDialogFragment9 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val binding = FragmentUrlBinding.inflate(layoutInflater)

        val url = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
        Picasso.with(requireActivity())
            .load(url)
            .placeholder(R.drawable.ic_launcher_background) //    .user_placeholder)
            .error(R.drawable.ic_launcher_foreground) // .user_placeholder_error)
            .resize(1280, 960 )
            .into(binding.imageChair)

        builder.setView(binding.root)
        return builder.create()
    }
}
