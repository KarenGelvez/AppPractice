package com.app.apppractice.ui.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.app.apppractice.data.model.Favorite
import com.app.apppractice.databinding.FragmentFavoriteBinding
import com.app.apppractice.ui.view.adapter.FavoriteAdapter
import com.app.apppractice.ui.view.adapter.FavoriteListener
import com.app.apppractice.ui.viewmodel.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment(), FavoriteListener {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteAdapter
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        favoriteViewModel.allFavorites.observe(viewLifecycleOwner, { favorites ->
            favoriteAdapter.listFavorite = favorites
        })

        favoriteAdapter = FavoriteAdapter(this)
        binding.rvFavorites.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = favoriteAdapter
        }

        binding.removeAllFavorites.setOnClickListener {
            removeFavoriteClicked()
        }
    }

    override fun onFavoriteClicked(favorite: Favorite, position: Int) {
        favoriteViewModel.deleteFavorite(favorite)

    }

    fun removeFavoriteClicked() {
        favoriteViewModel.deleteAllFavorites()
    }
}
