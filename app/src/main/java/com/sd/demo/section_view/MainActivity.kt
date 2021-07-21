package com.sd.demo.section_view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.section_view.databinding.ActivityMainBinding
import com.sd.lib.section_view.ext.group.section.SimpleListSection

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val list = mutableListOf<String>()
        repeat(100) {
            list.add(it.toString())
        }

        _binding.viewGroup.getGroup("AAA").apply {
            val section = object : SimpleListSection(spanCount = 3) {
                override fun onClickItem(model: Any) {
                    Toast.makeText(this@MainActivity, "click ${model}", Toast.LENGTH_SHORT).show()
                }
            }
            section.bindData(mutableListOf("aaa", "bbb", "ccc"))
            this.getBody().setSection(section)
        }

        _binding.viewGroup.getGroup("A").apply {
            val section = object : SimpleListSection() {
                override fun onClickItem(model: Any) {
                    Toast.makeText(this@MainActivity, "click ${model}", Toast.LENGTH_SHORT).show()
                }
            }
            section.bindData(list)
            this.getBody().setSection(section)
        }

        _binding.viewGroup.getGroup("B").apply {
            val section = object : SimpleListSection() {
                override fun onClickItem(model: Any) {
                    Toast.makeText(this@MainActivity, "click ${model}", Toast.LENGTH_SHORT).show()
                }
            }
            section.bindData(list)
            this.getBody().setSection(section)
        }

        _binding.viewGroup.build()
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnBrightness -> _binding.viewGroup.toggleBrightness()
            _binding.btnGroupA -> _binding.viewGroup.scrollToGroup("A")
            _binding.btnGroupB -> _binding.viewGroup.scrollToGroup("B")
        }
    }
}