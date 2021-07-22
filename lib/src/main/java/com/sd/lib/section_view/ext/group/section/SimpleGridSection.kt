package com.sd.lib.section_view.ext.group.section

import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.section.list.ListTextSection

open class SimpleGridSection : ListTextSection {
    constructor(spanCount: Int) : super(spanCount)

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Any) {
        super.onBindViewHolder(holder, position, model)
        holder.section.textView?.setOnClickListener {
            onClickItem(model)
        }
    }

    protected open fun onClickItem(model: Any) {
    }

    override fun createTextSection(spanCount: Int): TextSection {
        return SimpleGridItemSection()
    }
}