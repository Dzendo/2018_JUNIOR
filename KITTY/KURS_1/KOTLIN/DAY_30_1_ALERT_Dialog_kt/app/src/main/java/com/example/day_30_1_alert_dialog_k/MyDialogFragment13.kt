package com.example.day_30_1_alert_dialog_k

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide


// AlertDialog Kotlin URI
// //d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480
class MyDialogFragment13(private val uri: String?) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val imageUri = ImageView(requireActivity())
        uri?.let {
            val imgUri = it.toUri().buildUpon().scheme("https").build()
            Glide.with(requireActivity())
                .load(imgUri)
                .override(1280, 960)
                // Добавьте простые изображения загрузки и ошибок
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(imageUri)
        }
        imageUri.setOnClickListener{ view -> dialog?.cancel() }
        val builder = AlertDialog.Builder(requireActivity())
                .setView(imageUri)
            //.setPositiveButton("OK"){ dialog, _ -> dialog.cancel() }
        return builder.create()
    }
}
