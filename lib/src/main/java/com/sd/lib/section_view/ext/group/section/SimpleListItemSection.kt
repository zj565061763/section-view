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
            this.textSize = 14f
            this.minHeight = LibUtils.dp2px(view.context, 50f)
            val padding = LibUtils.dp2px(context, 20f)
            this.setPadding(padding, 0, padding, 0)
            this.visibility = View.VISIBLE
        }
        bottomDivider?.apply {
            this.visibility = View.VISIBLE
        }
    }

    override fun onUpdateBrightness(brightness: Brightness) {
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