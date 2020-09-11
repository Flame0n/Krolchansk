package com.example.krolchansk.ui.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import com.example.krolchansk.model.*
import com.example.krolchansk.ui.cart.CartViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_assortment.*
import kotlinx.android.synthetic.main.dialog_assortment.view.*
import kotlinx.android.synthetic.main.item_assortment.*

class AssortmentBottomSheet(val assortmentItem: AssortmentItem, val fragment: Fragment) :
    BottomSheetDialogFragment() {
    lateinit var viewModel: CartViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.dialog_assortment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(fragment.requireActivity()).get(CartViewModel::class.java)
        if (assortmentItem.type == AssortmentItemType.NotMeat) {
            checkbox_cutting_meat.visibility = View.GONE
            checkbox_veterinary_certificate.visibility = View.GONE
            checkbox_halal.visibility = View.GONE
        }

        button_apply.setOnClickListener {

            when (assortmentItem.type) {
                AssortmentItemType.NotMeat -> viewModel.cartItems.value?.add(
                    CartItem(
                        assortmentItem.name,
                        assortmentItem.measureType,
                        number_picker_item_count.value,
                        assortmentItem.price * number_picker_item_count.value
                    )
                )
                AssortmentItemType.Meat -> viewModel.cartItems.value?.add(
                    MeatCartItem(
                        assortmentItem.name,
                        assortmentItem.measureType,
                        number_picker_item_count.value,
                        assortmentItem.price * number_picker_item_count.value,
                        checkbox_halal.isChecked,
                        checkbox_cutting_meat.isChecked,
                        checkbox_veterinary_certificate.isChecked
                    )
                )
            }
            viewModel.cartItems.postValue(viewModel.cartItems.value)
            dismiss()
        }

        button_cancel.setOnClickListener {
            dismiss()
        }
        number_picker_item_count.minValue = 1
        number_picker_item_count.maxValue = 100
        text_view_product_title.text = "Параметры выбранного продукта ${assortmentItem.name}"

        when (assortmentItem.measureType) {
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

