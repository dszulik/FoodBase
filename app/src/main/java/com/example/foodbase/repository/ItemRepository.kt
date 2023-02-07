package com.example.foodbase.repository

import androidx.lifecycle.LiveData
import com.example.foodbase.model.Item
import com.example.foodbase.data.ItemDao

class ItemRepository(private val itemDao: ItemDao) {
    val readAllData: LiveData<List<Item>> = itemDao.readAllData()

    suspend fun addItem(item: Item){
        itemDao.addItem(item)
    }

    fun getItem(id: Int): LiveData<Item>{
        return itemDao.getItem(id)
    }

    suspend fun updateItem(item: Item){
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: Item){
        itemDao.deleteItem(item)
    }
}