package com.dicoding.tvserieswatchlist

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.tvserieswatchlist.databinding.AboutMainBinding

class About : AppCompatActivity() {

    private lateinit var binding: AboutMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDevLinkedin.movementMethod = LinkMovementMethod.getInstance()
        binding.tvDevGithub.movementMethod = LinkMovementMethod.getInstance()
        binding.tvDevInstagram.movementMethod = LinkMovementMethod.getInstance()

        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        binding.tvDevEmail.setOnClickListener {
            val clipdata: ClipData = ClipData.newPlainText("label", binding.tvDevEmail.text)
            clipboardManager.setPrimaryClip(clipdata)
        }

        val actionBar = supportActionBar
        actionBar?.title = "About Developer"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
