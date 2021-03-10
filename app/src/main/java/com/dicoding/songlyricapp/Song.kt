package com.dicoding.songlyricapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song (
    var title: String = "",
    var album: String = "",
    var lyric: String = "",
    var thumbnail: Int = 0,
    var rating: Double = 0.0
) : Parcelable