package com.sd.lib.section_view.ext.group.section

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.utils.LibUtils

open class GridItemSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        view.apply {
            val padding = LibUtils.dp2px(context, 5f)
            this.setPadding(padding, padding, padding, padding)
        }
        textView?.apply {
            this.textSize = 14f
            this.minHeight = LibUtils.dp2px(view.context, 35f)
            this.gravity = Gravity.CENTER
            this.layoutParams.let { params ->
                if (params is FrameLayout.LayoutParams) {
                    params.gravity = Gravity.CENTER
                }
            }
        }
    }

    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        super.onUpdateBrightness(view, brightness)
        when (brightness) {
            Brightness.Light -> {
                textView?.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                }
            }
            Brightness.Dark -> {
                textView?.apply {
                    this.setBackgroundColor(Color.parseColor("#2A2A2A"))
                }
            }
        }
    }
}