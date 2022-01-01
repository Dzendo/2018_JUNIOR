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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.day_30_1_alert_dialog_k.databinding.FragmentUrlBinding
import com.squareup.picasso.Picasso
import android.graphics.drawable.Drawable

import com.bumptech.glide.RequestBuilder




// AlertDialog с собственной разметкой
class MyDialogFragment10 : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val binding = FragmentUrlBinding.inflate(layoutInflater)

       val previewUrl = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=96&h=72"
        val url = "https://d2zkmv5t5kao9.cloudfront.net/images/b905a618b56c721ce683164259ac02c4.jpeg?w=640&h=480"
        // setup Glide request without the into() method
        // Подготовка Превью если есть
        val thumbnailRequest: RequestBuilder<Drawable> = Glide
            .with(requireActivity())
            .load(previewUrl)

// pass the request as a a parameter to the thumbnail request
        Glide
            .with(requireActivity())
            .load(url)
           // .thumbnail(thumbnailRequest)  // для превью
            .override(1280, 960)
            .into(binding.imageChair)

       /* Glide.with(requireActivity())
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            //.resize(1280, 960 )
            //.apply( RequestOptions().override(1280, 960))
            .override(1280, 960)
            //.thumbnail(previewUrl)
            .into(binding.imageChair)
        */
        builder.setView(binding.root)
        return builder.create()
    }
}
