實作影片：[Android Testing](https://www.youtube.com/playlist?list=PLQkwcJG4YTCSYJ13G4kVIJ10X5zisB2Lq)
Github：[PhilippLackner-AndroidTesting](https://github.com/RainBowT0506/PhilippLackner-AndroidTesting)


# Why Do We Test Our Code?
## 什麼是測試，為什麼我們要寫它們？
- 測試是檢測我們程式碼的過程，以確保它們按照預期運作。
- 手動測試存在一些問題，包括時間成本和僅檢測錯誤一次的限制。
- JUnit 是一個流行的測試框架，可以自動化測試過程，使得測試更有效率。

## 單元測試
- 單元測試檢驗單一組件，例如函數，並且速度快，通常在幾毫秒內完成。
- 單元測試應該佔到測試案例的大部分，約 70%。

## 整合測試
- 整合測試檢驗不同組件如何協同工作，例如 fragment 與 viewmodel 之間的互動。
- 整合測試應該佔到測試案例的約 20%。

## 使用者介面測試
- 使用者介面測試 (UI Tests) 測試整個應用程式的交互過程，例如使用者登入、主畫面導航等。
- UI 測試確保使用者介面擁有我們預期的狀態，必須在 Android 模擬器上運行。

## 本系列將涵蓋的內容
- 本系列將涵蓋單元測試和整合測試，部分 UI 測試也會包含在內。
- 將介紹如何撰寫良好的測試案例和測試驅動開發 (Test Driven Development, TDD)。
- 從基本概念開始，逐步學習如何使用 JUnit 撰寫單元測試。
- 最終將透過一個實際的 MVVM Android 專案展示如何應用測試案例和 TDD。

# How to Write Good Tests
## 測試驅動開發 (Test Driven Development)
- TDD 是一種開發風格，強調測試的重要性。
- TDD 的主要原則是在撰寫實際功能實現之前先撰寫測試案例。
- 這僅適用於單元測試，而不是整合或使用者介面測試。
- 流程包括思考函數簽名、撰寫測試案例以及實現功能。

## 什麼是良好的測試？（What makes a good test?）
- 測試案例的特性包括範圍、速度和忠實度。
- 範圍表示測試案例涵蓋的程式碼範圍。
- 速度表示測試案例運行的快慢，速度越快越容易執行並發現問題。
- 忠實度表示測試案例與真實情況的相似程度。

## 應該寫多少個測試案例？（How many test cases should you write?）
- 測試案例的數量應該盡可能少，但同時足夠涵蓋程式碼路徑。
- 使用等價類別的概念來確定測試案例數量，等價類別指的是具有相似行為的輸入集合。

# Writing Our First Unit Tests
## Android Studio Unit Test 基礎介紹
- 介紹了建立空的 Android Studio 專案，並引入了 JUnit 和 Espresso 測試庫，以及新增了 Google 的 Truth 库，用於撰寫更可讀的斷言。
- 解釋了在 Gradle 中 testImplementation 和 androidTestImplementation 的區別，以及對應的資料夾結構（test 和 androidTest）。
- 提及了如何從 IDE 中生成測試類和選擇所屬的資料夾。
- 強調了測試在 Android 開發中的重要性，特別是使用 Test Driven Development (TDD) 的方法論。

## 撰寫 Unit Test
- 演示了如何創建測試類和編寫測試函數。
- 解釋了如何使用 Truth 库進行斷言，使測試代碼更易讀。
- 示範了如何運行單個測試和所有測試。
- 強調了在開發過程中先編寫測試用例的重要性，並提供了對於 TDD 方法的理解。
- 提供了一些測試的作業，包括實現 Fibonacci 函數和檢查括號配對的函數並寫測試用例來驗證。



## Android 元件測試：介紹

- 影片介紹如何測試 Android 元件，特別聚焦於測試使用 context 的函數。透過編寫一個函數，該函數接受 context 作為參數，並示範如何進行測試。
- 強調測試 Android 特有功能的重要性，並討論在 JUnit 中使用 `@Before` 與 `@After` 注解進行設定和拆卸操作。
- 討論先前有關 Fibonacci 函數和檢查括號函數的作業解答，指出兩者需要的修正。

## 了解 Android 測試中的 Context

- Context: 指的是 Android 應用程式的環境，提供對資源、系統服務等的訪問。
- JUnit 注解: 使用 `@Before` 與 `@After` 注解進行 JUnit 測試中的設定和拆卸操作。
- Resource Comparer 類別: 創建一個用於比較資源中的字串與提供的字串的類別，使用 context 物件。
- JUnit 測試目錄: Android 測試案例放置在 `androidTest` 目錄中，以訪問 Android 特有元件，如 context。
- 全域變數 vs. 區域實例: 影片演示了使用全域變數與創建區域實例對測試對象的影響。

## 測試案例實作與最佳實踐

- JUnit 測試案例: 測試案例使用注解和有意義的命名慣例進行結構化。
- 獨立測試案例: 測試案例必須能夠獨立運行，以避免不穩定性。
- 設定和拆卸函數: `@Before` 與 `@After` 注解支持在測試案例執行之前和之後執行的操作。
- 避免樣板代碼: 利用設定函數減少在每個測試案例中重複初始化代碼的需求。
- 理解測試套件執行: JUnit確保每個測試案例在受控的環境中執行，保持獨立性和可靠性。

# Setting up Project & Room DB
## 影片介紹與學習目標

- 影片開頭介紹了將學習如何測試 Android 元件，並且強調將會建立一個實際的 Android 專案，應用測試驅動開發（TDD）原則。
- 聲明影片的重點是實踐中的應用，而不僅僅是理論的介紹，並且提醒觀眾需具備一定的 Android 開發基礎。
- 演講者承諾在系列中將介紹如何測試常見的 Android 元件，例如 LiveData、Coroutines、MVVM 架構、Retrofit 和 Room 等。

## 測試案例實作與最佳實踐

- JUnit 測試案例：影片指出會介紹如何使用 JUnit 撰寫測試案例，並著重於結構化的命名慣例和注解的使用。
- 獨立測試案例：強調每個測試案例的獨立性和可靠性，並且提醒觀眾在測試設計中要注意這一點。
- 設定和拆卸函數：介紹了 `@Before` 和 `@After` 注解，在測試執行前後進行必要的設置和拆卸操作。

## 開始建立實際專案

- 影片提到了建立一個實際的 Android 專案，並解釋了將要建立的應用是一個進階版的購物清單應用，包含了 Room、Retrofit、MVVM 等常見的 Android 元件。
- 演講者鼓勵觀眾從 GitHub 下載專案，並且解釋了專案中使用的各種庫和依賴。
- 提到未來將會建立 Room 資料庫並進行測試，並且將在接下來的影片中進行具體實作。



# Testing Room Databases
## 房間數據庫測試設置
![Test Sizes.html](https://hackmd.io/_uploads/Hk78SR49p.png)

- 介紹測試目標：作者開始介紹進行房間數據庫測試的計劃，並討論了測試的類型（本地單元測試 vs. 工具測試）。
- 介紹測試類型：作者解釋了為什麼這些測試應該是工具測試，因為它們需要訪問 Android 元件。
- 測試類結構：展示了測試類的結構，並討論了一些重要的 JUnit 注解，例如 `@RunWith` 和 `@SmallTest`。
- 設置測試環境：作者討論了為測試準備數據庫的方法，並介紹了 `runBlockingTest` 函數以及 `InstantTaskExecutorRule`。

## 測試數據庫功能

- 測試插入功能：作者展示了如何測試 `insert` 功能，並解釋了如何使用 `runBlockingTest` 和 `InstantTaskExecutorRule`。
- 測試刪除功能：作者展示了如何測試 `delete` 功能，並討論了遇到的一些問題和解決方法。
- 測試總價格功能：作者解釋了如何測試計算總價格的功能，並展示了在測試中如何使用各種測試工具和技巧。

# Retrofit & Dagger-Hilt Setup
## 概述
- 在這個視頻中，作者將設置 Retrofit 與 Pixabay API 以及 Dagger Hilt。
- 建議觀眾事先了解 Retrofit 與 Dagger Hilt 的使用方法，因為作者不會深入解釋這些工具的細節。

## 獲取 Pixabay API 金鑰
- 首先，觀眾需要在 Pixabay 網站上創建帳戶以獲取 API 金鑰。
- 作者建議觀眾登錄 Pixabay 網站，然後轉到 API 頁面以獲取金鑰。

## 保護 API 金鑰
- 作者提到 API 金鑰應該儘可能地保護。
- 在這個例子中，作者將 API 金鑰存儲在 gradle.properties 文件中，這樣可以避免將金鑰暴露在程式碼庫中。
- 儘管 gradle.properties 文件可以在版本控制系統中忽略，但仍建議使用 ProGuard 來保護金鑰。

## 定義 API 接口
- 使用 Retrofit 之前，需要定義與 API 交互的接口。
- 在 Pixabay API 接口中，作者定義了一個用於搜索圖片的 suspend 函數。
- 作者提到了使用 Postman 等工具來模擬 API 請求並查看響應的方法，以方便創建相應的 Kotlin 類。

## Dagger Hilt 設置
- Dagger Hilt 需要先創建一個應用程序類並將其註解為 `@HiltAndroidApp`。
- 在 Dagger Hilt 中，需要創建一個模塊來提供依賴項。
- 在模塊中，作者定義了提供 Room 數據庫和 Retrofit 實例的函數。
- 使用 `@InstallIn` 標註將模塊安裝到應用程序組件中。

## 應用模塊的設置
- 在 Gradle 中，需要添加依賴項和 Retrofit 實例。
- Retrofit 實例需要設置基本 URL 和轉換器工廠。

## 總結
- 作者強調，不是每個視頻都專注於測試本身，有時需要構建應用程序。
- 觀眾通過觀看整個系列視頻將學習如何在實際項目中應用測試原則。

# Creating a Fake Repository for Testing
## 概要介紹與目標設定：
- 這段影片是關於建立存儲庫（Repository）的設定。
- 存儲庫包含本地數據庫和遠程數據源（Pixabay API）。
- 測試的重要性被強調，並解釋了為什麼在測試中不應該進行實際的網絡調用。
- 引入了測試替身（test doubles）的概念，其中包括Fake和Mock。

## 實現真實存儲庫：
- 創建了一個名為"Resource"的類，用於錯誤處理、加載處理和成功狀態處理。
- 創建了"DefaultShoppingRepository"類來實現存儲庫，使用了Room數據庫和Pixabay API。
- 引入了界面（interface），定義了存儲庫應該具有的功能。

## 創建Fake存儲庫用於測試：
- 創建了"FakeShoppingRepository"類，用於模擬存儲庫的行為，並實現了與真實存儲庫相同的界面。
- Fake存儲庫使用了一個簡單的列表來模擬數據庫，並具有設置是否返回網絡錯誤的功能。

# Architectural Skeleton
## 創建 UI 片段：
- 將主活動（MainActivity）移到名為 "ui" 的新包中，並創建三個片段：Shopping Fragment、Add Shopping Item Fragment 和 Image Pick Fragment。
- 在 Shopping Fragment 中，使用的佈局是 fragment_shopping。
- 在 Add Shopping Item Fragment 中，使用的佈局是 fragment_add_shopping_item。
- 在 Image Pick Fragment 中，使用的佈局是 fragment_image_pick。

## 創建 View Model：
- 在 "ui" 包中，創建一個名為 ShoppingViewModel 的 Kotlin 類別，它繼承自 ViewModel。
- 使用 Dagger Hilt 的 `@ViewModelInject` 注解將 Repository 注入到 View Model 中。
- 創建一個用於測試的 Event 類別，用於將 LiveData 事件轉換為一次性事件。

## 定義 LiveData 對象和函數：
- 在 ShoppingViewModel 中定義多個 LiveData 對象，包括 `shoppingItems`、`totalPrice`、`images`、`currentImageUrl` 和 `insertShoppingItemStatus`。
- 實現 `setCurrentImageUrl` 函數，用於將新的圖片 URL 發佈到 LiveData 中。
- 實現 `deleteShoppingItem` 函數，使用 Repository 來刪除購物項目。
- 實現 `insertShoppingItemIntoDb` 函數，使用 Repository 來將購物項目插入到資料庫。
- 實現 `insertShoppingItem` 函數，進行用戶輸入的驗證，然後將購物項目插入到資料庫。
- 實現 `searchForImage` 函數，用於從 Pixabay API 中搜尋圖片。

## 創建 Constants 文件：
- 創建名為 Constants 的 Kotlin 檔案，定義 `MAX_NAME_LENGTH` 和 `MAX_PRICE_LENGTH` 兩個常數，用於限制購物項目名稱和價格的最大字符數。

## 在 AppModule 中提供 Repository：
- 在 Dagger Hilt 的 AppModule 中，使用 `@Provides` 注解提供 `DefaultShoppingRepository`，並將其轉換為 `ShoppingRepository` 介面。

# Testing ViewModels
## 測試 View Model：
- 影片開始提到將進行對購物 View Model 進行測試，並教學如何進行測試。
- 示範右鍵點擊購物 View Model 類別，選擇 "generate"，再選擇 "test" 以生成測試類別。
- 使用 JUnit 4 進行測試，並確保在 test 資料夾中進行測試，因為 View Model 是一個普通的類別，不是 Android 元件。

## 測試案例與設置：
- 創建私有屬性 `viewModel`，型態為 `ShoppingViewModel`。
- 在 `@Before` 函數中初始化 `viewModel`，同時使用假的 `ShoppingRepository` 進行測試，因為不想在測試中進行實際的 API 請求或資料庫操作。

## 第一個測試案例：
- 第一個測試案例是檢查插入購物項目時，如果有欄位為空，是否正確返回錯誤訊息。
- 使用 JUnit 4 的 Truth library 進行斷言。
- 進行插入操作，等待 LiveData 發送事件，確認是否收到預期的錯誤訊息。

## 其他測試案例：
- 每個測試案例都針對插入購物項目的不同情境，包括名稱過長、價格過長、數量過高等。
- 針對各種情境斷言是否收到正確的錯誤訊息。
- 最後的測試案例是確保插入有效的購物項目時，是否收到成功的狀態。

## 測試中的問題：
- 在測試過程中發現一個問題，即無法使用 `InstantTaskExecutorRule`，因為在測試中使用 `coroutineScope` 會出現問題。
- 為了解決這個問題，需要創建一個自定義的 `MainCoroutineRule`，以在測試中使用適當的 `CoroutineDispatcher`。



 

 





# Testing with Dagger-Hilt
## Hilt 的使用需求：
- 測試案例數量增加時，手動初始化測試對象會變得冗長且難以管理。
- Hilt 可以在應用程式模組中集中定義數據庫，並注入到需要的測試類別中，從而減少重複的程式碼。
## Hilt 的設置步驟：
1. 在 `build.gradle` 檔案中新增 Hilt 相關的依賴。
2. 創建自定義的測試運行器 `HiltTestRunner`，並在其中使用 Hilt 測試應用程式類別 `HiltTestApplication`。
3. 在測試套件中創建測試專用的應用程式模組 `TestAppModule`，並在其中定義測試所需的依賴。
4. 使用 `@HiltAndroidTest` 注解標記測試類別，並在其中使用 `@Inject` 注解來進行依賴注入。
5. 在測試類別中使用 `@get:Rule` 標記 Hilt 的規則，以便進行依賴注入。
## 測試流程與設置：
- 為了解決 Hilt 無法注入測試類別中的依賴的問題，需要設置自定義的 Hilt 規則。
- 使用 Hilt 規則進行依賴注入後，可以簡化測試類別的設置並減少重複的程式碼。
- 測試運行器和應用程式模組的設置使得測試案例可以獲得所需的依賴對象，從而進行有效的測試。
 
 

# Testing Fragments with Dagger-Hilt
## Dagger-Hilt 與測試

- Dagger-Hilt 是一個依賴注入框架，可以幫助我們管理應用程式中的依賴關係。
- 在測試中，我們通常需要注入假的依賴以模擬真實環境中的情況。
- 使用 Dagger-Hilt 可以幫助我們在測試中輕鬆地注入這些假的依賴。

## Fragment 測試的挑戰

- 在測試 Fragment 時，通常我們使用 Fragment Scenario，在一個空的 Activity 中啟動要測試的 Fragment。
- 然而，使用 Dagger-Hilt 時，這種方法並不直接適用，因為需要將 Fragment 所在的 Activity 標記為 `@AndroidEntryPoint`，而 Fragment Scenario 啟動的 Activity 是一個空的 Activity，缺少這個標記。
- 這導致了在使用 Dagger-Hilt 時無法正常執行 Fragment 測試。

## 解決方案

- 我們介紹了一種從 Google 的架構範例中提取的解決方案，即手動啟動一個自定義的 Activity 並將 Fragment 附加到該 Activity 上。
- 為了實現這個解決方案，我們需要創建一個自定義的 Activity，並將其標記為 `@AndroidEntryPoint`。
- 我們還需要在測試模組中添加相應的依賴，以及創建一個 debug 的 source set 來包含測試所需的相關代碼和清單文件。

## 實現細節

- 在代碼中，我們使用了 Kotlin 的一些特性，如 inline 函數和 lambda 表達式，來提高效率和清晰度。
- 我們設計了一個名為 `launchFragmentInHiltContainer` 的函數，用於將 Fragment 附加到 Dagger-Hilt 的容器中進行測試。
- 函數內部包含了創建 Activity Intent、啟動 Activity Scenario、附加 Fragment Factory、創建並附加 Fragment 等步驟。
- 通過這種方式，我們可以有效地在測試中使用 Dagger-Hilt 來注入 Fragment 的依賴。

## 測試案例

- 我們提供了一個測試案例 `testLaunchFragmentInHiltContainer`，用於驗證 `launchFragmentInHiltContainer` 函數是否正常工作。
- 在測試中，我們啟動了一個假的 Shopping Fragment，並確保測試通過以驗證 Dagger-Hilt 的整合是否成功。

## 筆記
記得要新增 Debug 路徑與正確的路徑。
新增 Debug 的 `AndroidManifest.xml`
 
# Testing Navigation with Mockito & Espresso
## 開頭介紹與概述：
- 作者歡迎觀眾回來觀看新的影片，並提到前一個影片中設置了一個名為 "launch fragment in hilt container" 的功能，允許在空的活動環境中測試片段。
- 提到在本影片中將開始利用這一功能來測試導航，並解釋在集成測試中，先定義函數簽名、然後是測試案例、最後是實現功能的順序。
## 建立導航圖：
- 在 res 資料夾中建立新的 Android 資源文件，命名為 "nav graph"，並添加三個片段：shopping fragment、add shopping item fragment 和 image pick fragment。
- 定義從 shopping fragment 到 add shopping item fragment 的過渡，以及從 add shopping item fragment 到 image pick fragment 的過渡。
## 配置導航宿主：
- 在 MainActivity 的 XML 文件中，設置導航宿主為 nav graph，確保將其設置為默認的導航宿主。
## 處理導航行為：
- 定義點擊浮動操作按鈕時從 shopping fragment 到 add shopping item fragment 的導航行為。
- 定義點擊圖片選擇視圖時從 add shopping item fragment 到 image pick fragment 的導航行為。
- 處理返回按鈕在 add shopping item fragment 中的行為，重置當前圖片 URL，並將返回堆棧返回到 shopping fragment。
## 測試案例撰寫：
- 撰寫測試案例來驗證從 shopping fragment 到 add shopping item fragment 的導航行為。
- 撰寫測試案例來驗證從 add shopping item fragment 返回到 shopping fragment 的導航行為。
 
 



# Test Image Picking
## 開發目標
- 實作在 Image Pick Fragment 中選擇圖片的功能。
- 測試點擊圖片後是否成功返回 Add Shopping Item Fragment，並且檢查 ViewModel 中的圖片 URL 是否正確。

## 創建 Image Adapter 用於 RecyclerView 顯示選擇的圖片
- 使用 Glide 進行圖片載入。
- Dagger 進行依賴注入。
- 實現 RecyclerView 的 ViewHolder，使用 List Differ 提升效能。

## 創建 Fragment Factory
- 為了能夠在 Fragment 中進行構造函數注入，建立了 Fragment Factory，用於創建各種 Fragment。

## 在 Image Pick Fragment 中設置 RecyclerView 與 Click 監聽
- 使用 Dagger 注入 Image Adapter。
- 設置 RecyclerView 的 Adapter 與 Layout Manager，使圖片以網格形式顯示。
- 設置圖片點擊的監聽器，點擊後返回 Add Shopping Item Fragment 並設置 ViewModel 中的圖片 URL。

## 撰寫測試案例目標與設定
- 目標是測試點擊圖片後是否正確執行兩個動作：返回前一畫面（pop the backstack）並在 ViewModel 中設置相對應的圖片 URL。
- 使用 Mockito 模擬 NavController，以驗證是否正確呼叫 `pop backstack` 函數。
- 透過 Espresso UI 測試庫模擬點擊 RecyclerView 中的項目。

## 模擬 RecyclerView 點擊與設定動作
- 使用 `RecyclerViewActions.actionOnItemAtPosition` 函數進行 RecyclerView 中項目的點擊模擬。
- 在測試之前，手動向 RecyclerView 中插入一個項目，以便後續確認點擊項目的效果。

## 禁用動畫以確保穩定性
- 由於 Espresso 測試庫速度較快，且 RecyclerView 可能預設使用動畫，為了確保測試的穩定性，需要在測試前禁用動畫。
- 透過 ADB 命令在模擬器中禁用不同動畫類型，包括 window、transition 和 animator 動畫。

window
```
adb -s emulator-5554 shell settings put global window_animation_scale 0
```

transition
```
adb -s emulator-5554 shell settings put global transition_animation_scale 0
```
animator
```
adb -s emulator-5554 shell settings put global animator_duration_scale 0
```

Manual Turn Off
[How to Turn Off Animations on Your Android Device](https://www.youtube.com/watch?v=VZK7J73uzCg&ab_channel=a2ztubeYoutubeGuide)

## 測試 ViewModel 中的資料設定
- 創建測試 ViewModel，使用假的資料存取類別，這允許我們在測試中處理 ViewModel 中的資料。
- 在測試過程中，確認 ViewModel 中的當前圖片 URL 是否與預期的圖片 URL 一致。

## 使用 Hilt 進行依賴注入
- 使用 Hilt 測試規則 (`@get:Rule`) 和 `HiltAndroidRule`，並將 Fragment Factory 注入到測試中，以支援 Hilt 依賴注入。
- 使用 `@Inject` 注解將相關依賴注入到測試中，例如 NavController 和 ViewModel。

## 設定 InstantTaskExecutorRule
- 由於測試中使用 LiveData，需要添加 `InstantTaskExecutorRule` 以確保 LiveData 在主執行緒上立即執行，避免測試結果不一致。

## 執行與驗證測試
- 執行測試並確認是否成功通過。
- 使用 Truth 庫的 `assertThat` 函數驗證 ViewModel 中的圖片 URL 是否如預期一致。
- 檢視測試結果，確保導覽正確執行並且 ViewModel 資料正確設置。

## 擴充與後續
- 在測試中發現後續可能的擴充點，例如其他 UI 行為或邏輯的測試。
- 考慮針對不同情境編寫更多測試，確保應用程式功能的全面性。
 

## 測試補充
- 使用 Espresso 進行 UI 測試，模擬點擊 RecyclerView 中的特定位置。
- 使用 Mockito 驗證是否成功調用 NavController 的 popBackStack 方法。
- 使用 Truth 斷言檢查 ViewModel 中的圖片 URL 是否符合預期。

# Test Addition of Shopping Items
## 功能測試目標：
- 測試在 `add shopping item fragment` 中，是否可以成功輸入文字並將項目插入數據庫。
- 測試結果包括確認項目是否被正確插入數據庫並顯示在購物清單中。

## 依賴注入與設置：
- 使用 Hilt 依賴注入框架，將 Glide 實例注入到 `add shopping item fragment` 和其對應的工廠中。
- 使用 Glide 載入圖片 URL 到 `add shopping item fragment` 的 ImageView 中。

## 訂閱 ViewModel 觀察者：
- 在 `add shopping item fragment` 中，訂閱 ViewModel 的當前圖片 URL 和插入項目狀態的觀察者。
- 當 ViewModel 中的狀態發生變化時，更新相應的 UI 元素或採取相應的操作。

## UI 事件監聽與操作：
- 添加按鈕點擊事件的監聽器，當用戶點擊時，將輸入的項目信息插入到數據庫中。
- 使用 Espresso 測試庫模擬用戶輸入並點擊按鈕的操作，並確認是否成功插入數據庫。

## 測試用例設計：
- 設計測試用例，驗證點擊插入按鈕後，項目是否成功插入數據庫並在購物清單中顯示。
- 使用 Truth 庫進行斷言，確認 ViewModel 中的資料是否包含新插入的項目。
 

# Test Swipe to Delete Functionality
## 刪除購物項目功能介紹：
- 這段視頻主要介紹了在應用中如何實現刪除購物項目的功能，使用戶可以在 RecyclerView 中滑動刪除購物項目，並提供撤銷刪除功能。

## 代碼結構說明：
- 將購物項目適配器 `ShoppingItemAdapter` 添加到應用中，並設置相應的 RecyclerView。
- 實現了 `ItemTouchHelper.SimpleCallback` 接口，以支持滑動刪除功能。
- 使用 Espresso 測試庫模擬用戶在 RecyclerView 中滑動刪除操作，並進行測試驗證。

## ViewModel 設置與監聽：
- 在 Fragment 中訂閱 ViewModel 的購物項目列表和總價格變化，並相應地更新 UI。
- 使用 LiveData 觀察者模式監聽資料變化，並在 UI 上及時更新。

## 自定義 Fragment Factory：
- 為了測試目的，創建了自定義的 Fragment Factory，用於在測試情境中提供虛擬的 ViewModel 和假資料庫。
- 在測試情境中，使用 Fake Repository 和 Test ViewModel 進行測試，而在實際情境中則使用真實的 Repository 和 ViewModel。

 
 
# Class 功能介紹
## launchFragmentInHiltContainer
這段文字和程式碼片段描述了一個名為 `launchFragmentInHiltContainer` 的功能，它是用於在 Dagger Hilt 容器中啟動並測試 Fragment 的工具函數。以下是對這段文字和程式碼的解釋：

1. 功能目的和流程說明：
- `launchFragmentInHiltContainer` 函數的目的是將要測試的 Fragment 附加到自定義的 Hilt Activity 中，以便進行測試。
- 首先，我們定義了一個 Intent，該 Intent 用於將自定義的 HiltTestActivity 設置為主要活動，並指定了主題資源 ID。
- 接著，我們使用 `ActivityScenario.launch` 啟動了這個自定義的 HiltTestActivity，並在啟動後的回調函數中進行後續操作。

2. Fragment Factory 與 Fragment 實例化：
- 在啟動 Activity 後，我們檢查是否提供了 FragmentFactory，如果有，則將其設置給 Activity 的 FragmentManager。
- 然後，我們使用 FragmentFactory 創建了要測試的 Fragment 實例，並設置了其參數。
- 接著，我們使用 FragmentTransaction 將 Fragment 添加到 Activity 的佈局中。

3. 執行 Action Lambda 函數：
- 在添加 Fragment 到佈局後，我們調用了 Action Lambda 函數，這個函數可以在測試中執行所需的操作。例如，進行 UI 操作、檢查 Fragment 的狀態等等。

這個函數的設計和實現讓開發者可以方便地在測試中使用 Dagger Hilt 來注入 Fragment 的依賴，並對其進行測試操作。這樣的設計提高了測試的靈活性和可靠性，使得測試更加簡單和有效。


# 問題
## Testing with Dagger-Hilt
在測試套件中使用 Hilt 時可能遇到的問題：Hilt 不知道應該注入哪個資料庫，因為在測試中同時有存取真實應用程式模組和測試專用應用程式模組。這種情況下，Hilt 無法確定是應該使用真實應用程式模組提供的資料庫，還是使用測試專用應用程式模組提供的資料庫。

為了解決這個問題，作者提到了一個簡單的解決方法：為依賴項目添加命名屬性。通過為依賴項目添加名稱，可以明確告訴 Hilt 在注入依賴時應該使用哪個資料庫。這樣，Hilt 就能夠根據設定來正確地注入依賴，從而解決了在測試中使用 Hilt 時可能出現的混淆依賴的問題。
 
## Testing Fragments with Dagger-Hilt
在這段文字中，作者討論了使用 Dagger Hilt 進行 Fragment 測試時的一些挑戰。以下是對這段文字的詳細解釋：

1. Testing Fragments with Dagger Hilt:
- 作者首先提到在使用 Dagger Hilt 進行 Fragment 測試時的一些挑戰。
  
2. Fragment Scenario vs. Dagger Hilt:
- 通常，在測試 Fragments 時，開發者使用所謂的 "Fragment Scenario"。這是一種在空的 Activity 中啟動要測試的 Fragment 的方法，而且相對簡單。

3. Challenges with Dagger Hilt and Fragment Scenario:
- 但是，使用 Dagger Hilt 時，這種方法不再直接適用。這是因為當我們使用 Dagger Hilt 與 Fragments 一起並希望將依賴注入到這些 Fragments 時，需要在 Fragments 上標記 `@AndroidEntryPoint`，這本身不是問題。

4. Annotation Requirements for Fragments and Activities:
- 作者指出，在使用 Dagger Hilt 進行 Fragment 測試時，不僅需要在 Fragments 上標記 `@AndroidEntryPoint`，還需要在這些 Fragments 所在的 Activity 上標記 `@AndroidEntryPoint`。這樣做是為了確保 Dagger Hilt 能夠正確地進行依賴注入。

5. Issue with Empty Activity in Fragment Scenario:
- 問題出在使用 Fragment Scenario 時，會啟動一個空的 Activity，而這個 Activity 是由一個庫提供的。由於這個空的 Activity 缺少 `@AndroidEntryPoint` 標記，這就導致了使用 Dagger Hilt 時的問題，可能導致應用程式崩潰。

6. Dagger Hilt Status:
- 作者提到 Dagger Hilt 目前仍處於 alpha 階段，這可能意味著一些問題和挑戰仍在積極解決中。未來版本可能會提供更簡便的解決方案。

總體而言，這段文字解釋了在使用 Dagger Hilt 進行 Fragment 測試時的技術挑戰，特別是在處理 Fragment Scenario 和依賴注入的情境下所遇到的問題。
## Test Swipe to Delete Functionality
在測試場景中使用測試 ViewModel 搭配假資料庫時遇到的困難。問題的核心在於在 Fragment 中訂閱 ViewModel 的資料後，即使在測試用例中將 ViewModel 設置為測試 ViewModel，更改也只會在所有生命週期函數調用之後生效。換句話說，在 Fragment 的 onViewCreated 函數中訂閱 ViewModel 的資料時，這些資料已經來自實際的 ViewModel，而不是測試 ViewModel，這導致測試無法準確地模擬預期行為。

為了解決這個問題，需要一種方法來在創建 Fragment 對象時將 ViewModel 傳遞給它。因此，作者提出了使用自定義 Fragment 工廠來實現這一目標。通過自定義 Fragment 工廠，可以在測試用例中實例化 Fragment 時指定所需的 ViewModel，從而確保在測試期間使用的是測試 ViewModel 而不是實際 ViewModel。

總的來說，問題的關鍵在於在測試場景中無法準確控制 Fragment 使用的 ViewModel，因此需要通過自定義 Fragment 工廠來解決這一問題，以便在測試期間使用測試 ViewModel。

如何解決在測試場景中使用測試 ViewModel 的問題？
首先在 ShoppingFragment 的構造函數中添加了一個名為 viewModel 的可選參數，類型為 ShoppingViewModel，並將其初始值設置為 null。這使得在創建 ShoppingFragment 對象時可以傳遞一個自定義的 ViewModel。
創建了一個名為 TestShoppingFragmentFactory 的自定義 Fragment 工廠，用於測試場景。在這個工廠中，為測試提供了一個假的資料庫（FakeShoppingRepositoryAndroidTest），並在創建 ShoppingFragment 時將其作為參數傳遞給 ViewModel。
對於真實的應用場景，作者使用了一個普通的 ShoppingFragmentFactory，並在其中創建了實際的資料庫。這確保了應用在測試和實際場景下的正常運行。


# 參考
[Test Sizes](https://testing.googleblog.com/2010/12/test-sizes.html)
[Pixabay](https://pixabay.com/)


# 關鍵字
- 測試：檢查程式碼功能的過程，以確保其正確性和可靠性。
- JUnit：Java 中用於測試的框架，可自動化測試流程。
- 單元測試：測試單一組件（如函數）的測試案例。
- 整合測試：檢驗不同組件如何協同工作的測試案例。
- 使用者介面測試：檢驗應用程式的使用者介面是否符合預期的測試案例。
- 測試驅動開發 (TDD)：一種軟體開發方法，先寫測試案例，然後再撰寫程式碼以滿足這些測試案例。
- MVVM：Model-View-ViewModel 的縮寫，一種軟體架構模式，常用於 Android 開發。
- Android 模擬器：用於在開發環境中模擬 Android 裝置的工具。
- 測試驅動開發 (TDD)：一種軟體開發方法，先撰寫測試案例，再撰寫程式碼以通過這些測試案例。
- 等價類別：具有相似行為的輸入集合，用於確定測試案例數量。
- 範圍、速度、忠實度：測試案例的特性，分別表示覆蓋程式碼範圍、運行速度和與真實情況的相似程度。
* JUnit: JUnit 是一個 Java 編程語言的單元測試框架，特別是用於測試單元程式碼和系統。
* Espresso: Espresso 是一個用於 Android UI 測試的測試框架，它提供了用於測試 UI 元素的 API。
* Truth 库: Google 的 Truth 是一個用於 Java 和 Android 測試的斷言庫，使測試代碼更易讀且可維護。
* Gradle: Gradle 是一個用於自動化建構工具，特別是用於 Android 開發中的構建和依賴管理。
* Test Driven Development (TDD): TDD 是一種軟體開發方法，要求在編寫實際代碼之前先寫測試用例。這有助於確保代碼的穩健性和可測試性。
* 單元測試: 單元測試是一種軟體測試方法，用於測試程式中的最小單元或模組是否正確運作。
* 測試用例: 測試用例是一組測試步驟、環境配置以及預期結果，用於確保軟體功能的正確性。
* 斷言: 斷言是測試用例中的一部分，用於確定實際結果是否符合預期結果。
* 測試驅動開發 (TDD): TDD 是一種軟體開發方法，要求在編寫實際代碼之前先寫測試用例。這有助於確保代碼的穩健性和可測試性。
- JUnit: Java 編程語言的單元測試框架。
- Context: Android 應用程式環境，提供對應用程式特定資源和元件的訪問。
- 注解: Java 代碼中提供有關程式碼行為的元資料的特殊標籤。
- 設定和拆卸: 在測試案例執行之前和之後執行的操作，用於建立受控的測試環境。
- 全域變數: 在程式的整個作用域內都可以訪問的變數。
- 區域實例: 在特定函數或作用域內創建的對象實例，限制了其可訪問性。
- 不穩定測試: 由於外部因素或依賴關係而產生不一致結果的測試。
- 樣板代碼: 在程序中多處重複出現的標準化代碼。
- 測試套件: 一組一起執行的測試案例，用於驗證程式或系統的行為。
- 測試驅動開發（TDD）：一種軟體開發方法論，其中測試案例的編寫在實際開發代碼之前進行，並且在整個開發週期中持續進行測試。
- JUnit：Java 程式語言的單元測試框架，用於編寫和執行測試案例。
- LiveData：Android 架構元件，用於在數據發生更改時通知觀察者。
- Coroutines：Kotlin 的非同步編程庫，用於處理異步任務。
- MVVM 架構：Model-View-ViewModel 架構模式，用於 Android 應用程式的開發，將 UI 邏輯與業務邏輯分離。
- Retrofit：Square 公司開發的 HTTP 客戶端庫，用於簡化與 RESTful Web 服務器的通信。
- Room：Android 的持久性庫，用於在 SQLite 數據庫上提供一個抽象層。
- GitHub：一個基於 Git 版本控制系統的程式碼托管平台，用於存儲和分享代碼庫。
- 依賴注入（Dependency Injection）：一種設計模式，用於降低軟體元件之間的耦合度，提高代碼的可測試性和可維護性。
- JUnit：Java 中常用的測試框架，用於編寫單元測試。
- 工具測試：需要 Android 元件的測試，例如測試房間數據庫。
- 本地單元測試：在 JVM 上運行的測試，不需要 Android 元件。
- runBlockingTest：Kotlin 中用於測試協程的函數，讓測試運行在同一線程上。
- InstantTaskExecutorRule：JUnit 中的規則，用於確保 LiveData 在測試中正確執行。
- LiveData：Android Architecture Components 中的類，用於在數據更改時通知觀察者。
- 測試金字塔：一種測試策略，包括單元測試、集成測試和 UI 測試。
- Dao（Data Access Object）：用於訪問數據庫的接口或類。
- SQLite：Android 中的輕量級關係型數據庫。
- Coroutine（協程）：Kotlin 中的一種低成本、高效的非阻塞異步編程方式。
- Retrofit: 一個用於 Android 和 Java 的類型安全的 HTTP 客戶端，用於簡化與 RESTful API 的通信。
- Dagger Hilt: 一個用於 Android 的依賴注入庫，可以幫助開發人員更容易地管理應用程序中的依賴關係。
- Pixabay API: Pixabay 提供的免費圖片庫 API，用於在應用程序中搜索和獲取圖片。
- API 金鑰: 一個用於識別和驗證對 API 的訪問權限的唯一密鑰。
- Gradle: 一個用於自動化構建、測試和部署軟件的開源構建自動化工具。
- Postman: 一個用於測試 API 的流行工具，可以發送 HTTP 請求並查看響應。
* Repository (存儲庫)：用於管理資料源的類別，負責處理資料存取和操作，通常將本地資料庫和遠端資料源整合起來。
* 測試雙 (Test Double)：在軟體測試中使用的替代物件，例如 Fake、Mock、Stub 等，用於模擬真實環境中的物件以進行測試。
* Fake (模擬物件)：測試雙的一種類型，用於模擬真實物件的行為，但不是真正的物件。用於測試環境中，以提高測試效率和控制測試狀態。
* Mock (模擬物件)：另一種測試雙類型，用於記錄物件的行為以供測試驗證。通常用於模擬外部相依性的行為。
* 介面 (Interface)：在物件導向程式設計中，一種定義類別方法和屬性的抽象類型。介面只定義方法的簽名，但不提供方法的實現。
- Dagger Hilt（依賴注入框架）：Dagger Hilt 是一個由 Google 開發的 Android 依賴注入框架，用於管理應用程式中各個模組之間的依賴關係。在這裡，它被用來注入 Repository 到 View Model 中。
- ViewModelInject：`@ViewModelInject` 是 Dagger Hilt 中的一個注解，用於標記 View Model 的構造函數，以實現依賴注入。這樣可以使 View Model 能夠獲取所需的 Repository 實例。
- LiveData：LiveData 是 Android 架構組件之一，用於在應用程式的不同組件之間共享數據。在這裡，它被用來觀察資料庫的變化，並通知 UI 更新。
- Event（事件）：在這裡，Event 是一個自定義的類別，用於將 LiveData 的事件轉換為一次性事件，防止事件在配置更改時被重新發送。
- Repository（資料庫操作）：Repository 是一個用於協調應用程式的資料操作的類別。在這裡，它是用於處理與資料庫和 Pixabay API 之間的交互。
- Dagger AppModule（Dagger 應用程式模組）：Dagger AppModule 是 Dagger Hilt 中的一個模組，用於提供應用程式中的所有依賴項。在這裡，它被用來提供 Repository 的實例。
- TDD（測試驅動開發）：TDD 是一種開發方法論，其中先撰寫測試案例，然後實現足以使這些測試案例通過的功能。在這裡，指的是先創建 View Model 的測試案例，然後實現 View Model 的相關功能。
- JUnit 4：JUnit 4 是 Java 語言中常用的測試框架，用於編寫單元測試。在這裡，使用 JUnit 4 進行對購物 View Model 的功能進行測試。
- Truth library：Truth library 是 Google 提供的斷言庫，用於撰寫更具可讀性和表達力的斷言。在這裡，用 Truth library 進行斷言，取代 JUnit 的斷言。
- ViewModel：ViewModel 是 Android 架構組件之一，用於存儲和管理與 UI 相關的數據。在這裡，測試購物 View Model，確保其正確性。
- Coroutines：Coroutines 是 Kotlin 語言中的非同步編程框架，用於簡化並發編程。在這裡，使用 Coroutines 進行非同步操作的測試。
- Dispatcher：在 Kotlin 的 Coroutines 中，Dispatcher 是用於指定協程運行的線程或線程池。在這裡，提到使用自定義的 `MainCoroutineRule` 以解決在測試中使用 `coroutineScope` 的問題。
- LiveData：LiveData 是 Android 架構組件之一，用於在應用程式的不同組件之間共享數據。在這裡，用 LiveData 來觀察資料的變化，並進行測試。
- Test Coroutine Dispatcher：在 Kotlin 的 Coroutines 中，Test Coroutine Dispatcher 是一種用於測試的特殊 Dispatcher，用於模擬非同步操作。在這裡，使用 Test Coroutine Dispatcher 來解決在測試中使用 `coroutineScope` 的問題。
- Hilt (Dagger-Hilt)：Dagger-Hilt 是一個由 Google 開發的用於 Android 應用程式的依賴注入框架，它基於 Dagger 2 並提供更簡單的使用方式和更好的性能。
- 依賴注入 (Dependency Injection)：一種設計模式，用於將一個類別的依賴關係從該類別中解耦，使得類別更加靈活、可測試和可維護。
- 測試套件 (Test Suite)：在軟體開發中，測試套件是一組相關的測試案例，用於驗證軟體功能的正確性和穩定性。
- 測試運行器 (Test Runner)：在測試過程中負責執行測試案例的程式組件，通常會提供測試環境的初始化和清理功能。
- 注解 (Annotation)：在 Java 和 Kotlin 中，注解是一種元數據，可以提供額外的信息給編譯器、解析器或運行時系統。
- 規則 (Rule)：在測試中，規則是一種用於管理測試過程中的行為和環境的機制，可以在測試開始和結束時執行特定的操作。
- 模組 (Module)：在 Dagger-Hilt 中，模組是用於定義依賴對象的容器，可以將相關的依賴關係集中管理起來。
- 單例 (Singleton)：在設計模式中，單例是一種只允許類別生成唯一一個實例的模式，可以全局共享這個實例對象。
- 測試驅動開發 (Test-Driven Development, TDD)：一種軟體開發方法論，要求在編寫程式碼之前先寫測試案例，從而保證程式碼的正確性和穩定性。
* Dagger-Hilt: Dagger-Hilt 是一個用於管理 Android 應用程序中依賴關係的框架，它基於 Dagger 框架，提供了更簡單的 API 以及更容易使用的方式來實現依賴注入。
* Fragment Scenario: Fragment Scenario 是 Android 測試庫中的工具，用於在測試中操作和測試 Fragment。它讓開發人員可以模擬 Fragment 的行為和交互，進行測試。
* @AndroidEntryPoint: `@AndroidEntryPoint` 是 Dagger-Hilt 提供的註釋，用於標記 Android 組件，以指示 Dagger-Hilt 在這些組件中進行依賴注入。
* Activity Scenario: Activity Scenario 是 Android 測試庫中的工具，用於在測試中操作和測試 Activity。它允許開發人員模擬 Activity 的行為和交互，進行測試。
* Fragment Factory: Fragment Factory 是用於創建 Fragment 實例的工廠類。它允許開發人員定制化 Fragment 的實例化過程，特別是在 Fragment 具有需要注入的依賴時，可以通過 Fragment Factory 進行相應的注入。
* Gradle: Gradle 是一個基於 Apache Ant 和 Apache Maven 的構建自動化工具，用於構建和管理 Android 項目的依賴關係、資源文件和代碼。
- Navigation Component: Android 中的一個支援庫，用於簡化在應用程序中實現導航功能的開發，包括創建導航圖、定義目的地和導航操作。
- Mockito: 一個用於 Java 的流行的測試框架，用於創建和操作 mock 物件，用於測試中替代真實物件的虛擬物件。
- Espresso: Android 平台上的一個 UI 測試框架，用於編寫自動化 UI 測試，支援模擬使用者操作，如點擊按鈕、輸入文本等。
- Hilt: Android 平台上的一個依賴注入框架，用於簡化應用程序的依賴注入和管理。
- Integration Testing: 一種軟件測試方法，用於測試多個組件或模組之間的交互操作，驗證它們能否正確協同工作。
- Nav Controller: Navigation Component 中的一個類，用於管理應用程序的導航操作，如將用戶從一個目的地導航到另一個目的地。
- View Model: 一種 Android 架構組件，用於在配置更改和活動重新創建時保持數據的一致性，並協助在 UI 控制器之間共享和管理數據。
- Fragment: Android 中的一個 UI 元件，代表應用程序界面的一部分，可以包含自己的 UI 佈局和行為，並且可以添加到活動中以構建多面板用戶界面。
- Backstack: 在 Android 中，用於管理活動和片段堆疊的一個概念，當用戶通過返回按鈕導航時，系統會將先前的活動或片段推入堆疊中。
- UI Testing: 一種軟件測試方法，用於驗證應用程序的用戶界面是否按照預期方式工作，通常包括自動化測試用戶界面的行為和外觀。
- Unit Testing: 一種軟件測試方法，用於驗證應用程序中的個別組件或模組的行為是否符合預期，通常在隔離的環境中進行，以確保測試結果的可靠性。
 - Dagger：Dagger 是一個用於 Android 和 Java 的依賴注入框架，它通過生成代碼來幫助開發者管理應用程序中的依賴關係。
- RecyclerView：RecyclerView 是 Android 的一個顯示大型數據集合的界面元素，它可以用於顯示列表、網格或瀑布流等不同的布局形式。
- ViewModel：ViewModel 是 Android 架構組件，用於在配置更改時管理界面數據的持久性。它與 UI 控制器（如 Activity 或 Fragment）分離，使數據在配置更改時能夠存活並保持狀態。
- LiveData：LiveData 是一個可觀察的數據持有者類別，用於在數據變化時通知觀察者。它與生命周期綁定，可以保證在活動或片段的活動週期內正確地更新數據。
- Espresso：Espresso 是 Android 的 UI 測試框架，用於編寫自動化的界面測試用例。它提供了一個流暢的 API，可以模擬用戶與應用程序進行交互的各種行為。
- Mockito：Mockito 是 Java 的一個單元測試框架，用於創建和操作模擬對象，以便進行單元測試。
- Hilt：Hilt 是 Google 推薦的 Android 依賴注入框架，它可以與 Dagger 一起使用，使依賴注入變得更加簡單和方便。
- Coroutine：Coroutine 是 Kotlin 的一個異步編程庫，用於簡化非同步任務的處理，使代碼更具可讀性和可維護性。
- ViewModel: Android 架構元件，用於以可感知生命週期的方式管理和存儲與界面相關的數據。
- Dagger: 一個依賴注入框架，用於管理和提供應用程序中的依賴關係。
- RecyclerView: Android UI 元件，用於以可重複使用的方式顯示大數據集合，並提供高效的滾動和內容顯示。
- Glide: 用於 Android 的圖片載入庫，支援快速且有效的圖片載入，特別適用於列表和網格視圖。
- Fragment Factory: 用於在 Android Fragment 中進行構造函數注入的工廠類別，提高靈活性和測試性。
- Hilt: 由 Google 提供的 Android 依賴注入框架，用於更輕鬆地管理應用程式中的依賴關係。
- Espresso: Android UI 測試框架，用於撰寫和執行可靠的 UI 測試案例。
- Mockito: Java 的 mocking 框架，用於模擬對象行為，通常在測試中使用。
- Truth: Google 提供的斷言庫，用於撰寫更具可讀性和表達力的斷言語句。
- Nav Controller: Android Jetpack 中的一部分，用於處理應用程式內的導航，管理 Fragment 的堆疊和交換。
- UI Testing: 用於驗證應用程式界面的正確性和行為的測試類型。
- Hilt 依賴注入框架：Hilt 是一個用於 Android 應用程序的依賴注入框架，用於管理應用程序中的依賴關係並將它們注入到適當的地方。
- Glide：Glide 是一個用於在 Android 中加載圖像的開源庫，它提供了簡單易用的 API，用於在應用程序中加載、緩存和顯示圖像。
- ViewModel：ViewModel 是 Android 架構組件之一，用於在應用程序的 UI 控制器和數據持久層之間管理 UI 數據。
- Espresso 測試庫：Espresso 是一個用於在 Android 應用程序中進行 UI 測試的庫，它提供了用於模擬用戶交互的 API，以及用於驗證 UI 狀態的工具。
- Truth 庫：Truth 是 Google 提供的一個用於進行斷言的 Java/Kotlin 库，用於在測試中驗證預期的行為或狀態。
- InstantTaskExecutorRule：InstantTaskExecutorRule 是一個 JUnit 規則，用於在測試中確保 LiveData 在主執行緒上立即執行，使測試結果更可靠。
- Room 數據庫：Room 是 Android 應用程序中的一個持久性庫，用於管理應用程序的 SQLite 數據庫，並提供用於數據庫訪問的類型轉換器和查詢生成器。
- RecyclerView：RecyclerView 是 Android 支持庫中的一個強大的 UI 元素，用於顯示大型數據集合，支持動態添加、刪除和更新數據。
- ItemTouchHelper：ItemTouchHelper 是 Android 支持庫中的一個實用類，用於實現 RecyclerView 中的拖動和滑動手勢操作，例如滑動刪除、拖動排序等功能。
- Espresso 測試庫：Espresso 是 Android 測試框架的一部分，用於編寫 UI 測試，支持模擬用戶與應用程序進行交互，驗證 UI 元素的行為和狀態。
- ViewModel：ViewModel 是 Android 架構組件之一，用於管理 UI 數據並在配置更改時保持數據的一致性，幫助解耦 UI 邏輯和業務邏輯。
- LiveData：LiveData 是 Android 支持庫中的一個類型，用於在數據發生變化時通知觀察者，並確保觀察者在活動生命週期內收到更新的數據。
- Fragment Factory：Fragment Factory 是 Android 應用程序中用於創建 Fragment 實例的工廠類，用於解決在創建 Fragment 時需要傳遞參數的問題。
