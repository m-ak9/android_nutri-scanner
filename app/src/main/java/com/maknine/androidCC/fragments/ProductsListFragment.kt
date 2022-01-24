package com.maknine.androidCC.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maknine.androidCC.R
import com.maknine.androidCC.adapter.ProductsAdapter
import com.maknine.androidCC.entity.NutritionFacts
import com.maknine.androidCC.entity.NutritionFactsItem
import com.maknine.androidCC.entity.Product

class ProductsListFragment : Fragment() {

    lateinit var products: List<Product>

    companion object {
        fun newInstance() = ProductsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.products_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvProducts = view.findViewById<View>(R.id.rvProducts) as RecyclerView

        products = listOf<Product>(
            Product(
                "Petits pois et carottes",
                "Cassegrain",
                "3083680085304",
                "A",
                "https://images.unsplash.com/photo-1482049016688-2d3e1b311543?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=joseph-gonzalez-fdlZBWIP0aM-unsplash.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf(
                    "Petits pois 66 %",
                    "eau",
                    "garniture 28 % (salade, oignon grelot)", "sucre", "sel", "arôme naturel"
                ),
                listOf("Aucune"),
                listOf("Aucun"),
                NutritionFacts(
                    NutritionFactsItem(
                        "kj",
                        "293",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.8",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.1",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "8.4",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "5.2",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "5.2",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "4.8",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.75",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.295",
                        ""
                    )
                )
            ),
            Product(
                "Petits pois et carottes",
                "Cassegrain",
                "3083680085304",
                "C",
                "https://resize-elle.ladmedia.fr/rcrop/638,,forcex/img/var/plain_site/storage/images/elle-a-table/les-dossiers-de-la-redaction/dossier-de-la-redac/comment-preparer-un-oeuf-au-plat/90562366-1-fre-FR/20-recettes-d-oeufs-au-plat-a-avoir-goute-au-moins-une-fois-dans-sa-vie.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf(
                    "Petits pois 66 %",
                    "eau",
                    "garniture 28 % (salade, oignon grelot)", "sucre", "sel", "arôme naturel"
                ),
                listOf("Aucune"),
                listOf("Aucun"),
                NutritionFacts(
                    NutritionFactsItem(
                        "kj",
                        "293",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.8",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.1",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "8.4",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "5.2",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "5.2",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "4.8",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.75",
                        ""
                    ),
                    NutritionFactsItem(
                        "g",
                        "0.295",
                        ""
                    )
                )
            )

        )

        val adapter = ProductsAdapter(products, {position -> onListProductClicked(position)})
        rvProducts.adapter = adapter
        rvProducts.layoutManager = LinearLayoutManager(activity)
    }

    private fun onListProductClicked(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("product", products.get(position))
        findNavController(this).navigate(R.id.action_productsListFragment_to_productDetailsFragment, bundle)
    }

}
