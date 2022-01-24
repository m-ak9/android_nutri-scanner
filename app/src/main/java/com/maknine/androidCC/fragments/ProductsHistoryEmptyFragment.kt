package com.maknine.androidCC.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maknine.androidCC.R

class ProductsHistoryEmptyFragment : Fragment() {

    companion object {
        fun newInstance() = ProductsHistoryEmptyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.products_history_empty_fragment, container, false)
    }

}