package com.shaadi.exercise.core.extension

import android.view.View
import android.view.ViewStub
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Suyash Chavan.
 */
fun ViewStub?.ifNotInflated(inflate: () -> Unit, elseDo: () -> Unit) {
    this?. let { inflate.invoke() } ?: run { elseDo.invoke() }
}

fun View.loadFromUrl(url: String?, isCircular: Boolean = false) {
    if (isCircular) {
        Glide.with(this.context.applicationContext)
            .load(url)
            .apply(RequestOptions().transform(CircleCrop()))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this as ImageView)
    } else {
        Glide.with(this.context.applicationContext)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this as ImageView)
    }
}