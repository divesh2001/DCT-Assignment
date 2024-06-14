package com.example.dct.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import com.example.dct.R

object AnimUtils {
    fun enterTransition(ctx: Context) {
        if (Build.VERSION.SDK_INT >= 34) {
            (ctx as Activity).overrideActivityTransition(Activity.OVERRIDE_TRANSITION_OPEN , R.anim.fade_in, R.anim.fade_out)
        } else {
            (ctx as? Activity)?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out,)
        }
    }

    fun exitTransition(ctx: Context) {
        if (Build.VERSION.SDK_INT >= 34) {
            (ctx as Activity).overrideActivityTransition(Activity.OVERRIDE_TRANSITION_CLOSE , R.anim.fade_in, R.anim.fade_out)
        } else {
            (ctx as? Activity)?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out,)
        }
    }
}