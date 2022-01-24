package com.maknine.androidCC.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.maknine.androidCC.R
import com.maknine.androidCC.entity.Product
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ProductDetailsSummaryFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailsSummaryFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_summary_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedProduct = arguments?.getParcelable<Product>("product")
        selectedProduct?.bindToLayout()
    }

    fun TextView.setValueTitleInBold(value:String) {
        val index = value.indexOf(':')
        val spannable = SpannableString(value)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, index, 0)
        this.text = spannable
    }

    fun TextView.setValueInBold(value:String) {
        val spannable = SpannableString(value)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, value.length, 0)
        this.text = spannable
    }

    fun Product.bindToLayout():Unit
    {
        Picasso.get()
            .load(this.imageUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .error(R.drawable.placeholderr)
            .noFade()
            .into(view?.findViewById(R.id.product_image))
        view?.findViewById<android.widget.TextView> (R.id.product_title)!!.setValueInBold(this.title)
        view?.findViewById<TextView> (R.id.product_subTitle)!!.text = this.brand
        view?.findViewById<TextView> (R.id.product_barcode)!!.setValueTitleInBold(
            getString(
                R.string.codes_barres,
                this.barCode
            )
        )
        view?.findViewById<TextView> (R.id.product_quantity)!!.setValueTitleInBold(
            getString(
                R.string.quantity,
                this.quantity
            )
        )
        view?.findViewById<TextView> (R.id.product_sellIn)!!.setValueTitleInBold(
            getString(
                R.string.sell_in,
                this.countryOfSelling.joinToString()
            )
        )
        view?.findViewById<TextView> (R.id.product_ingredients)!!.setValueTitleInBold(
            getString(
                R.string.product_ingredients,
                this.ingredients.joinToString()
            )
        )
        view?.findViewById<TextView> (R.id.product_substances)!!.setValueTitleInBold(
            getString(
                R.string.product_substances,
                this.allergies.joinToString()
            )
        )
        view?.findViewById<TextView> (R.id.product_additive)!!.setValueTitleInBold(
            getString(
                R.string.product_additive,
                this.additives.joinToString(postfix = ".")
            )
        )
    }


}