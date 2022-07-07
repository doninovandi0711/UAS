package com.doni.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_tvshow.*

class DetailTVShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var tvshowes: TVShow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvshow)

        tvshowes = intent.getParcelableExtra(EXTRA_DATA)
        tv_title.text = tvshowes?.name
        tv_overview.text = tvshowes?.overview
        Glide.with(img_poster).load(Constant.IMAGE_BASE + tvshowes!!.poster).into(img_poster)
    }
}