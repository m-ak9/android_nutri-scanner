package com.maknine.androidCC.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.maknine.androidCC.R
import com.maknine.androidCC.entity.Product
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ProductsAdapter (private val mProducts: List<Product>, private val onProductClicked: (position: Int) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private val onProductClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView = itemView.findViewById<ImageView>(R.id.recycle_product_image)
        val productTitle = itemView.findViewById<TextView>(R.id.recycle_product_title)
        val productSubTitle = itemView.findViewById<TextView>(R.id.recycle_product_subTitle)
        val nutriscoreDesc = itemView.findViewById<TextView>(R.id.recycle_product_nutriscore)
        val calDesc = itemView.findViewById<TextView>(R.id.recycle_product_cal)
        val bookmarked = itemView.findViewById<CheckBox>(R.id.recycle_checkboxBookmark)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onProductClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_product, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView, onProductClicked)
    }

    override fun onBindViewHolder(viewHolder: ProductsAdapter.ViewHolder, position: Int) {
        val product: Product = mProducts.get(position)
        val imageView = viewHolder.imageView
        Picasso.get()
            .load(product.imageUrl)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .error(R.drawable.placeholderr)
            .noFade()
            .into(imageView)
        val productTitle = viewHolder.productTitle
        productTitle.text = product.title
        val productSubTitle = viewHolder.productSubTitle
        productSubTitle.text = product.brand
        val nutriscoreDesc = viewHolder.nutriscoreDesc
        nutriscoreDesc.text = "Nutriscore : " + product.nutriscore
        val calDesc = viewHolder.calDesc
        calDesc.text =  product.nutritionFactsItems.calories.quantity + " kCal/part"
        val bookmarked = viewHolder.bookmarked
        bookmarked.setOnCheckedChangeListener { checkBox, isChecked ->
        }
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }
}
