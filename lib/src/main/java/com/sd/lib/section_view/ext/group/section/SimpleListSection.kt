package com.sd.lib.section_view.ext.group.section

import com.sd.lib.section_view.section.TextSection
import com.sd.lib.section_view.section.list.ListTextSection

open class SimpleListSection : ListTextSection {
    constructor() : super(1)

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Any) {
        super.onBindViewHolder(holder, position, model)
        holder.itemView.setOnClickListener {
            onClickItem(model)
        }
    }

    protected open fun onClickItem(model: Any) {
    }

    override fun createTextSection(spanCount: Int): TextSection {
        return ListItemSection()
    }
}