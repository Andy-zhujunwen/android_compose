package com.ugc.andorid.mycompose.screen.TabDemoScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TabDemoScreenViewModel: ViewModel() {
    var selectedTab by mutableStateOf(0)

}