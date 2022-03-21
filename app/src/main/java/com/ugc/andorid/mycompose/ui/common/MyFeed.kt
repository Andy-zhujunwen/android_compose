package com.ugc.andorid.mycompose.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ugc.andorid.mycompose.R

@Composable
fun ButtonFeedView(buttonList:List<MainItemInfo>) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxWidth()) {
        items(buttonList) {
            FunctonButton(buttonInfo = it)
        }
    }
}
