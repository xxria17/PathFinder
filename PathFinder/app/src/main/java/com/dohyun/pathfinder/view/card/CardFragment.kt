package com.dohyun.pathfinder.view.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.databinding.FragmentCardBinding
import com.dohyun.pathfinder.view.base.BaseFragment

class CardFragment : BaseFragment<FragmentCardBinding>(R.layout.fragment_card) {

    private val viewModel by activityViewModels<CardViewModel>()
    private val adapter = CardPagerAdapter()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCardBinding {
        return FragmentCardBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun init() {
        // requireDataBinding().cardViewPager.adapter = adapter
        viewModel.getData()

        viewModel.result.observe(viewLifecycleOwner){
            adapter.updateList(it)
        }
    }

}