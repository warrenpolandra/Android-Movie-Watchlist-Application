package com.dicoding.tvserieswatchlist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.tvserieswatchlist.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var rvSeries: RecyclerView
    private var list: ArrayList<Series> = arrayListOf()

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvSeries = findViewById(R.id.rv_series)
        rvSeries.setHasFixedSize(true)

        list.addAll(getListSeries())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListSeries(): ArrayList<Series>{
        val dataName = resources.getStringArray(R.array.seriesNames)
        val dataYear = resources.getIntArray(R.array.seriesYear)
        val dataGenre = resources.getStringArray(R.array.seriesGenre)
        val dataDetails = resources.getStringArray(R.array.seriesDetails)
        val dataImage = resources.obtainTypedArray(R.array.seriesImages)
        val dataRating = resources.getStringArray(R.array.seriesRating)
        val dataLink = resources.getStringArray(R.array.seriesLink)
        val listSeries = ArrayList<Series>()
        for(i in dataName.indices){
            val series = Series(dataName[i], dataYear[i], dataGenre[i], dataDetails[i], dataImage.getResourceId(i, -1), dataRating[i], dataLink[i])
            listSeries.add(series)
        }
        return listSeries
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this@ListActivity, About::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList(){
        rvSeries.layoutManager = LinearLayoutManager(this)
        val listSeriesAdapter = ListSeriesAdapter(list)
        rvSeries.adapter = listSeriesAdapter

        listSeriesAdapter.onItemClick = {
            val intent = Intent(this, ItemDetails::class.java)
            intent.putExtra("series", it)
            startActivity(intent)
        }
    }
}