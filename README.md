# FlowBinding

[![CircleCI](https://circleci.com/gh/ReactiveCircus/FlowBinding.svg?style=svg)](https://circleci.com/gh/ReactiveCircus/FlowBinding) [![Build Status](https://app.bitrise.io/app/6ff0212a079f16f3/status.svg?token=dtE8nQVs12zS4l61-fJfFw&branch=master)](https://app.bitrise.io/app/6ff0212a079f16f3) [![Android API](https://img.shields.io/badge/API-21%2B-blue.svg?label=API&maxAge=300)](https://www.android.com/history/) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Kotlin Flow binding APIs for Android's platform and unbundled UI widgets, inspired by [RxBinding][rxbinding].

[Flow][flow] is (conceptually) a reactive streams implementation provided by the [kotlinx-coroutines-core][kotlinx-coroutines] artifact.

**FlowBinding** offers an extensive set of extension functions that turn traditional callbacks / listeners on Android UI widgets into the `Flow` type.

The binding implementation respects the `CoroutineScope` used for collecting the flows by unregistering the callback / listener automatically when the scope is cancelled.

## Roadmap

The library is a work in progress. We currently have bindings for the **Material Components** and **ViewPager2** and we are actively adding more. The ultimate goal is to cover most of the bindings provided by **RxBinding** plus some of the new widgets from **Material Components** (e.g. Pickers).

### Platform Bindings

- [ ] View
    - [x] `fun MenuItem.actionViewEvents(handled: (MenuItemActionViewEvent) -> Boolean): Flow<MenuItemActionViewEvent>`
    - [x] `fun MenuItem.clicks(handled: (MenuItem) -> Boolean): Flow<Unit>`
    - [x] `fun View.clicks(): Flow<Unit>`
    - [x] `fun View.focusChanges(emitImmediately: Boolean = false): Flow<Boolean>`
    - [x] `fun View.longClicks(): Flow<Unit>`
- [ ] Widget
    TBA

### Material Components Bindings

- [x] AppBarLayout
    - [x] `fun AppBarLayout.offsetChanges(): Flow<Int>`
- [x] BottomNavigationView
    - [x] `fun BottomNavigationView.itemReselections(): Flow<MenuItem>`
    - [x] `fun BottomNavigationView.itemSelections(emitImmediately: Boolean = false): Flow<MenuItem>`
- [x] BottomSheetBehavior
    - [x] `fun View.bottomSheetSlides(): Flow<Float>`
    - [x] `fun View.bottomSheetStateChanges(): Flow<Int>`
- [x] Chip
    - [x] `fun Chip.closeIconClicks(): Flow<Unit>`
- [x] ChipGroup
    - [x] `fun ChipGroup.chipCheckedChanges(emitImmediately: Boolean = false): Flow<Int>`
- [x] MaterialButton
    - [x] `fun MaterialButton.checkedChanges(): Flow<Boolean>`
- [x] MaterialButtonToggleGroup
    - [x] `fun MaterialButtonToggleGroup.buttonCheckedChanges(): Flow<MaterialButtonCheckedChangedEvent>`
- [x] NavigationView
    - [x] `fun NavigationView.itemSelections(emitImmediately: Boolean = false): Flow<MenuItem>`
- [ ] Picker - TBA
- [x] Snackbar
    - [x] `fun Snackbar.dismissEvents(): Flow<Int>`
    - [x] `fun Snackbar.shownEvents(): Flow<Unit>`
- [x] SwipeDismissBehavior
    - [x] `fun View.dismisses(): Flow<View>`
    - [x] `fun View.swipeDismissDragStateChanges(): Flow<Int>`
- [x] TabLayout
    - [x] `fun TabLayout.tabSelectionEvents(emitImmediately: Boolean = false): Flow<TabLayoutSelectionEvent>`
- [x] TextInputLayout
    - [x] `fun TabLayout.textInputLayoutStartIconClicks(): Flow<Unit>`
    - [x] `fun TabLayout.textInputLayoutEndIconClicks(): Flow<Unit>`
    - [x] `fun TabLayout.textInputLayoutStartIconLongClicks(): Flow<Unit>`
    - [x] `fun TabLayout.textInputLayoutEndIconLongClicks(): Flow<Unit>`


### AndroidX Bindings

- [ ] Core

TBA.

- [ ] AppCompat

TBA.

- [ ] DrawerLayout

TBA.

- [ ] RecyclerView

TBA.

- [ ] SwipeRefreshLayout

TBA.

- [x] ViewPager 2
    - [x] `fun ViewPager2.pageScrollEvents(): Flow<ViewPager2PageScrollEvent>`
    - [x] `fun ViewPager2.pageScrollStateChanges(): Flow<Int>`
    - [x] `fun ViewPager2.pageSelections(emitImmediately: Boolean = false): Flow<Int>`

- [ ] Navigation Component

TBA.

## License

```
Copyright 2019 Yang Chen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[maven-central]: https://search.maven.org/search?q=g:io.github.reactivecircus.flowbinding
[snap]: https://oss.sonatype.org/content/repositories/snapshots/
[rxbinding]: https://github.com/JakeWharton/RxBinding
[flow]: https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/
[kotlinx-coroutines]: https://github.com/Kotlin/kotlinx.coroutines
