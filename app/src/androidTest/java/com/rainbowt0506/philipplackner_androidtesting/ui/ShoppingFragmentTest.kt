package com.rainbowt0506.philipplackner_androidtesting.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.rainbowt0506.philipplackner_androidtesting.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import com.rainbowt0506.philipplackner_androidtesting.R
import com.rainbowt0506.philipplackner_androidtesting.adapter.ShoppingItemAdapter
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingItem
import com.rainbowt0506.philipplackner_androidtesting.util.getOrAwaitValue
import org.mockito.Mockito.`when`
import javax.inject.Inject


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class ShoppingFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var testFragmentFactory: TestShoppingFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * 這個測試函式測試在使用者滑動刪除購物項目時是否會從資料庫中刪除該項目。
     * 它包含了對 View 和 ViewModel 以及底層資料庫的操作。
     */
    @Test
    fun swipeShoppingItem_deleteItemInDb() {
        //  建立一個購物項目 shoppingItem。
        val shoppingItem = ShoppingItem("TETS", 1, 1f, "Test", 1)
        //  創建一個 ShoppingViewModel 實例
        var testViewModel: ShoppingViewModel? = null
        //  啟動 ShoppingFragment 並將 shoppingItem 插入資料庫。
        launchFragmentInHiltContainer<ShoppingFragment>(fragmentFactory = testFragmentFactory) {
            testViewModel = viewModel
            viewModel?.insertShoppingItemIntoDb(shoppingItem)
        }
        //  使用 Espresso 測試庫，模擬在 rvShoppingItems（購物清單的 RecyclerView）中滑動第一個項目。
        onView(withId(R.id.rvShoppingItems)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ShoppingItemAdapter.ShoppingItemViewHolder>(
                0,
                swipeLeft()
            )
        )
        //  斷言檢查 testViewModel 中的購物項目是否為空。
        assertThat(testViewModel?.shoppingItems?.getOrAwaitValue()).isEmpty()
    }

    /**
     * 這個測試函式測試當使用者點擊新增購物項目按鈕時，是否導航到新增購物項目的片段。
     * 它主要涉及使用者介面的操作和導航行為。
     */
    @Test
    fun clickAddShoppingItemButton_navigateToAddShoppingItemFragment() {
        //  使用 Mockito 建立一個假的 NavController。
        val navController = mock(NavController::class.java)

        //  設置當調用 navController.popBackStack() 時返回 false。
        `when`(navController.popBackStack()).thenReturn(false)

        //  啟動 ShoppingFragment 並將 NavController 設置為其導航控制器。
        launchFragmentInHiltContainer<ShoppingFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }

        //  使用 Espresso 測試庫，模擬點擊 fabAddShoppingItem（新增購物項目的 FAB 按鈕）。
        onView(withId(R.id.fabAddShoppingItem)).perform(click())

        //  驗證確保 navController 已導航到正確的目的地。
        verify(navController).navigate(
            ShoppingFragmentDirections.actionShoppingFragmentToAddShoppingFragment()
        )
    }
}