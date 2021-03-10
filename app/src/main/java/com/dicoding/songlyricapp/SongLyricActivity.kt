package com.dicoding.songlyricapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.CollapsibleActionView
import android.view.TextureView
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout

class SongLyricActivity : AppCompatActivity() {

    companion object {
        const val KEY_SONG = "key_song"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_lyric)
//        setSupportActionBar(findViewById(R.id.toolbar))

        val dataSong = intent.getParcelableExtra<Song>(KEY_SONG) as Song
//        findViewById<CollapsingToolbarLayout>()
        findViewById<TextView>(R.id.title).text = dataSong.title
        findViewById<TextView>(R.id.lyric).text = dataSong.lyric
        findViewById<TextView>(R.id.album).text = dataSong.album
        findViewById<ImageView>(R.id.thumbnail).setImageResource(dataSong.thumbnail)
    }
}