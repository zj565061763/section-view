package com.sd.lib.section_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout
import com.sd.lib.section_view.model.Brightness

open class FSectionView : FrameLayout {
    private val _scrollView by lazy { ConsecutiveScrollerLayout(context) }
    private val _mapSection = mutableMapOf<Section<*>, View>()

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        addView(_scrollView)
    }

    /**
     * 明亮度
     */
    var brightness = Brightness.Light
        set(value) {
            if (field != value) {
                field = value
                updateBrightness()
            }
        }

    /**
     * 切换明亮度
     */
    fun toggleBrightness() {
        brightness = if (brightness == Brightness.Light) {
            Brightness.Dark
        } else {
            Brightness.Light
        }
    }

    /**
     * 添加段
     */
    @JvmOverloads
    fun addSection(section: Section<*>, sticky: Boolean = false) {
        if (_mapSection.containsKey(section)) return

        val newParams = ConsecutiveScrollerLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        newParams.isSticky = sticky

        val view = section.getSectionView(context)
        section.setBrightness(brightness)

        view.layoutParams?.let {
            newParams.width = it.width
            newParams.height = it.height
        }

        _scrollView.addView(view, newParams)
        _mapSection.put(section, view)
    }

    /**
     * 滚动到某个段
     */
    fun scrollToSection(section: Section<*>?) {
        if (section == null) return
        val view = _mapSection.get(section) ?: return
        _scrollView.scrollToChild(view)
    }

    /**
     * 移除段
     */
    fun removeSection(section: Section<*>?) {
        if (section == null) return
        val view = _mapSection.remove(section) ?: return
        _scrollView.removeView(view)
    }

    /**
     * 移除所有段
     */
    open fun removeAllSection() {
        _mapSection.clear()
        _scrollView.removeAllViews()
    }

    /**
     * 更新明亮度
     */
    private fun updateBrightness() {
        val brightness = brightness
        _mapSection.keys.forEach {
            it.setBrightness(brightness)
        }
    }

    interface Section<T> {
        fun getSectionView(context: Context): View

        fun setBrightness(brightness: Brightness)

        fun bindData(data: T)
    }
}