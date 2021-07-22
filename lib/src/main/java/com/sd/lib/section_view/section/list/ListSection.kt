package com.sd.lib.section_view.section.list

import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.model.IBrightnessReceiver
import java.util.*

abstract class ListSection<VH : RecyclerView.ViewHolder> : BaseListSection<List<Any>> {
    private val _mapViewHolder = WeakHashMap<RecyclerView.ViewHolder, String>()

    constructor(spanCount: Int) : super(spanCount) {
    }

    @CallSuper
    override fun onUpdateBrightness(view: View, brightness: Brightness) {
        super.onUpdateBrightness(view, brightness)
        _mapViewHolder.keys.forEach { viewHolder ->
            if (viewHolder is IBrightnessReceiver) {
                viewHolder.setBrightness(brightness)
            }
        }
    }

    @CallSuper
    override fun onBindData(view: View, data: List<Any>) {
        _mapViewHolder.clear()
        super.onBindData(view, data)
    }

    final override fun createAdapter(data: List<Any>): RecyclerView.Adapter<VH> {
        return object : RecyclerView.Adapter<VH>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
                val viewHolder = this@ListSection.onCreateViewHolder(parent, viewType)
                if (viewHolder is IBrightnessReceiver) {
                    viewHolder.setBrightness(getBrightness())
                }
                return viewHolder.also {
                    _mapViewHolder.put(it, "")
                }
            }

            override fun onBindViewHolder(holder: VH, position: Int) {
                val model = data.getOrNull(position)
                if (model != null) {
                    this@ListSection.onBindViewHolder(holder, position, model)
                }
            }

            override fun getItemCount(): Int {
                return data.size
            }
        }
    }

    /**
     * 创建ViewHolder
     */
    protected abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    /**
     * 绑定数据
     */
    protected abstract fun onBindViewHolder(holder: VH, position: Int, model: Any)
}