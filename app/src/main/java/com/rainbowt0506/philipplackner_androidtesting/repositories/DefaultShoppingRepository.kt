package com.rainbowt0506.philipplackner_androidtesting.repositories

import androidx.lifecycle.LiveData
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingDao
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingItem
import com.rainbowt0506.philipplackner_androidtesting.data.remote.PixabayAPI
import com.rainbowt0506.philipplackner_androidtesting.data.remote.Resource
import com.rainbowt0506.philipplackner_androidtesting.data.remote.responses.ImageResponse
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao, private val pixabayAPI: PixabayAPI
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured.", null)
            } else {
                Resource.error("An unknown error occured.", null)
            }
        } catch (e: Exception) {
            Resource.error("An unknown error occured.", null)
        }
    }
}