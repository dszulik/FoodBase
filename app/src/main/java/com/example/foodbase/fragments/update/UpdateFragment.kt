package com.example.foodbase.fragments.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodbase.databinding.DialogUpdateBinding
import com.example.foodbase.model.Item
import com.example.foodbase.viewmodel.ItemViewModel

class UpdateFragment : DialogFragment() {

    private lateinit var binding: DialogUpdateBinding

    private val itemViewModel: ItemViewModel by viewModels()

    private val itemId: Int by lazy { requireArguments().getInt("itemId") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemViewModel.getItem(itemId).observe(viewLifecycleOwner, this::displayItem)

        binding.updateButton.setOnClickListener { updateItem() }

        binding.deleteButton.setOnClickListener { deleteItem() }

        binding.cancelButton.setOnClickListener {  findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment()) }
    }

    private fun displayItem(item: Item){
        binding.nameEditText.setText(item.name)
        binding.quantityEditText.setText(item.quantity.toString())
    }

    private fun updateItem() {
        val name = binding.nameEditText.text.toString()
        val quantity = binding.quantityEditText.text.toString()

        if (name.isNotEmpty() && quantity.isNotEmpty()){
            val item = Item(itemId, name, quantity.toInt())
            itemViewModel.updateItem(item)
            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
        } else{
            binding.nameEditText.error = "Podaj nazwę"
            binding.quantityEditText.error = "Podaj ilość"
        }
    }

    private fun deleteItem() {
        val name = binding.nameEditText.text.toString()
        val quantity = binding.quantityEditText.text.toString()

        if (name.isNotEmpty() && quantity.isNotEmpty()){
            val item = Item(itemId, name, quantity.toInt())
            itemViewModel.deleteItem(item)
            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
        }
    }
}