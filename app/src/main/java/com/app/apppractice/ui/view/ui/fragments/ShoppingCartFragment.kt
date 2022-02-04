package com.app.apppractice.ui.view.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.apppractice.data.model.ShoppingCart
import com.app.apppractice.databinding.FragmentShoppingCartBinding
import com.app.apppractice.ui.view.adapter.ShoppingCartAdapter
import com.app.apppractice.ui.view.adapter.ShoppingCartListener
import com.app.apppractice.ui.viewmodel.ShoppingCartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingCartFragment : Fragment(), ShoppingCartListener {

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var shoppingCartAdapter: ShoppingCartAdapter
    private val shoppingCartViewModel: ShoppingCartViewModel by viewModel()
    private var total: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoppingCartViewModel.allItems.observe(viewLifecycleOwner, { items ->
            shoppingCartAdapter.listItems = items
            total = items.sumOf { item -> item.price * item.quantity }
        })

        shoppingCartAdapter = ShoppingCartAdapter(this)
        binding.rvShoppingCart.apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
            adapter = shoppingCartAdapter
        }
        binding.bRemoveAllShopping.setOnClickListener {
            removeAllItems()
        }

        binding.bShoppingProducts.setOnClickListener {
            totalBuyItems(view.context)
        }
    }

    override fun onRemoveItemClicked(shoppingCart: ShoppingCart, position: Int) {
        shoppingCartViewModel.delete(shoppingCart)
    }

    override fun onUpdateQuantityClicked(shoppingCart: ShoppingCart, position: Int, value: Int) {
        val newQuantity = shoppingCart.quantity + value
        if (newQuantity > 0)
            shoppingCartViewModel.update(shoppingCart.id, newQuantity)
    }

    fun totalBuyItems(context: Context) {
        Toast.makeText(context, "Total buy items $$total", Toast.LENGTH_LONG).show()
        removeAllItems()
    }

    fun removeAllItems() {
        shoppingCartViewModel.deleteAll()
    }
}