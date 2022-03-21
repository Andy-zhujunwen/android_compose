package com.ugc.andorid.mycompose.screen.ViewPagerDemoScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.ugc.andorid.mycompose.screen.TabDemoScreen.BottomBar
import com.ugc.andorid.mycompose.screen.TabDemoScreen.TabDemoScreenView
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun ViewPagerDemoScreenView() {
    Column {
        val pagerState = rememberPagerState()
        val viewModel: ViewPagerDemoScreenViewModel = viewModel()
        HorizontalPager(count = 4, Modifier.weight(1f),
        pagerState) { pager ->  // implementation "com.google.accompanist:accompanist-pager:<version>"
            when (pager) {
                0 -> SportList()
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }
        }

        val scope = rememberCoroutineScope()
        BottomBar(pagerState.currentPage) { page ->
            // 点击标签页后，在协程里翻页
            scope.launch {
//                pagerState.animateScrollToPage(page = page)
                pagerState.scrollToPage(page)
            }
        }
    }
}

@Composable
fun SportList() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black))
}

