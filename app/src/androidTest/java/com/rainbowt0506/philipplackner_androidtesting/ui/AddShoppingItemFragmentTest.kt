package com.rainbowt0506.philipplackner_androidtesting.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.rainbowt0506.philipplackner_androidtesting.launchFragmentInHiltContainer
import com.rainbowt0506.philipplackner_androidtesting.repositories.FakeShoppingRepositoryAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject
import com.rainbowt0506.philipplackner_androidtesting.R
import com.rainbowt0506.philipplackner_androidtesting.data.local.ShoppingItem
import com.rainbowt0506.philipplackner_androidtesting.util.getOrAwaitValue


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class AddShoppingItemFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * 這個測試函式測試了當使用者將資訊輸入到新增購物項目的表單中並點擊添加按鈕時，購物項目是否被成功插入到資料庫中。這個測試並沒有涉及到多個系統元件之間的互動，而是專注於測試單一功能。
     * 它驗證了 ViewModel 能夠正確地將輸入的資訊插入到資料庫中。
     */
    @Test
    fun clickInsertIntoDb_shoppingItemInsertedIntoDb() {
        //  創建一個 ShoppingViewModel 實例，並使用虛擬的 FakeShoppingRepositoryAndroidTest。
        val testViewModel = ShoppingViewModel(FakeShoppingRepositoryAndroidTest())
        //  啟動 AddShoppingItemFragment 並將其關聯的 ViewModel 設置為剛剛創建的 testViewModel。
        launchFragmentInHiltContainer<AddShoppingItemFragment>(fragmentFactory = fragmentFactory) {
            viewModel = testViewModel
        }
        //  使用 Espresso 測試庫，對購物項目名稱、數量和價格的 EditText 元件進行輸入。
        onView(withId(R.id.etShoppingItemName)).perform(replaceText("shopping Item"))
        onView(withId(R.id.etShoppingItemAmount)).perform(replaceText("5"))
        onView(withId(R.id.etShoppingItemPrice)).perform(replaceText("5.5"))
        //  點擊添加按鈕。
        onView(withId(R.id.btnAddShoppingItem)).perform(click())
        //  斷言檢查 testViewModel 中的 shoppingItems 是否包含剛剛插入的購物項目。
        assertThat(testViewModel.shoppingItems.getOrAwaitValue())
            .contains(ShoppingItem("shopping Item", 5, 5.5f, ""))
    }

    /**
     * 這個測試函式測試了當使用者按下返回按鈕時，是否將片段退回到前一個片段。
     * 它是對單一功能的測試，並沒有涉及多個系統元件之間的互動。
     */
    @Test
    fun pressBackButton_popBackStack() {
        //  使用 Mockito 創建一個假的 NavController。
        val navController = mock(NavController::class.java)
        //  啟動 AddShoppingItemFragment 並將 NavController 設置為其導航控制器。
        launchFragmentInHiltContainer<AddShoppingItemFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
        //  模擬按下返回按鈕。
        pressBack()
        //  驗證確保 navController 已調用 popBackStack()。
        verify(navController).popBackStack()
    }
}