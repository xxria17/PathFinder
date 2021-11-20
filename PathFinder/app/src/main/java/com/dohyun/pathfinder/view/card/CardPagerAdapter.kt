package com.dohyun.pathfinder.view.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.data.model.Cards

class CardPagerAdapter : RecyclerView.Adapter<CardPagerAdapter.PagerViewHolder>() {
    private val list = mutableListOf<Cards>()

    inner class PagerViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        private val img: ImageView = view!!.findViewById(R.id.card_img)
        private val text: TextView = view!!.findViewById(R.id.card_text)

        fun bind(card: Cards) {
            if (card.text == null) {
                text.visibility = View.GONE
                Glide.with(itemView.context)
                        .load(card.image_url)
                        .into(img)
            } else {
                text.text = card.text
                img.visibility = View.GONE
            }
        }

    }

    fun updateList(cards: List<Cards>) {
        this.list.clear()
        this.list.addAll(cards)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): CardPagerAdapter.PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_cardview, parent, false)

        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardPagerAdapter.PagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}