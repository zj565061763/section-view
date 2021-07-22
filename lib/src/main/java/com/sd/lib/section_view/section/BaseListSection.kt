package com.sd.lib.section_view.section

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.R

abstract class BaseListSection<T> : BaseSection<T>() {
    var recyclerView: RecyclerView? = null

    override fun getLayoutId(): Int {
        return R.layout.lib_section_view_view_list_section
    }

    override fun initSectionView(view: View) {
        recyclerView = view.findViewById(R.id.rv_item)
    }
}