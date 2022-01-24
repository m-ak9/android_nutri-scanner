package com.maknine.androidCC.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    var title: String,
    var brand: String,
    var barCode: String,
    var nutriscore: String,
    var imageUrl: String,
    var quantity: String,
    var countryOfSelling: List<String>,
    var ingredients: List<String>,
    var allergies: List<String>,
    var additives: List<String>,
    var nutritionFactsItems: NutritionFacts
): Parcelable {


}