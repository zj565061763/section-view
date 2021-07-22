package com.sd.lib.section_view.ext.group.section

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sd.lib.section_view.model.Brightness
import com.sd.lib.section_view.section.BaseListSection
import com.sd.lib.section_view.section.TextSection
import java.util.*

open class SimpleListSection : BaseListSection<List<Any>> {
    private val _spanCount: Int
    private val _mapViewHolder = WeakHashMap<ViewHolder, String>()

    @JvmOverloads
    constructor(spanCount: Int = 1) : super() {
        _spanCount = spanCount
    }

    override fun initSectionView(view: View) {
        super.initSectionView(view)
        recyclerView?.apply {
            if (_spanCount == 1) {
                this.layoutManager = LinearLayoutManager(view.context)
            } else {
                this.layoutManager = GridLayoutManager(view.context, _spanCount)
            }
        }
    }

    override fun onUpdateBrightness(view: View, brightness: Brightness) {
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
        _mapViewHolder.keys.forEach { viewHolder ->
            viewHolder.section.setBrightness(brightness)
        }
    }

    override fun onBindData(view: View, data: List<Any>) {
        _mapViewHolder.clear()
        recyclerView?.adapter = createAdapter(data)
    }

    private fun createAdapter(data: List<Any>): RecyclerView.Adapter<*> {
        return object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val section = createTextSection(_spanCount)
                section.setBrightness(getBrightness())
                val itemView = section.getSectionView(parent.context)
                return ViewHolder(itemView, section).also {
                    _mapViewHolder.put(it, "")
                }
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val model = data.getOrNull(position)
                if (model != null) {
                    holder.section.bindData(model)

                    if (_spanCount == 1) {
                        holder.itemView.setOnClickListener {
                            onClickItem(model)
                        }
                    } else {
                        holder.section.textView?.setOnClickListener {
                            onClickItem(model)
                        }
                    }
                }
            }

            override fun getItemCount(): Int {
                return data.size
            }
        }
    }

    protected open fun createTextSection(spanCount: Int): TextSection {
        return if (spanCount == 1) {
            SimpleListItemSection()
        } else {
            SimpleGirdItemSection()
        }
    }

    protected open fun onClickItem(model: Any) {}

    private class ViewHolder : RecyclerView.ViewHolder {
        val section: TextSection

        constructor(itemView: View, section: TextSection) : super(itemView) {
            this.section = section
        }
    }
}