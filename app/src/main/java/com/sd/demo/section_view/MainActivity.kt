package com.sd.demo.section_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.section_view.databinding.ActivityMainBinding
import com.sd.lib.section_view.section.text.TextSection

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.viewGroup.getGroup("A").apply {
            this.getBody().setSection(TextSection("body"))
        }
        _binding.viewGroup.build()
    }
}