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
                    val margin = LibUtils.dp2px(view.context, 5f)
                    params.gravity = Gravity.CENTER
                    params.leftMargin = margin
                    params.rightMargin = margin
                    params.topMargin = margin
                    params.bottomMargin = margin
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