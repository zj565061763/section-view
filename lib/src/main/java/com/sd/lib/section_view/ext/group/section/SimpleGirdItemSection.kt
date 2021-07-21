package com.sd.lib.section_view.ext.group.section

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.utils.LibUtils

class SimpleGirdItemSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        view.apply {
            this.minimumHeight = LibUtils.dp2px(view.context, 50f)
            val padding = LibUtils.dp2px(context, 5f)
            this.setPadding(padding, padding, padding, padding)
        }
        textView?.apply {
            this.textSize = 14f
            this.layoutParams.let { params ->
                if (params is FrameLayout.LayoutParams) {
                    params.gravity = Gravity.CENTER
                }
            }
        }
    }

    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        when (brightness) {
            Brightness.Light -> {
                view.apply {
                    this.setBackgroundColor(Color.parseColor("#EEEEEE"))
                }
                textView?.apply {
                    this.setTextColor(Color.parseColor("#666666"))
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