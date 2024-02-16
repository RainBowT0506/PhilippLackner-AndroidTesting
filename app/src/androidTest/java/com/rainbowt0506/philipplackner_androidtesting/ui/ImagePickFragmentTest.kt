package com.rainbowt0506.philipplackner_androidtesting.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.rainbowt0506.philipplackner_androidtesting.launchFragmentInHiltContainer
import com.rainbowt0506.philipplackner_androidtesting.repositories.FakeShoppingRepositoryAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import javax.inject.Inject
import com.rainbowt0506.philipplackner_androidtesting.R
import com.rainbowt0506.philipplackner_androidtesting.adapter.ImageAdapter
import com.rainbowt0506.philipplackner_androidtesting.util.getOrAwaitValue
import org.junit.Rule
import org.mockito.Mockito.verify

@HiltAndroidTest
@MediumTest
@ExperimentalCoroutinesApi
class ImagePickFragmentTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory

    @Before
    fun setup() {
        hiltRule.inject()
    }

    /**
     * 使用者點擊圖片後應該返回上一個片段並設置圖片的 URL。
     */
    @Test
    fun clickImage_popBackStackAndSetImageUrl() {
        //  創建一個假的 NavController。
        val navController = mock(NavController::class.java)
        //  定義圖片的 URL。
        val imageUrl = "TEST"
        //  創建一個 ShoppingViewModel 實例，並使用虛擬的 FakeShoppingRepositoryAndroidTest。
        val testViewModel = ShoppingViewModel(FakeShoppingRepositoryAndroidTest())

        //  啟動 ImagePickFragment 並將 NavController 設置為其導航控制器。
        //  將圖片 URL 設置到 imageAdapter 中。
        launchFragmentInHiltContainer<ImagePickFragment>(fragmentFactory = fragmentFactory) {
            Navigation.setViewNavController(requireView(), navController)
            imageAdapter.images = listOf(imageUrl)
            viewModel = testViewModel
        }

        //  在 RecyclerView 中點擊第一個圖片項目。
        onView(withId(R.id.rvImages)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageAdapter.ImageViewHolder>(0, click())
        )

        //  驗證確保 navController 已調用 popBackStack()。
        verify(navController).popBackStack()

        //  斷言檢查 testViewModel 中的 curImageUrl 是否等於設置的圖片 URL。
        assertThat(testViewModel.curImageUrl.getOrAwaitValue()).isEqualTo(imageUrl)
    }
}