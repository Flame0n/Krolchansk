package com.example.krolchansk.ui.cart

import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.krolchansk.model.AssortmentItem
import com.example.krolchansk.model.CartItem
import com.example.krolchansk.model.MeatCartItem
import com.example.krolchansk.ui.bottomsheet.AssortmentBottomSheet
import com.example.krolchansk.ui.bottomsheet.CartBottomSheet
import kotlinx.android.synthetic.main.item_cart.view.*

class CartRecyclerViewHolder(val view: View, val fragment: CartFragment) : RecyclerView.ViewHolder(view) {
    val name = view.text_view_item_cart_name;
    val count = view.text_view_item_cart_count
    val price = view.text_view_item_cart_price
    val halal = view.text_view_item_cart_halal
    val certified = view.text_view_item_cart_certificate
    val meatcut = view.text_view_item_cart_cut

    fun bind(cartItem: CartItem) {
        name.text = cartItem.name
        count.text = "x${cartItem.count}"
        price.text = "x${cartItem.price}"
        when (cartItem) {
            is MeatCartItem -> {
                halal.visibility = if (cartItem.isHalal) View.VISIBLE else View.GONE
                certified.visibility = if (cartItem.isCertificated) View.VISIBLE else View.GONE
                meatcut.visibility = if (cartItem.isCut) View.VISIBLE else View.GONE
            }
            else -> {
                halal.visibility = View.GONE
                certified.visibility = View.GONE
                meatcut.visibility = View.GONE
            }


        }
        view.setOnClickListener {
            CartBottomSheet(cartItem, fragment).show((fragment.activity as AppCompatActivity).supportFragmentManager, null)
        }
    }

}