package com.example.krolchansk.model

import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue

data class AssortmentItem (
    val name: String,
    val type: AssortmentItemType,
    val measureType: AssortmentMeasureType,
    val price: Double

)
