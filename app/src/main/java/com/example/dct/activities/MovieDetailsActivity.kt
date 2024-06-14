package com.example.dct.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dct.R
import com.example.dct.databinding.ActivityMovieDetailsBinding
import com.example.dct.utils.AnimUtils

class MovieDetailsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener(this)
        binding.relPlayMovie.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ivBack -> {
                onBackPressedDispatcher.onBackPressed()
                AnimUtils.enterTransition(this)
            }

            R.id.relPlayMovie -> {
                startActivity(Intent(this, MoviePlayerActivity::class.java))
                AnimUtils.enterTransition(this)
            }
        }
    }
}