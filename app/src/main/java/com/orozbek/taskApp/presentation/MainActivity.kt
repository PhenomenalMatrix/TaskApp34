package com.orozbek.taskApp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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

//        viewModel.getShopList()
        setupRecyclerView()

        viewModel.getShopItem(2)

        viewModel.shopItem.observe(this, Observer {
            viewModel.changeEnableState(it)
        })

        viewModel.shopList.observe(this, Observer {
            Log.e("TAG", "onCreate: ${it.size}", )
            adapterMain.shopList = it
        })

    }

    private fun setupRecyclerView() {
        binding.mainRv.apply {
            adapterMain = MainAdapter()
            adapter = adapterMain
        }
    }

}