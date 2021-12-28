package com.orozbek.taskApp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.orozbek.taskApp.databinding.FragmentMainBinding
import com.orozbek.taskApp.domain.ShopItem
import com.orozbek.taskApp.presentation.MainAdapter
import com.orozbek.taskApp.presentation.MainViewModel


class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapterMain: MainAdapter
    private val binding: FragmentMainBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        initListeners()
        initObservers()
        getResultFromFragment()
    }

    private fun getResultFromFragment() {
        parentFragmentManager.setFragmentResultListener("key", viewLifecycleOwner,
            { requestKey, result ->
//                Toast.makeText(requireContext(), result.getSerializable("keyBundle").toString(), Toast.LENGTH_SHORT).show()
                viewModel.addShopItem(result.getSerializable("keyBundle") as ShopItem)
            }
        )
    }

    private fun initListeners() {
        binding.fabBtn.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.containerFrmgment)
                .navigate(R.id.detailFragment)
        }
    }

    private fun setupRecyclerView() {
        binding.mainRv.apply {
            adapterMain = MainAdapter()
            adapter = adapterMain
        }

        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = adapterMain.currentList[viewHolder.absoluteAdapterPosition]
//                viewModel.deleteItem(item)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.mainRv)

    }

    private fun setupListeners() {

    }

    private fun initObservers() {
        viewModel.shopList.observe(this, Observer {
            adapterMain.submitList(it)
            Log.e("TAG", "initObservers: ${it}", )
        })
    }

}