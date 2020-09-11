package com.example.krolchansk.ui.assortment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.krolchansk.R

class AssortmentRecyclerAdapter(val fragment: AssortmentFragment) :
    RecyclerView.Adapter<AssortmentRecyclerViewHolder>() {

    val viewModel = fragment.assortmentViewModel;

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AssortmentRecyclerViewHolder = AssortmentRecyclerViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_assortment, parent, false
        ), fragment
    )

    override fun getItemCount(): Int = viewModel.assortmentItems.size;

    override fun onBindViewHolder(holder: AssortmentRecyclerViewHolder, position: Int) {
        holder.bind(viewModel.assortmentItems[position])
    }

}