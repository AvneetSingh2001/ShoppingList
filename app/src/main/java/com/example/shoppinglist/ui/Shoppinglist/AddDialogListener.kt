package com.example.shoppinglist.ui.Shoppinglist

import com.example.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}