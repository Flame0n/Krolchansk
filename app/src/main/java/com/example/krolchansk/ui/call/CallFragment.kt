package com.example.krolchansk.ui.call

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.krolchansk.R
import com.example.krolchansk.ui.cart.CartRecyclerAdapter
import com.example.krolchansk.ui.cart.CartViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_call.view.*
import kotlinx.android.synthetic.main.fragment_cart.*


class CallFragment : Fragment() {

    private lateinit var callViewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        callViewModel =
            ViewModelProviders.of(this).get(CallViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_call, container, false)

        root.button_order_call.setOnClickListener() {
            val database = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://krolchansk-fdea7.firebaseio.com/callback")
            val id = database.push().key;
            val phone = view!!.edit_Text_Phone.text
            if (phone.length == 13) {
                database.child("${id}").child("phone").setValue(phone.toString())
                database.child("${id}").child("status").setValue("1")
                DialogAlert("","Данные были успешно отправлены, ожидайте звонка.").show(this.childFragmentManager, "myDialog")
            } else {
                DialogAlert("Ошибка","Введите полный номер").show(this.childFragmentManager, "myDialog")
            }
        }


        return root
    }


}



