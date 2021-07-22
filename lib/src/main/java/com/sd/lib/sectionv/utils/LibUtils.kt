package com.sd.lib.sectionv.utils

import android.content.Context

internal object LibUtils {
    fun dp2px(context: Context, dp: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}