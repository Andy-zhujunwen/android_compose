package com.ugc.andorid.mycompose.screen.RecyclerViewDemoScreen.RecyclerGridScreen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugc.andorid.mycompose.R

@Composable
fun RecyclerGridScreenView() {
    val dataList = mutableListOf<GridData>(
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
        GridData(imageRes = R.drawable.image1, "这是一个图片1"),
    )

    val dataSize = dataList.size
    val columnCount = 3
    val rowCount = dataSize + columnCount - 1 / columnCount
    LazyColumn {
        items(rowCount) { rowIndex ->
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(vertical = 15.dp)){
                for ( i in 0 until columnCount) {
                    val itemIndex = columnCount * rowIndex + i
                    if (itemIndex < dataSize) {
                        Box(modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 15.dp)) {
                            val dataItem = dataList[itemIndex]
                            GridUnit(item = dataItem)
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f)) // 空项
                    }
                }
            }

        }
    }
}

@Composable
fun GridUnit(item: GridData) {
    Row(Modifier.size(150.dp, 200.dp)) {
        Image(painter = painterResource(id = item.imageRes), contentDescription = "aaa",
            contentScale = ContentScale.Crop,modifier = Modifier.weight(2f))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "介绍", color = Color.White,
                modifier = Modifier.padding(bottom = 10.dp),
            fontWeight = FontWeight.Bold, fontSize = 17.sp)
            Text(text = item.text, color = Color.White,)
        }

    }
}

data class GridData(val imageRes: Int, val text: String)

@Preview
@Composable
fun GridUnitPreview() {
    Row(Modifier.size(60.dp, 50.dp)) {
        Image(painter = painterResource(id = R.drawable.image1), contentDescription = "aaa")
        Text(text = "dfafadfadfadaf", color = Color.White)
    }
}