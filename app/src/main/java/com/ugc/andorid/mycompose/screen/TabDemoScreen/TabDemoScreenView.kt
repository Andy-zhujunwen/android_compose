package com.ugc.andorid.mycompose.screen.TabDemoScreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ugc.andorid.mycompose.R

@Composable
fun TabDemoScreenView() {
    val viewModel: TabDemoScreenViewModel = viewModel()
    Column {
        BottomBar(viewModel.selectedTab) {
            viewModel.selectedTab = it
        }
    }
}


@Composable
fun BottomBar(selectedTab: Int, onClickedChanged: (Int) -> Unit) {
    val viewModel: TabDemoScreenViewModel = viewModel()
    Row (Modifier.background(Color.Black)){
        TabItem(
            if (selectedTab == 0) R.drawable.tab1selected else R.drawable.tab1unselected,"运动",
            Modifier
                .weight(1f)
                .clickable {
                    onClickedChanged.invoke(0)
                }
        )

        TabItem(
            if (selectedTab == 1) R.drawable.tab1selected else R.drawable.tab1unselected,"运动",
            Modifier.weight(1f)
                .clickable {
                    onClickedChanged.invoke(1)
                }
        )

        TabItem(
            if (selectedTab == 2) R.drawable.tab1selected else R.drawable.tab1unselected,"运动",
            Modifier.weight(1f)
                .clickable {
                    onClickedChanged.invoke(2)
                }
        )

        TabItem(
            if (selectedTab == 3) R.drawable.tab1selected else R.drawable.tab1unselected,"运动",
            Modifier.weight(1f)
                .clickable {
                    onClickedChanged.invoke(3)
                }
        )

    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, title: String, modifier: Modifier) {
    Column(modifier = modifier.padding(vertical = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = iconId), contentDescription = title,
        Modifier.size(40.dp,40.dp))
        Text(text = title,color = Color.White)
    }
}

@Preview
@Composable
fun TabItemPreview() {
    Column {
        Image(painter = painterResource(id = R.drawable.tab1unselected), contentDescription = "运动" )
        Text(text = "运动" )
    }
}