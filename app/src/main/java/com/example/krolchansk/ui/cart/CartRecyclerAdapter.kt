package com.example.krolchansk.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.krolchansk.R

class CartRecyclerAdapter(val fragment: CartFragment) :
    RecyclerView.Adapter<CartRecyclerViewHolder>() {
    val viewModel = fragment.cartViewModel;

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartRecyclerViewHolder = CartRecyclerViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_cart, parent, false
        ), fragment
    )


    override fun getItemCount(): Int = viewModel.cartItems.value?.size ?: 0


    override fun onBindViewHolder(holder: CartRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.cartItems.value!![position])
    }


}