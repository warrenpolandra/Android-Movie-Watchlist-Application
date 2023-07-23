package com.dicoding.tvserieswatchlist

 import android.content.Intent
 import android.os.Bundle
 import android.os.Handler
 import androidx.appcompat.app.AppCompatActivity
 import com.dicoding.tvserieswatchlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Splash screen here
        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}