package com.example.krolchansk.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krolchansk.model.CartItem

class CartViewModel : ViewModel() {
    val cartItems = MutableLiveData<MutableList<CartItem>>()
    init {
        cartItems.value = mutableListOf()
    }


}