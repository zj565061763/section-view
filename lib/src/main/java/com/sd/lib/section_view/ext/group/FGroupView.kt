package com.sd.lib.section_view.ext.group

import android.content.Context
import android.util.AttributeSet
import com.sd.lib.section_view.FSectionView
import com.sd.lib.section_view.section.TextSection

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
                this.getHead().setSection(TextSection(name))
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
        scrollToSection(group.getHead().getSection())
    }

    /**
     * 创建组View
     */
    fun build() {
        removeAllSection()
        _mapGroup.forEach { entry ->
            entry.value.getHead().getSection()?.let { section ->
                addSection(section)
            }
            entry.value.getBody().getSection()?.let { section ->
                addSection(section)
            }
        }
    }

    private class InternalGroup : Group {
        private val _head by lazy { InternalGroupItem() }
        private val _body by lazy { InternalGroupItem() }

        override fun getHead(): GroupItem {
            return _head
        }

        override fun getBody(): GroupItem {
            return _body
        }
    }

    private class InternalGroupItem : GroupItem {
        var _section: Section? = null

        override fun getSection(): Section? {
            return _section
        }

        override fun setSection(section: Section) {
            _section = section
        }
    }

    interface Group {
        fun getHead(): GroupItem

        fun getBody(): GroupItem
    }

    interface GroupItem {
        fun getSection(): Section?

        fun setSection(section: Section)
    }
}