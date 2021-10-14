package com.example.shoppinglist.ui.Shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.repositories.ShoppingRepositories

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repositories = ShoppingRepositories(database)
        val factory = ShoppingViewModelFactory(repositories)

        val viewModel= ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

    }
}