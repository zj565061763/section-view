package com.sd.lib.sectionv.ext.group.section

import android.graphics.Color
import android.view.View
import com.sd.lib.sectionv.model.Brightness
import com.sd.lib.sectionv.section.TextSection
import com.sd.lib.sectionv.utils.LibUtils

open class HeadTextSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        view.apply {
            this.minimumHeight = LibUtils.dp2px(view.context, 30f)
            val padding = LibUtils.dp2px(context, 5f)
            this.setPadding(padding, 0, 0, 0)
        }
        textView?.apply {
            this.textSize = 16f
        }
    }

    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        when (brightness) {
            Brightness.Light -> {
                view.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                }
                textView?.apply {
                    this.setTextColor(Color.BLACK)
                }
            }
            Brightness.Dark -> {
                view.apply {
                    this.setBackgroundColor(Color.parseColor("#2A2A2A"))
                }
                textView?.apply {
                    this.setTextColor(Color.WHITE)
                }
            }
        }
    }
}