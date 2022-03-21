package com.ugc.andorid.mycompose.ui.common

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import java.io.Serializable

@Composable
fun FunctonButton(buttonInfo: MainItemInfo) {
    val context = LocalContext.current  // 获取当前 context
    val mInteractionSource = remember { // 创建交互源
        MutableInteractionSource()
    }
    val pressState = mInteractionSource.collectIsPressedAsState()
    val mColor = if (pressState.value) ButtonDefaults.buttonColors(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) else ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White)

    Button(
        interactionSource = mInteractionSource, // 设置交互源
        shape = RoundedCornerShape(20),  // button 圆角
        colors = mColor,
        onClick = {
            buttonInfo.listener?.onClick()
        }) {
        Text(text = buttonInfo.title)  // button text
    }
}



interface Listener : Serializable {
    fun onClick()
}

data class MainItemInfo(val title:String, val listener: Listener?): Serializable
data class FeedItemInfo(val title: String,val listener: Listener?)