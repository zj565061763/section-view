package com.sd.lib.section_view.ext.group.section

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.section.ListSection

class SimpleListSection : ListSection<List<Any>>() {

    override fun onBindData(view: View, data: List<Any>) {
        recyclerView?.adapter = createAdapter(data)
    }

    private fun createAdapter(data: List<Any>): RecyclerView.Adapter<*> {
        return object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val section = SimpleListItemSection()
                val itemView = section.getSectionView(parent.context)
                return ViewHolder(itemView, section)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val model = data.getOrNull(position)
                if (model != null) {
                    holder.section.bindData(model)
                }
            }

            override fun getItemCount(): Int {
                return data.size
            }
        }
    }

    private class ViewHolder : RecyclerView.ViewHolder {
        val section: SimpleListItemSection

        constructor(itemView: View, section: SimpleListItemSection) : super(itemView) {
            this.section = section
        }
    }
}