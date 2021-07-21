package com.sd.lib.section_view.section.text

import android.view.View
import android.widget.TextView
import com.sd.lib.section_view.R
import com.sd.lib.section_view.model.ITextModel
import com.sd.lib.section_view.section.BaseSection

open class TextSection : BaseSection {
    private val _data: Any

    var textView: TextView? = null
        private set

    constructor(data: Any) : super() {
        this._data = data
    }

    override fun getLayoutId(): Int {
        return R.layout.lib_section_view_view_text_section
    }

    override fun initSectionView(view: View) {
        textView = view.findViewById(R.id.tv_text)
    }

    override fun bindSectionData() {
        val text = if (_data is ITextModel) _data.getDisplayText() else _data.toString()
        textView?.text = text
    }
}