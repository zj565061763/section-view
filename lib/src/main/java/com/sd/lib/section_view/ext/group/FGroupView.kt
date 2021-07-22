package com.sd.lib.section_view.ext.group

import android.content.Context
import android.util.AttributeSet
import com.sd.lib.section_view.FSectionView
import com.sd.lib.section_view.ext.group.section.HeadTextSection

class FGroupView : FSectionView {
    private val _mapGroup = mutableMapOf<String, InternalGroup>()

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {

    }

    /**
     * 获取某个组
     */
    fun getGroup(name: String): Group {
        var group = _mapGroup.get(name)
        if (group == null) {
            group = InternalGroup().apply {
                val section = HeadTextSection().apply {
                    this.bindData(name)
                }
                this.head.setSection(section)
            }
            _mapGroup.put(name, group)
        }
        return group
    }

    /**
     * 滚动到某个组
     */
    fun scrollToGroup(name: String) {
        val group = _mapGroup.get(name) ?: return
        scrollToSection(group.head.getSection())
    }

    /**
     * 创建组View
     */
    fun build() {
        removeAllSection()
        _mapGroup.values.forEach { group ->
            group.head.getSection()?.let { section ->
                addSection(section, sticky = true)
            }
            group.body.getSection()?.let { section ->
                addSection(section)
            }
        }
    }

    private class InternalGroup : Group {
        override val head: GroupItem by lazy { InternalGroupItem() }
        override val body: GroupItem by lazy { InternalGroupItem() }
    }

    private class InternalGroupItem : GroupItem {
        var _section: Section<*>? = null

        override fun getSection(): Section<*>? {
            return _section
        }

        override fun setSection(section: Section<*>) {
            _section = section
        }
    }

    interface Group {
        val head: GroupItem
        val body: GroupItem
    }

    interface GroupItem {
        fun getSection(): Section<*>?
        fun setSection(section: Section<*>)
    }
}