package com.sd.lib.section_view.section

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.sd.lib.section_view.FSectionView
import com.sd.lib.section_view.model.Brightness

abstract class BaseSection : FSectionView.Section {
    private var _rootView: View? = null
    private var _brightness: Brightness? = null

    final override fun getSectionView(context: Context): View {
        val rootView = _rootView
        if (rootView != null) return rootView

        val layoutId = getLayoutId()
        return LayoutInflater.from(context).inflate(layoutId, null).also {
            _rootView = it
            initSectionView(it)
            notifyBrightness()
        }
    }

    final override fun setBrightness(brightness: Brightness) {
        _brightness = brightness
        notifyBrightness()
    }

    private fun notifyBrightness() {
        if (_rootView == null) return
        val brightness = _brightness ?: return
        updateBrightness(brightness)
    }

    /**
     * 返回布局ID
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化View
     */
    protected abstract fun initSectionView(view: View)

    /**
     * 更新明亮度
     */
    protected open fun updateBrightness(brightness: Brightness) {}
}