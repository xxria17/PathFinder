package com.dohyun.pathfinder.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.databinding.ActivityMainBinding
import com.dohyun.pathfinder.view.base.BaseActivity
import com.dohyun.pathfinder.view.edit.EditActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getDataFromUrl()

        requireDataBinding().mainEditBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}