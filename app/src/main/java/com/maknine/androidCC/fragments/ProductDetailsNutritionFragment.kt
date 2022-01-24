package com.maknine.androidCC.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.maknine.androidCC.R
import com.maknine.androidCC.entity.Product

class ProductDetailsNutritionFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailsNutritionFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_nutrition_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedProduct = arguments?.getParcelable<Product>("product")
        selectedProduct?.bindToLayout()
    }

    fun TextView.replaceDotwithComma(value: String) {
        val replaced = value.replace(".", ",")
        this.text = replaced
    }

    fun Product.bindToLayout(): Unit {
        view?.findViewById<TextView>(R.id.nutri_title)!!.text = "Repère nutritionnel pour " + this.title
        val fatMatter = this.nutritionFactsItems.getNutritionFactEvaluation("fat");
        view?.findViewById<TextView>(R.id.nutri_fat_lip)!!.replaceDotwithComma(this.nutritionFactsItems.fatMatter.quantity + this.nutritionFactsItems.fatMatter.unit)

        view?.findViewById<TextView>(R.id.nutri_fat_lip_eval)!!.text = fatMatter.second
        DrawableCompat.setTint(
            view?.findViewById<View>(R.id.nutrient_fat_lip_level)!!.background,
            ResourcesCompat.getColor(
                getResources(),
                this.nutritionFactsItems.getNutritionColor(fatMatter.first),
                null
            )
        )
        val saturateFatAcid =
            this.nutritionFactsItems.getNutritionFactEvaluation("saturateFatAcid");
        view?.findViewById<TextView>(R.id.nutri_saturate_fat_acid)!!.replaceDotwithComma(this.nutritionFactsItems.saturateFatAcid.quantity + this.nutritionFactsItems.saturateFatAcid.unit)
        view?.findViewById<TextView>(R.id.nutri_saturate_fat_acid_eval)!!.text =
            saturateFatAcid.second
        DrawableCompat.setTint(
            view?.findViewById<View>(R.id.nutrient_saturate_fat_acid_level)!!.background,
            ResourcesCompat.getColor(
                getResources(),
                this.nutritionFactsItems.getNutritionColor(saturateFatAcid.first),
                null
            )
        )
        val sugar = this.nutritionFactsItems.getNutritionFactEvaluation("sugar");
        view?.findViewById<TextView>(R.id.nutri_sugar)!!.replaceDotwithComma(this.nutritionFactsItems.sugar.quantity + this.nutritionFactsItems.sugar.unit)
        view?.findViewById<TextView>(R.id.nutri_sugar_eval)!!.text = sugar.second
        DrawableCompat.setTint(
            view?.findViewById<View>(R.id.nutrient_sugar_level)!!.background,
            ResourcesCompat.getColor(
                getResources(),
                this.nutritionFactsItems.getNutritionColor(sugar.first),
                null
            )
        )
        val salt = this.nutritionFactsItems.getNutritionFactEvaluation("salt");
        view?.findViewById<TextView>(R.id.nutri_salt)!!.replaceDotwithComma(this.nutritionFactsItems.salt.quantity + this.nutritionFactsItems.salt.unit)
        view?.findViewById<TextView>(R.id.nutri_salt_eval)!!.text = salt.second
        DrawableCompat.setTint(
            view?.findViewById<View>(R.id.nutrient_salt_level)!!.background,
            ResourcesCompat.getColor(
                getResources(),
                this.nutritionFactsItems.getNutritionColor(salt.first),
                null
            )
        )
    }
}