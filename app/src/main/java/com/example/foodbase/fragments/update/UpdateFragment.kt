package com.example.foodbase.fragments.update


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.foodbase.R
import com.example.foodbase.databinding.DialogUpdateBinding
import com.example.foodbase.databinding.FragmentListBinding
//import com.example.foodbase.databinding.FragmentUpdateBinding
//import com.example.foodbase.fragments.add.AddFragmentDirections
import com.example.foodbase.model.Item
import com.example.foodbase.viewmodel.ItemViewModel
import androidx.appcompat.app.AppCompatActivity

//class UpdateFragment : DialogFragment() {
//
//    private var mView: View? = null
//    private lateinit var binding: DialogUpdateBinding
////    private lateinit var binding: FragmentUpdateBinding
//
//    private val itemViewModel: ItemViewModel by viewModels()
//
//    private val itemId: Int by lazy { requireArguments().getInt("itemId") }
//
//        override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = DialogUpdateBinding.inflate(inflater, container, false)
//
////        view.nameTextViewRV.text = arguments?.getString("title")
////        binding.nameEditText.text =  arguments?.getString("itemId")
//        itemViewModel.getItem(itemId).observe(viewLifecycleOwner, this::displayItem)
//        return binding.root
//
////        var rootView: View = inflater.inflate(R.layout.dialog_update, container, false)
////
////        return rootView
//    }
//
//
////    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
////        return activity?.let {
////            // either this way we can init dialogBinding
////            binding = DialogUpdateBinding.setContentView(it, R.layout.dialog_update)
////            AlertDialog.Builder(it).apply { setView(mView) }.create()
////        } ?: throw IllegalStateException("Activity cannot be null")
////    }
//
////    val context = this.context
////    lateinit var context: getContext
////
////
//
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////
////        itemViewModel.getItem(itemId).observe(viewLifecycleOwner, this::displayItem)
//////
////        binding.updateButton.setOnClickListener { updateItem() }
//
////        binding.cancelButton.setOnClickListener { dialog?.dismiss() }
//    }
//
//
//    private fun displayItem(item: Item) {
////        binding.nameEditText.setText(item.name)
////        binding.quantityEditText.setText(item.quantity.toString())
//        val context = this.context
//        val dialog = context?.let { Dialog(it) }
//        val dialogBinding = DialogUpdateBinding.inflate(LayoutInflater.from(context))
//        dialog?.apply {
//            setCancelable(false)
//            setContentView(dialogBinding.root)
//        }
//
//        dialogBinding.apply {
//            nameEditText.setText(item.name)
//            quantityEditText.setText(item.quantity.toString())
//            updateButton.setOnClickListener {
//                updateItem()
//                if (dialog != null) {
//                    dialog.dismiss()
//                }
//            }
//
//            deleteButton.setOnClickListener {
//                if (dialog != null) {
//                    deleteItem()
//                    dialog.dismiss()
//                }
//            }
//            cancelButton.setOnClickListener {
//                if (dialog != null) {
//                    dialog.dismiss()
//                }
//            }
//        }
//        if (dialog != null) {
//            dialog.show()
//        }
//    }
//
//    private fun updateItem() {
//        val name = binding.nameEditText.text.toString()
//        val quantity = binding.quantityEditText.text.toString()
//
//        if (name.isNotEmpty() && quantity.isNotEmpty()) {
//            val item = Item(id, name, quantity.toInt())
//            itemViewModel.updateItem(item)
//            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
////            dialog.dismiss()
//        }
//    }
//
//    private fun deleteItem() {
//        val name = binding.nameEditText.text.toString()
//        val quantity = binding.quantityEditText.text.toString()
//
//            val item = Item(id, name, quantity.toInt())
//            itemViewModel.deleteItem(item)
//            findNavController().navigate(UpdateFragmentDirections.actionUpdateFragmentToListFragment())
////            dialog.dismiss()
//
//    }
//
//}


class UpdateFragment : Fragment() {

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