package com.sd.lib.sectionv.ext.group.section

import com.sd.lib.sectionv.section.TextSection
import com.sd.lib.sectionv.section.list.ListTextSection

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