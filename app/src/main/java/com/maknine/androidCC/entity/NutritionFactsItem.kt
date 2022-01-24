package com.maknine.androidCC.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFactsItem constructor (
    var unit : String,
    var quantity: String,
    var quantityFor100g: String,
) : Parcelable