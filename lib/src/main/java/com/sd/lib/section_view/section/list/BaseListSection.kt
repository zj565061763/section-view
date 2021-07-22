package com.sd.lib.section_view.section.list

import android.graphics.Color
import android.view.View
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.R
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.model.IBrightnessReceiver
import com.sd.lib.section_view.section.BaseSection

abstract class BaseListSection<T> : BaseSection<T> {
    val spanCount: Int
    var recyclerView: RecyclerView? = null

    constructor(spanCount: Int) : super() {
        require(spanCount >= 1)
        this.spanCount = spanCount
    }

    override fun getLayoutId(): Int {
        return R.layout.lib_section_view_view_list_section
    }

    @CallSuper
    override fun initSectionView(view: View) {
        recyclerView = view.findViewById(R.id.rv_item)
        recyclerView?.apply {
            if (spanCount == 1) {
                this.layoutManager = LinearLayoutManager(view.context)
            } else {
                this.layoutManager = GridLayoutManager(view.context, spanCount)
            }
        }
    }

    @CallSuper
    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        super.onUpdateBrightness(view, brightness)
        when (brightness) {
            Brightness.Light -> {
                view.apply {
                    this.setBackgroundColor(Color.WHITE)
                }
            }
            Brightness.Dark -> {
                view.apply {
                    this.setBackgroundColor(Color.BLACK)
                }
            }
        }
        recyclerView?.adapter?.let { adapter ->
            if (adapter is IBrightnessReceiver) {
                adapter.setBrightness(brightness)
            }
        }
    }

    @CallSuper
    override fun onBindData(view: View, data: T) {
        recyclerView?.adapter = createAdapter(data)
    }

    protected abstract fun createAdapter(data: T): RecyclerView.Adapter<*>
}