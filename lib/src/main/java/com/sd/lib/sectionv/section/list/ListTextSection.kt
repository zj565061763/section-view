package com.sd.lib.sectionv.section.list

import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.sectionv.model.Brightness
import com.sd.lib.sectionv.model.IBrightnessReceiver
import com.sd.lib.sectionv.section.TextSection

abstract class ListTextSection : ListSection<ListTextSection.ViewHolder> {

    constructor(spanCount: Int) : super(spanCount) {
    }

    @CallSuper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val section = createTextSection(spanCount)
        val itemView = section.getSectionView(parent.context)
        return ViewHolder(itemView, section)
    }

    @CallSuper
    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Any) {
        holder.section.bindData(model)
    }

    protected abstract fun createTextSection(spanCount: Int): TextSection

    class ViewHolder : RecyclerView.ViewHolder, IBrightnessReceiver {
        val section: TextSection

        constructor(itemView: View, section: TextSection) : super(itemView) {
            this.section = section
        }

        override fun setBrightness(brightness: Brightness) {
            section.setBrightness(brightness)
        }
    }
}