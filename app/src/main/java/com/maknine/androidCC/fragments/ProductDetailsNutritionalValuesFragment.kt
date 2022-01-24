package com.maknine.androidCC.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maknine.androidCC.R

class ProductDetailsNutritionalValuesFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailsNutritionalValuesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_nutritional_values_fragment,
            container,
            false
        )
    }


}