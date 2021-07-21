package com.sd.lib.section_view.ext.group.section

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.section.ListSection

class SimpleListSection : ListSection<List<Any>>() {

    override fun onBindData(view: View, data: List<Any>) {
        TODO("Not yet implemented")
    }

    private val _adapter = object : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }

    private class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View) : super(itemView) {

        }
    }
}