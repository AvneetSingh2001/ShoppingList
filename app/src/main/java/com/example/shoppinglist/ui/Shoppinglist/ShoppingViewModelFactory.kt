package com.example.shoppinglist.ui.Shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.data.repositories.ShoppingRepositories

class ShoppingViewModelFactory(
    val repositories: ShoppingRepositories
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repositories) as T
    }
}