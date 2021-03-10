package com.dicoding.songlyricapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSongs : RecyclerView
    private var list: ArrayList<Song> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSongs = findViewById(R.id.rv_songs)
        rvSongs.setHasFixedSize(true)

        list.addAll(SongsData.listData)
        initViews();
    }

    private fun initViews() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val songAdapter = SongAdapter(list)
        rvSongs.adapter = songAdapter
    }
}