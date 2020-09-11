package com.example.krolchansk.ui.assortment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krolchansk.model.AssortmentItem
import com.example.krolchansk.model.AssortmentItemType
import com.example.krolchansk.model.AssortmentMeasureType

class AssortmentViewModel : ViewModel() {
    val assortmentItems = listOf(
        AssortmentItem(
            "Крольчатина парная",
            AssortmentItemType.Meat,
            AssortmentMeasureType.Number,
            600.0
        ),
        AssortmentItem(
            "Филе кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            1700.0
        ),
        AssortmentItem(
            "Вырезка мяса кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            100.0
        ),
        AssortmentItem(
            "Печень кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            1700.0
        ),
        AssortmentItem(
            "Пельмени с мясом кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number, 1500.0
        ),
        AssortmentItem(
            "Почки кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            1700.0
        ),
        AssortmentItem(
            "Сердце кролика",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            1700.0
        ),
        AssortmentItem(
            "Яйца куриные 1 дес",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            160.0
        ),
        AssortmentItem(
            "Яйцо утки 1 штука",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            50.0
        ),
        AssortmentItem(
            "Яйцо перепелиное 2 дес",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            160.0
        ),
        AssortmentItem(
            "Яйцо индейки 1 штука",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            100.0
        ),
        AssortmentItem(
            "ПЕРЕПЕЛ тушка ~0,2кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            200.0
        ),
        AssortmentItem(
            "Цесарка тушка ~1,2кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            1200.0
        ),
        AssortmentItem(
            "Кypа суповая ~0.8-1.4 кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            800.0
        ),
        AssortmentItem(
            "Кура бройлер ~1,4-2,5кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            600.0
        ),
        AssortmentItem(
            "Гусь сepыйй ~2,2-2,7кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            750.0
        ),
        AssortmentItem(
            "Утка пeкинcкая ~2кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            650.0
        ),
        AssortmentItem(
            "Индейка домашняя",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            600.0
        ),
        AssortmentItem(
            "ФИЛЕ индейки",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            999.0
        ),
        AssortmentItem(
            "Тушенка перепела в банках",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            700.0
        ),
        AssortmentItem(
            "МАСЛО сливoчнoе фермерское 0,2кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            300.0
        ),
        AssortmentItem(
            "Сыр сливочный пол головки 0,4",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            480.0
        ),
        AssortmentItem(
            "Творог домашний жирный 0,5кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            699.0
        ),
        AssortmentItem(
            "Сметана жирная 0,5",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            499.0
        ),
        AssortmentItem(
            "Козье молоко 1л",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            499.0
        ),
        AssortmentItem(
            "Козий творог 0,5кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            500.0
        ),
        AssortmentItem(
            "Козий сыр 0,4кг",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            600.0
        ),
        AssortmentItem(
            "Шкурка кролика 1 шкура ~ 1.4кв.м",
            AssortmentItemType.NotMeat,
            AssortmentMeasureType.Number,
            800.0
        )
    )
}