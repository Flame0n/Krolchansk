package com.example.krolchansk.ui.bottomsheet

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import com.example.krolchansk.model.AssortmentMeasureType
import com.example.krolchansk.model.CartItem
import com.example.krolchansk.model.MeatCartItem
import com.example.krolchansk.ui.call.DialogAlert
import com.example.krolchansk.ui.cart.CartViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.dialog_accept.*
import kotlinx.android.synthetic.main.dialog_cart.*

class AcceptOrderBottomSheet(val fragment: Fragment) :
    BottomSheetDialogFragment() {

    lateinit var viewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.dialog_accept, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(fragment.requireActivity()).get(CartViewModel::class.java)

        button_end.setOnClickListener {
            if (!viewModel.cartItems.value!!.isEmpty()) {
                DialogAlert("", "Список покупок пуст")
                dismiss()
            }
            val database = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://krolchansk-fdea7.firebaseio.com/active_orders")
            val id = database.push().key;

            if (edit_text_ACCEPT_EMAIL.text.toString() != "" && edit_text_familia.text.toString() != "" && edit_text_ACCEPT_PHONE.text.toString() != "") {
                database.child("ID ${id}").child("email")
                    .setValue(edit_text_ACCEPT_EMAIL.text.toString())
                database.child("ID ${id}").child("date")
                    .setValue(System.currentTimeMillis().toString())
                database.child("ID ${id}").child("name").setValue(edit_text_familia.text.toString())
                database.child("ID ${id}").child("status").setValue("0")
                database.child("ID ${id}").child("phone")
                    .setValue(edit_text_ACCEPT_PHONE.text.toString())
                database.child("ID ${id}").child("registration_id").setValue(
                    view.context.getSharedPreferences("Token: ", Context.MODE_PRIVATE)
                        .getString("Token: ", "") ?: ""
                )
                database.child("ID ${id}").child("positions")
                    .setValue(viewModel.cartItems.value!!.map { it.toString() }.toString())
                DialogAlert("", "Заказ был успешно отправлен").show(
                    this.childFragmentManager,
                    "myDialog"
                )
            } else {
                DialogAlert("", "Одно из заполняемых полей пусто").show(
                    this.childFragmentManager,
                    "myDialog"
                )
            }
            dismiss()
        }

        button_otmena.setOnClickListener {

            dismiss()
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

