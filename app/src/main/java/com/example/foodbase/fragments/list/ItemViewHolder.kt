package com.example.foodbase.fragments.list

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbase.databinding.ItemRecycleviewBinding
import com.example.foodbase.fragments.update.UpdateFragment
import com.example.foodbase.model.Item
import java.security.AccessController.getContext


class ItemViewHolder(private val binding: ItemRecycleviewBinding) : RecyclerView.ViewHolder(binding.root) {

    //    val supportFragmentManager = getActivity().getSupportFragmentManager();
//    var fragmentManager: FragmentManager = (itemView.context as Activity).fragmentManager
    var fragmentManager = (itemView.context as FragmentActivity).supportFragmentManager

    fun bind(item: Item) {
        binding.nameTextViewRV.text = item.name
        binding.quantityTextViewRV.text = item.quantity.toString()

        binding.root.setOnClickListener {

            val action: NavDirections = ListFragmentDirections
                .actionListFragmentToUpdateFragment(item.id)
            findNavController(binding.root).navigate(action)

            val dialog = UpdateFragment()

            val bundle = Bundle()
            bundle.putString("itemId", item.id.toString())
            dialog.arguments = bundle

            dialog.show(fragmentManager, "dialog")
//            setupDialog(item)

        }
    }
}