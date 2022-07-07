package com.doni.uas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

import kotlinx.android.synthetic.main.tvshow_item.view.*

class TVShowAdapter (
    private val tvshowes : List<TVShow>,
    val listener: OnAdapterListener
) : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>(){

    class TVShowViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTvShow(tvshow : TVShow){

            itemView.tvshow_title.text = tvshow.name
            itemView.tvshow_release_date.text = tvshow.release
            itemView.tvshow_popularity.text = tvshow.popularity

            Glide.with(itemView).load(IMAGE_BASE + tvshow.poster).into(itemView.tvshow_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        return TVShowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tvshow_item, parent, false)
        )
    }

    override fun getItemCount(): Int = tvshowes.size

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bindTvShow(tvshowes.get(position))
        holder.itemView.setOnClickListener {
            listener.onClick(tvshowes[position])
        }
    }

    interface OnAdapterListener {
        fun onClick(result: TVShow)
    }
}