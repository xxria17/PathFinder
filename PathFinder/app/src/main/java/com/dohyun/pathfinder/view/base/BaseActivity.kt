package com.dohyun.pathfinder.view.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import java.lang.IllegalStateException

abstract class BaseActivity<B: ViewDataBinding>(
    @LayoutRes val layoutId: Int
) : AppCompatActivity() {
    private var _binding: B? = null
    protected val binding: B?
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        _binding?.lifecycleOwner = this
    }

    protected fun requireDataBinding(): B{
        if (_binding == null) {
            throw IllegalStateException(
                "BaseActivity $this did not return a Binding from onCreate"
            )
        }
        return _binding!!
    }

    protected fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}