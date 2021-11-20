package com.dohyun.pathfinder.view.edit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dohyun.pathfinder.R
import com.dohyun.pathfinder.data.model.Cards
import com.dohyun.pathfinder.view.utils.ItemTouchHelperListener
import java.util.*

class EditAdapter : RecyclerView.Adapter<EditAdapter.ViewHolder>(), ItemTouchHelperListener {
    val list = mutableListOf<Cards>()

    inner class ViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        private val content : TextView = view!!.findViewById(R.id.item_name)
        fun bind(cards: Cards) {
            if (cards.text == null) content.text = cards.image_url
            else content.text = cards.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_edit, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EditAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateLists(cards: List<Cards>) {
        this.list.clear()
        this.list.addAll(cards)
        notifyDataSetChanged()
    }

    override fun onItemMove(fromPos: Int, targetPos: Int) {
        if (fromPos < targetPos) {
            for (i in fromPos until targetPos) {
                Collections.swap(list, i, i+1)
            }
        } else {
            for (i in fromPos downTo targetPos + 1) {
                Collections.swap(list, i, i - 1)
            }
        }
        notifyItemMoved(fromPos, targetPos)
    }

    override fun onItemDismiss(pos: Int) {

    }
}