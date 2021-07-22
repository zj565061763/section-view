package com.sd.lib.sectionv.ext.group.section

import android.graphics.Color
import android.view.View
import com.sd.lib.sectionv.model.Brightness
import com.sd.lib.sectionv.section.TextSection
import com.sd.lib.sectionv.utils.LibUtils

open class ListItemSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        view.apply {
            this.minimumHeight = LibUtils.dp2px(view.context, 45f)
            val padding = LibUtils.dp2px(context, 20f)
            this.setPadding(padding, 0, 0, 0)
        }
        textView?.apply {
            this.textSize = 14f
        }
    }

    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        super.onUpdateBrightness(view, brightness)
        when (brightness) {
            Brightness.Light -> {
                bottomDivider?.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                }
            }
            Brightness.Dark -> {
                bottomDivider?.apply {
                    this.setBackgroundColor(Color.parseColor("#2A2A2A"))
                }
            }
        }
    }
}