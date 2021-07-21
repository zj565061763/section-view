package com.sd.demo.section_view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.section_view.databinding.ActivityMainBinding
import com.sd.lib.section_view.section.TextSection

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.viewGroup.getGroup("A").apply {
            this.getBody().setSection(TextSection().apply {
                this.bindData("body")
            })
        }
        _binding.viewGroup.build()
    }

    override fun onClick(v: View?) {
        when (v) {
            _binding.btnBrightness -> _binding.viewGroup.toggleBrightness()
        }
    }
}