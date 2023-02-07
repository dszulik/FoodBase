package com.example.foodbase.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.foodbase.model.Item
import com.example.foodbase.databinding.ItemRecycleviewBinding

class ItemAdapter(itemComparator: ItemComparator) : ListAdapter<Item, ItemViewHolder>(itemComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRecycleviewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    public fun getItemAt(position: Int): Item{
        return getItem(position)
    }
}