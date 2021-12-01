package org.com.testing.with.jetbrainsdemo

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageToFetchUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUrl = imageUrl.toUri().buildUpon().scheme("https").build()
        Picasso.get()
            .load(imageUrl)
            .into(imageView)
    }
}