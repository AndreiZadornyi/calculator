package com.example.calculator.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.R
import com.example.calculator.models.ResultItem
import kotlinx.android.synthetic.main.item_result.view.*

class ItemListAdapter internal constructor() :
    RecyclerView.Adapter<ItemListAdapter.ViewHolderRecycleView>() {
    private var items = emptyList<ResultItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemListAdapter.ViewHolderRecycleView {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ViewHolderRecycleView(itemView)
    }

    override fun onBindViewHolder(holder: ItemListAdapter.ViewHolderRecycleView, position: Int) {
        val currentItem = items[position]

        if (currentItem.result != "") {
            holder.tv_result.text = currentItem.result
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(_items: List<ResultItem>) {
        items = _items
        notifyDataSetChanged()
    }

    inner class ViewHolderRecycleView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_result: TextView = itemView.tv_result

    }
}
