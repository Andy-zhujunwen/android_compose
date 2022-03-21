package com.ugc.andorid.mycompose.screen.ViewPagerDemoScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewPagerDemoScreenViewModel: ViewModel() {
    var selectedTab: Int by mutableStateOf(0)
}