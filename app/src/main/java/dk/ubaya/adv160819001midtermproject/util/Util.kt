package dk.ubaya.adv160819001midtermproject.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dk.ubaya.adv160819001midtermproject.R
import java.lang.Exception

fun ImageView.loadImage(url:String, progressBar: ProgressBar?=null){
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar?.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })
}