package com.maknine.androidCC.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.maknine.androidCC.R


class ProductDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = view.findViewById<BottomNavigationView> (R.id.product_details_bottom_nav)

        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(bottomNavigationView, navHost.navController)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.tab_fiche -> {
                    // Respond to navigation item 1 click
                    navHost.navController.navigate(R.id.productDetailsSummaryFragment, arguments)
                    true
                }
                R.id.tab_grid -> {
                    // Respond to navigation item 2 click
                    navHost.navController.navigate(R.id.productDetailsNutritionalValuesFragment, arguments)
                    true
                }
                R.id.tab_nutrition -> {
                    navHost.navController.navigate(R.id.productDetailsNutritionFragment, arguments)
                    true
                }
                else -> false
            }
        }

        bottomNavigationView.selectedItemId = R.id.tab_fiche
    }
}