package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Dao
abstract class ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun upsert(item: ShoppingItem)

    @Delete
    abstract suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    abstract fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}
