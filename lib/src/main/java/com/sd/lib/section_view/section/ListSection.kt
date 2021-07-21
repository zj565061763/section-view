package com.sd.lib.section_view.section

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.R
import com.sd.lib.section_view.section.BaseSection

abstract class ListSection : BaseSection() {
    var recyclerView: RecyclerView? = null

    override fun initSectionView(view: View) {
        recyclerView = view.findViewById(R.id.rv_item)
    }
}