package com.app.apppractice.ui.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.apppractice.R
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel
import com.app.apppractice.databinding.FragmentProductsBinding
import com.app.apppractice.ui.view.adapter.ProductAdapter
import com.app.apppractice.ui.view.adapter.ProductListener
import com.app.apppractice.ui.viewmodel.FavoriteViewModel
import com.app.apppractice.ui.viewmodel.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsFragment : Fragment(),  ProductListener{

    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(productViewModel.listProduct.value.isNullOrEmpty()) productViewModel.onCreate()

        productAdapter = ProductAdapter(this)
        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = productAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        productViewModel.listProduct.observe(viewLifecycleOwner, Observer<List<ProductModel>>{ product ->
            productAdapter.updateData(product)
        })

        productViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if(it != null)
                binding.rlBaseProduct.visibility = View.INVISIBLE
        })
    }

    override fun onProductClicked(product: ProductModel, position: Int) {
        product.id = position+1
        val bundle = bundleOf("product" to product)
        findNavController().navigate(R.id.productDetailFragmentDialog, bundle)
    }

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onFavoriteClicked(favorite: Favorite, position: Int) {
        favoriteViewModel.insert(favorite)
    }

}

