package com.sd.lib.section_view.ext.group.section

import android.view.View
import com.sd.lib.section_view.section.TextSection

open class HeadTextSection : TextSection() {
    override fun initSectionView(view: View) {
        super.initSectionView(view)
        textView?.apply {
            this.textSize = 16f
        }
    }
}