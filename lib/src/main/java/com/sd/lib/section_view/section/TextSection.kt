package com.sd.lib.section_view.section

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.annotation.CallSuper
import com.sd.lib.section_view.R
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.model.ITextModel

open class TextSection : BaseSection<Any>() {
    var textView: TextView? = null
        private set

    var bottomDivider: View? = null
        private set

    override fun getLayoutId(): Int {
        return R.layout.lib_section_view_view_text_section
    }

    @CallSuper
    override fun initSectionView(view: View) {
        textView = view.findViewById(R.id.tv_text)
        bottomDivider = view.findViewById(R.id.bottom_divider)
    }

    override fun onUpdateBrightness(brightness: Brightness) {
        super.onUpdateBrightness(brightness)
        when (brightness) {
            Brightness.Light -> {
                textView?.apply {
                    this.setBackgroundColor(Color.WHITE)
                    this.setTextColor(Color.parseColor("#666666"))
                }
            }
            Brightness.Dark -> {
                textView?.apply {
                    this.setBackgroundColor(Color.BLACK)
                    this.setTextColor(Color.WHITE)
                }
            }
        }
    }

    override fun onBindData(view: View, data: Any) {
        val text = if (data is ITextModel) data.getDisplayText() else data.toString()
        textView?.text = text
    }
}