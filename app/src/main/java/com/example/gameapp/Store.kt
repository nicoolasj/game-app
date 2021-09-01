package com.example.gameapp


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id")
    val id: Int,
    @SerializedName("store")
    val store: StoreX
)