package com.example.dct.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextViewMedium : AppCompatTextView {
    constructor(context: Context) : super(context) {
        setFont()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setFont()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        setFont()
    }

    private fun setFont() {
        val typeface = Typeface.createFromAsset(context.assets, "fonts/Poppins-Medium.ttf")
        setTypeface(typeface)
    }
}




