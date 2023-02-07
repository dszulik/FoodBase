package com.example.foodbase.fragments.list

import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbase.databinding.ItemRecycleviewBinding
import com.example.foodbase.model.Item

class ItemViewHolder(private val binding: ItemRecycleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.nameTextViewRV.text = item.name
        binding.quantityTextViewRV.text = item.quantity.toString()

        binding.root.setOnClickListener {
            val action: NavDirections = ListFragmentDirections
                .actionListFragmentToUpdateFragment(item.id.toInt())
            findNavController(binding.root).navigate(action)

        }
    }
}
