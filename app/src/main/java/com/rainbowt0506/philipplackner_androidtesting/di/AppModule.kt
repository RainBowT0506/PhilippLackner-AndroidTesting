package com.rainbowt0506.philipplackner_androidtesting.di

import android.content.Context
import androidx.room.Room
import com.rainbowt0506.philipplackner_androidtesting.Constants.BASE_URL
import com.rainbowt0506.philipplackner_androidtesting.Constants.DATABASE_NAME
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingItemDatabase
import com.rainbowt0506.philipplackner_androidtesting.data.remote.PixabayAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }
}