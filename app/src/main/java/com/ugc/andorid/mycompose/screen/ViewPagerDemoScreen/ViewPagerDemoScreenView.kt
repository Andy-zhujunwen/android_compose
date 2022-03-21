package com.ugc.andorid.mycompose.screen.ViewPagerDemoScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.ugc.andorid.mycompose.screen.TabDemoScreen.BottomBar
import com.ugc.andorid.mycompose.screen.TabDemoScreen.TabDemoScreenView



@ExperimentalPagerApi
@Composable
fun ViewPagerDemoScreenView() {
    Column {
        val viewModel: ViewPagerDemoScreenViewModel = viewModel()
        HorizontalPager(count = 4) { pager ->  // implementation "com.google.accompanist:accompanist-pager:<version>"
            when (pager) {
                0 -> SportList()
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }
        }
        BottomBar(viewModel.selectedTab) {

        }
    }
}

@Composable
fun SportList() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Black))
}

