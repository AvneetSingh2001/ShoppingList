package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.Shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel : ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curItem = items[position]
        holder.itemView.tvName.text = curItem.name
        holder.itemView.tvAmount.text = "${curItem.amount}"

        holder.itemView.ivDelete.setOnClickListener{
            viewModel.delete(curItem)
        }

        holder.itemView.ivPlus.setOnClickListener{
            curItem.amount++
            viewModel.upsert(curItem)
        }

        holder.itemView.ivMinus.setOnClickListener{
            if(curItem.amount > 0){
                curItem.amount--
                viewModel.upsert(curItem)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}