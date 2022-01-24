package com.maknine.androidCC.entity

import android.os.Parcelable
import com.maknine.androidCC.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class NutritionFacts constructor (
    var calories : NutritionFactsItem,
    var fatMatter : NutritionFactsItem,
    var saturateFatAcid : NutritionFactsItem,
    var glucid : NutritionFactsItem,
    var sugar : NutritionFactsItem,
    var fiber : NutritionFactsItem,
    var protein : NutritionFactsItem,
    var salt : NutritionFactsItem,
    var sodium : NutritionFactsItem,
    ): Parcelable {
    fun getNutritionFactEvaluation(item: String): Pair<String, String> {
        var low: Pair<String, String> = Pair("low", "faible quantité");
        var moderate: Pair<String, String> = Pair("moderate", "quantité modérée");
        var high: Pair<String, String> = Pair("high", "quantité élevée");
        var default: Pair<String, String> = Pair("default", "");

        if (item.equals("sugar")) {
            if (this.sugar.quantity.toDouble() <= 5){
                return low
            } else if (this.sugar.quantity.toDouble() <= 12.5) {
                return  moderate;
            } else if (this.sugar.quantity.toDouble() > 12.5){
                return high
            } else {
                return default;
            }
        }
        if (item.equals("saturateFatAcid")) {
            if (this.saturateFatAcid.quantity.toDouble() <= 1.5){
                return low
            } else if (this.saturateFatAcid.quantity.toDouble() <= 5) {
                return  moderate
            } else if (this.saturateFatAcid.quantity.toDouble() > 5){
                return high
            } else {
                return default
            }
        }
        if (item.equals("salt")) {
            if (this.salt.quantity.toDouble() <= 0.3){
                return low
            } else if (this.salt.quantity.toDouble() <= 1.5) {
                return moderate
            } else if (this.salt.quantity.toDouble() > 1.5){
                return high
            } else {
                return default
            }
        }
        if (item.equals("fat")) {
            if (this.fatMatter.quantity.toDouble() <= 3){
                return low
            } else if (this.fatMatter.quantity.toDouble() <= 20) {
                return moderate
            } else if (this.fatMatter.quantity.toDouble() > 20){
                return high
            } else {
                return default
            }
        }
        return default;
    }

    fun getNutritionColor(evaluation: String): Int {
        when (evaluation) {
            "low" -> return R.color.nutrient_level_low;
            "moderate" -> return R.color.nutrient_level_moderate;
            "high" -> return R.color.nutrient_level_high;
            else -> return R.color.nutrient_level_default;

        }
    }


}