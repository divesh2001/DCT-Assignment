package com.example.dct.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dct.adapters.BannerAdapter
import com.example.dct.databinding.ActivityMovieBannerBinding
import com.example.dct.mvvm.MovieViewModel

class MovieBannerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBannerBinding

    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: BannerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        adapter = BannerAdapter(this, emptyList()) { movie ->
            val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                putExtra("movie_id", movie.id)
                putExtra("movie_title", movie.title)
                putExtra("movie_poster", movie.poster_path)
            }
            startActivity(intent)
        }

        binding.rvBanner.layoutManager = GridLayoutManager(this, 2)
        binding.rvBanner.adapter = adapter

        viewModel.movies.observe(this) { movies ->
            adapter = BannerAdapter(this, movies) { movie ->
                val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                    putExtra("movie_id", movie.id)
                    putExtra("movie_title", movie.title)
                    putExtra("movie_poster", movie.poster_path)
                }
                startActivity(intent)
            }
            binding.rvBanner.adapter = adapter
        }


    }
}