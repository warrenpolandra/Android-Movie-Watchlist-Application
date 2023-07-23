package com.dicoding.tvserieswatchlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.tvserieswatchlist.databinding.ItemDetailsBinding

class ItemDetails : AppCompatActivity(){


    private lateinit var binding: ItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val series = intent.getParcelableExtra<Series>("series")
        if(series != null){
            binding.itemDetailName.text = series.name
            binding.itemDetailYear.text = series.year.toString()
            binding.itemDetailSeriesGenre.text = series.genre
            binding.itemDetailSynopsis.text = series.detail
            binding.itemDetailPhoto.setImageResource(series.photo)
            binding.itemDetailSeriesRating.text = series.rating
            binding.btnLike.setOnClickListener{
                Toast.makeText(binding.btnLike.context, series.name + " Liked", Toast.LENGTH_SHORT).show()
            }
            binding.btnShare.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing series:\n" + series.link)
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Share to:"))
            }
        }

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}

