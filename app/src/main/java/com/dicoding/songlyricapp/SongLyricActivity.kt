package com.dicoding.songlyricapp

import android.content.Intent
import android.icu.text.CaseMap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class SongLyricActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val KEY_SONG = "key_song"
    }

    lateinit var dataSong : Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_lyric)
        dataSong = intent.getParcelableExtra<Song>(KEY_SONG) as Song

        findViewById<TextView>(R.id.title).text = dataSong.title
        findViewById<TextView>(R.id.lyric).text = dataSong.lyric
        findViewById<TextView>(R.id.album).text = dataSong.album
        findViewById<ImageView>(R.id.thumbnail).setImageResource(dataSong.thumbnail)

        val favoriteBtn = findViewById(R.id.favorite) as ImageView
        favoriteBtn.setOnClickListener(this)

        val shareBtn = findViewById(R.id.share_btn) as ImageView
        shareBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.favorite -> {
                Toast.makeText(this,"Added to Lovelist!", Toast.LENGTH_SHORT).show()
            }

            R.id.share_btn -> {
                val tweet = "Now playing:"
                val song = dataSong.title.toString()
                val tweetUrl = ("https://twitter.com/intent/tweet?text=$tweet&url="
                        + "\"$song\" by Sasha Sloan")
                val uri: Uri = Uri.parse(tweetUrl)
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
    }

}