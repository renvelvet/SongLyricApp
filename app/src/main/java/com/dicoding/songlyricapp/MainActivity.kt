@file:Suppress("DEPRECATION")

package com.dicoding.songlyricapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSongs : RecyclerView
    private var list: ArrayList<Song> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Welcome to Song Lyric App!", Toast.LENGTH_SHORT).show()

        rvSongs = findViewById(R.id.rv_songs)
        rvSongs.setHasFixedSize(true)

        list.addAll(SongsData.listData)
        initViews()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        goToAbout()
        return super.onOptionsItemSelected(item)
    }

    private fun goToAbout() {
        val moveIntent = Intent(this@MainActivity, AboutAppActivity::class.java)
        startActivity(moveIntent)
    }

    private fun initViews() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val songAdapter = SongAdapter(list)
        rvSongs.adapter = songAdapter
    }
}