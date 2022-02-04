package com.app.apppractice.ui.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.app.apppractice.R
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.data.model.ProductModel
import com.app.apppractice.data.model.ShoppingCart
import com.app.apppractice.databinding.FragmentProductDetailDialogBinding
import com.app.apppractice.ui.viewmodel.FavoriteViewModel
import com.app.apppractice.ui.viewmodel.ProductViewModel
import com.app.apppractice.ui.viewmodel.ShoppingCartViewModel
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentProductDetailDialogBinding? = null
    private val binding get() = _binding!!
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private val shoppingCartViewModel: ShoppingCartViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarProduct.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        binding.toolbarProduct.setTitleTextColor(Color.WHITE)
        binding.toolbarProduct.setNavigationOnClickListener {
            dismiss()
        }
        val  product = arguments?.getSerializable("product") as ProductModel
        binding.toolbarProduct.title = product.title
        Glide.with(view.context)
            .load(product.image)
            .into(binding.ivDetailProductImage)
        binding.tvDetailProductName.text = product.title
        binding.tvDetailProductPrice.text = product.price.toString()
        binding.tvDetailProductCategory.text = product.category
        binding.tvDetailProductDescription.text = product.description
        binding.ibAddQuantity.setOnClickListener { setQuantity(1) }
        binding.ibRemoveQuantity.setOnClickListener { setQuantity(-1) }
        binding.ibAddCart.setOnClickListener {
            insertItem(product, binding.tvQuantity.text.toString())
        }
        binding.ibFavorite.setOnClickListener {
            favoriteProduct(product)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    fun setQuantity(value: Int){
        var quantity: Int = binding.tvQuantity.text.toString().toInt() + value
        if(quantity > 0)
            binding.tvQuantity.text = quantity.toString()

    }

    fun  insertItem(product: ProductModel, quantity: String){
        var item = ShoppingCart(
            product.id,
            product.title,
            product.price,
            product.category,
            product.description,
            product.image,
            quantity.toInt()
        )
        shoppingCartViewModel.insert(item)
    }

    fun favoriteProduct(product: ProductModel){
        val favorite = Favorite(
            product.id,
            product.title,
            product.price,
            product.category,
            product.description,
            product.image
        )
        favoriteViewModel.insert(favorite)
        binding.ibFavorite.setImageResource(R.drawable.ic_favorite)
    }
}