package com.example.krolchansk.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import com.example.krolchansk.model.CartItem
import com.example.krolchansk.ui.assortment.AssortmentRecyclerAdapter
import com.example.krolchansk.ui.assortment.AssortmentViewModel
import com.example.krolchansk.ui.bottomsheet.AcceptOrderBottomSheet
import com.example.krolchansk.ui.call.DialogAlert
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    lateinit var cartViewModel: CartViewModel
    lateinit var recyclerAdapter: CartRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartViewModel =
            ViewModelProviders.of(requireActivity()).get(CartViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cart, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = CartRecyclerAdapter(this)
        recycler_view_cart.adapter = recyclerAdapter
        ORDER.setOnClickListener {
            if (cartViewModel.cartItems.value!!.isEmpty()) {
                DialogAlert(" ", "Список покупок пуст").show(this.childFragmentManager, "myDialog")
            } else {
                AcceptOrderBottomSheet(this).show(
                    (this.activity as AppCompatActivity).supportFragmentManager,
                    null
                )
            }

        }
        cartViewModel.cartItems.observe(viewLifecycleOwner, Observer {
            recyclerAdapter.notifyDataSetChanged()
        })


    }

}