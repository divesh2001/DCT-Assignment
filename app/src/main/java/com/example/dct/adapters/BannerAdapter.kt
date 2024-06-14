package com.example.dct.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dct.R
import com.example.dct.activities.MovieDetailsActivity
import com.example.dct.rest.Movie
import com.example.dct.utils.AnimUtils

class BannerAdapter(
    private val context: Context,
    private val movies: List<Movie>, private val onClick: (Movie) -> Unit
) :
    RecyclerView.Adapter<BannerAdapter.MovieViewHolder>() {

    private val imageArr = arrayOf(
        R.drawable.dummy_movie_01,
        R.drawable.dummy_movie_02,
        R.drawable.dummy_movie_03,
        R.drawable.dummy_movie_04
    )

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val relSelectBannerImage: RelativeLayout = view.findViewById(R.id.relSelectBannerImage)
        val ivBackgroundImage: ImageView = view.findViewById(R.id.ivBackgroundImage)
        val ivForegroundImage: ImageView = view.findViewById(R.id.ivForegroundImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_banner_image, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageArr.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        /* val movie = movies[position]
         val posterUrl = "https://image.tmdb.org/t/p/w500/${movie.poster_path}"
         Glide.with(context).load(posterUrl).into(holder.ivForegroundImage)
         Glide.with(context).load(posterUrl).into(holder.ivBackgroundImage)*/

        holder.ivForegroundImage.setImageResource(imageArr[position])
        holder.ivBackgroundImage.setImageResource(imageArr[position])

        holder.relSelectBannerImage.setOnClickListener { /*onClick(movie)*/

            context.startActivity(Intent(context, MovieDetailsActivity::class.java))
            AnimUtils.enterTransition(context)
        }
    }
}