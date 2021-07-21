package com.sd.lib.section_view.ext.group.section

import android.graphics.Color
import android.view.View
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.utils.LibUtils

open class HeadTextSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        textView?.apply {
            this.textSize = 16f
            this.minHeight = LibUtils.dp2px(view.context, 30f)
            val padding = LibUtils.dp2px(context, 10f)
            this.setPadding(padding, 0, padding, 0)
        }
    }

    override fun onUpdateBrightness(brightness: Brightness) {
        when (brightness) {
            Brightness.Light -> {
                textView?.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                    this.setTextColor(Color.BLACK)
                }
            }
            Brightness.Dark -> {
                textView?.apply {
                    this.setBackgroundColor(Color.parseColor("#2A2A2A"))
                    this.setTextColor(Color.WHITE)
                }
            }
        }
    }
}