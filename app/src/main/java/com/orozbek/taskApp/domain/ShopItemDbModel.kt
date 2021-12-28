package com.orozbek.taskApp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShopItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
