package com.rainbowt0506.philipplackner_androidtesting.repositories

import androidx.lifecycle.LiveData
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingItem
import com.rainbowt0506.philipplackner_androidtesting.data.remote.Resource
import com.rainbowt0506.philipplackner_androidtesting.data.remote.responses.ImageResponse

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}