package com.example.dct.activities

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.DefaultTimeBar
import com.example.dct.R
import com.example.dct.databinding.ActivityMoviePlayerBinding
import com.example.dct.utils.AnimUtils


class MoviePlayerActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var exoPlayer: ExoPlayer
    private lateinit var binding: ActivityMoviePlayerBinding
    private lateinit var timeBar: DefaultTimeBar
    private var isControllerVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //binding.relControllerView.visibility = View.GONE
        binding.relControllerView.setOnClickListener(this)

        initializePlayer()
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        binding.playerView.player = exoPlayer

        val videoUrl =
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        val mediaItem = MediaItem.fromUri(videoUrl)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()


    }

    override fun onStop() {
        super.onStop()
        exoPlayer.release()
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.relControllerView -> {
                // isControllerVisible()
            }
        }

    }

    private fun isControllerVisible() {

        if (isControllerVisible) {
            //Handler(Looper.getMainLooper()).postDelayed({
            binding.relControllerView.visibility = View.GONE
            isControllerVisible = false
            //   }, 500)
        } else {
            binding.relControllerView.visibility = View.GONE
            isControllerVisible = true
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        AnimUtils.exitTransition(this)
    }
}