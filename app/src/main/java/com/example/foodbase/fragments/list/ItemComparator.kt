package com.example.foodbase.fragments.list

import androidx.recyclerview.widget.DiffUtil
import com.example.foodbase.model.Item

class ItemComparator : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name && oldItem.quantity == newItem.quantity
    }
}