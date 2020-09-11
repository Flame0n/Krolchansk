package com.example.krolchansk.ui.bottomsheet

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import com.example.krolchansk.model.*
import com.example.krolchansk.ui.cart.CartFragment
import com.example.krolchansk.ui.cart.CartRecyclerAdapter
import com.example.krolchansk.ui.cart.CartViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_cart.*
import kotlinx.android.synthetic.main.dialog_cart.view.*
import kotlinx.android.synthetic.main.fragment_cart.*

class CartBottomSheet(val cartItem: CartItem, val fragment: Fragment) :
    BottomSheetDialogFragment() {
    lateinit var viewModel: CartViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.dialog_cart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(fragment.requireActivity()).get(CartViewModel::class.java)
        if (cartItem !is MeatCartItem) {
            checkbox_cutting_meat.visibility = View.GONE
            checkbox_veterinary_certificate.visibility = View.GONE
            checkbox_halal.visibility = View.GONE
        } else {
            checkbox_cutting_meat.isChecked = cartItem.isCut
            checkbox_veterinary_certificate.isChecked = cartItem.isCertificated
            checkbox_halal.isChecked = cartItem.isHalal
        }

        button_change.setOnClickListener {
            viewModel.cartItems.value?.remove(cartItem)
            when (cartItem) {
                !is MeatCartItem -> viewModel.cartItems.value?.add(
                    CartItem(
                        cartItem.name,
                        cartItem.measureType,
                        number_picker_item_count.value,
                        number_picker_item_count.value * cartItem.price / cartItem.count
                    )
                )
                else -> {
                    viewModel.cartItems.value?.add(
                        MeatCartItem(
                            cartItem.name,
                            cartItem.measureType,
                            number_picker_item_count.value,
                            number_picker_item_count.value * cartItem.price / cartItem.count,
                            checkbox_halal.isChecked,
                            checkbox_cutting_meat.isChecked,
                            checkbox_veterinary_certificate.isChecked
                        )

                    )
                }
            }
            viewModel.cartItems.postValue(viewModel.cartItems.value)
            dismiss()
        }

        button_delete.setOnClickListener {
            viewModel.cartItems.value?.remove(cartItem)

            viewModel.cartItems.postValue(viewModel.cartItems.value)

            dismiss()
        }

        number_picker_item_count.minValue = 1
        number_picker_item_count.maxValue = 100
        text_view_product_title.text = "Параметры выбранного продукта ${cartItem.name}"

        number_picker_item_count.value = cartItem.count

        when (cartItem.measureType) {
            AssortmentMeasureType.Number -> text_view_measure_type.text =
                "Выберите количество продукта"
            AssortmentMeasureType.Weight -> text_view_measure_type.text = "Выберите количество в КГ"
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.skipCollapsed = true
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
        }
        return dialog

    }
}

