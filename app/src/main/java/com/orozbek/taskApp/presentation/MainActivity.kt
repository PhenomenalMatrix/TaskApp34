package com.orozbek.taskApp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.orozbek.taskApp.R
import com.orozbek.taskApp.databinding.ActivityMainBinding
import com.orozbek.taskApp.domain.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var shopItem: ShopItem
    private lateinit var adapterMain: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        initObservers()
        setupListeners()
    }

    private fun setupListeners() {
//        adapterMain.onShopItemLongClickListener = {
//            viewModel.changeEnableState(it)
//        }
    }

    private fun initObservers() {
        viewModel.shopList.observe(this, Observer {
            adapterMain.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        binding.mainRv.apply {
            adapterMain = MainAdapter()
            adapter = adapterMain
        }

        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
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

}