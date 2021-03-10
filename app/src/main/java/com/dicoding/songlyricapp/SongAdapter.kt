package com.dicoding.songlyricapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class SongAdapter(private val listSong: ArrayList<Song>) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = listSong[position]

        Glide.with(holder.itemView.context)
            .load(song.thumbnail)
            .transform(CenterCrop(),RoundedCorners(20))
            .into(holder.imgThumbnail)

        holder.tvAlbum.text = song.album
        holder.tvTitle.text = song.title
        holder.tvRatingScore.text = song.rating.toString()
        holder.rbRatingBar.rating = song.rating.toFloat()
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgThumbnail: ImageView = itemView.findViewById(R.id.thumbnail)
        var tvTitle: TextView = itemView.findViewById(R.id.title)
        var tvAlbum: TextView = itemView.findViewById(R.id.album)
        var tvRatingScore: TextView = itemView.findViewById(R.id.rating_score)
        var rbRatingBar: RatingBar = itemView.findViewById(R.id.rating_bar)
    }
}