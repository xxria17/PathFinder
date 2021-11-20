package com.dohyun.pathfinder.view.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.data.model.Cards

class CardPagerAdapter : PagerAdapter() {
    private val list = mutableListOf<Cards>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.layout_cardview, container, false)

        if (list[position].text == null) {
            view.findViewById<TextView>(R.id.card_text).visibility = View.GONE
            Glide.with(container.context)
                .load(list[position].image_url)
                .into(view.findViewById<ImageView>(R.id.card_img))
        } else {
            view.findViewById<TextView>(R.id.card_text).text = list[position].text
            view.findViewById<ImageView>(R.id.card_img).visibility = View.GONE
        }

        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    fun updateList(cards: List<Cards>) {
        this.list.clear()
        this.list.addAll(cards)
        notifyDataSetChanged()
    }
}