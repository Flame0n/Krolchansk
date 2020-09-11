package com.example.krolchansk.ui.assortment

import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krolchansk.model.AssortmentItem
import com.example.krolchansk.ui.bottomsheet.AssortmentBottomSheet
import kotlinx.android.synthetic.main.item_assortment.view.*

class AssortmentRecyclerViewHolder(val view: View, val fragment: AssortmentFragment) : RecyclerView.ViewHolder(view) {
    val name = view.text_view_item_assortment;

    fun bind(item: AssortmentItem) {
        name.text = item.name;
        view.text_view_item_assortment_price.text = item.price.toString()
        view.setOnClickListener {
            AssortmentBottomSheet(item, fragment).show((fragment.activity as AppCompatActivity).supportFragmentManager, null)
        }
    }

}