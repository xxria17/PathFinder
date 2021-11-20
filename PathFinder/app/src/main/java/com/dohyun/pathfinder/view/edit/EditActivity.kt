package com.dohyun.pathfinder.view.edit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.databinding.ActivityEditBinding
import com.dohyun.pathfinder.view.base.BaseActivity
import com.dohyun.pathfinder.view.utils.ItemMoveCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditActivity : BaseActivity<ActivityEditBinding>(R.layout.activity_edit) {

    private val viewModel by viewModels<EditViewModel>()
    private val adapter = EditAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireDataBinding().editBackBtn.setOnClickListener {
            showToast("편집이 취소되었습니다.")
            finish()
        }

        requireDataBinding().editList.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        requireDataBinding().editList.layoutManager = LinearLayoutManager(this)
        requireDataBinding().editList.adapter = adapter
        val callback = ItemMoveCallback(adapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(requireDataBinding().editList)

        with(viewModel) {
            getLists()

            result.observe(this@EditActivity) {
                adapter.updateLists(it)
            }
        }

        requireDataBinding().editSaveBtn.setOnClickListener {
            viewModel.saveChanges(adapter.list)
        }

    }
}