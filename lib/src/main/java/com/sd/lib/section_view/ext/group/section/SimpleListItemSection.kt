package com.sd.lib.section_view.ext.group.section

import android.graphics.Color
import android.view.View
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.utils.LibUtils

class SimpleListItemSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        textView?.apply {
            this.minHeight = LibUtils.dp2px(view.context, 50f)
        }
        bottomDivider?.visibility = View.VISIBLE
    }

    override fun onUpdateBrightness(brightness: Brightness) {
        super.onUpdateBrightness(brightness)
        when (brightness) {
            Brightness.Light -> {
                textView?.apply {
                    this.setBackgroundColor(Color.WHITE)
                    this.setTextColor(Color.parseColor("#666666"))
                }
                bottomDivider?.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                }
            }
            Brightness.Dark -> {
                textView?.apply {
                    this.setBackgroundColor(Color.BLACK)
                    this.setTextColor(Color.WHITE)
                }
                bottomDivider?.apply {
                    this.setBackgroundColor(Color.parseColor("#CCCCCC"))
                }
            }
        }
    }
}