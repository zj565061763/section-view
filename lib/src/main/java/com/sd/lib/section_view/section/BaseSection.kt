package com.sd.lib.section_view.section

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sd.lib.section_view.FSectionView
import com.sd.lib.section_view.model.Brightness

abstract class BaseSection<T> : FSectionView.Section<T> {
    private var _rootView: View? = null
    private var _brightness: Brightness = Brightness.Light
    private var _data: T? = null

    final override fun getSectionView(context: Context): View {
        val rootView = _rootView
        if (rootView != null) return rootView

        return createSectionView(context).also { view ->
            _rootView = view
            initSectionView(view)
            notifyBrightness()
            notifyBindData()
        }
    }

    fun getBrightness(): Brightness {
        return _brightness
    }

    final override fun setBrightness(brightness: Brightness) {
        _brightness = brightness
        notifyBrightness()
    }

    final override fun bindData(data: T) {
        _data = data
        notifyBindData()
    }

    private fun notifyBrightness() {
        val rootView = _rootView ?: return
        onUpdateBrightness(rootView, _brightness)
    }

    private fun notifyBindData() {
        val rootView = _rootView ?: return
        val data = _data ?: return
        onBindData(rootView, data)
    }

    /**
     * 创建View
     */
    protected open fun createSectionView(context: Context): View {
        val layoutId = getLayoutId()
        return LayoutInflater.from(context).inflate(layoutId, null).apply {
            if (layoutParams == null) {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
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
     * 绑定数据
     */
    protected abstract fun onBindData(view: View, data: T)

    /**
     * 更新明亮度
     */
    protected open fun onUpdateBrightness(view: View, brightness: Brightness) {
    }
}