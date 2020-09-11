package com.example.krolchansk.model

open class CartItem(val name: String, val measureType: AssortmentMeasureType, val count: Int, val price: Double){
    override fun toString(): String {
        return "${name}  ${count}  ${price}"
    }
}

class MeatCartItem(
    name: String,
    measureType: AssortmentMeasureType,
    count: Int,
    price: Double,
    val isHalal: Boolean,
    val isCertificated: Boolean,
    val isCut: Boolean

) : CartItem(name, measureType, count, price)