package com.example.shoppinglist.ui.Shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val Repository: ShoppingRepositories
): ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        Repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        Repository.delete(item)
    }

    fun getAllShoppingItems() = Repository.getAllShoppingItems()

}