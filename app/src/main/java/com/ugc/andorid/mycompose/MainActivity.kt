package com.ugc.andorid.mycompose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.LazyColumn
import com.ugc.andorid.mycompose.ViewModel.MainButtonInfo
import com.ugc.andorid.mycompose.ViewModel.MainViewModel
import java.io.Serializable

class MainActivity : AppCompatActivity(),Serializable {
    val viewModel: MainViewModel = MainViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initButtonInfo()
        setContent {
            GuidePage(viewModel.functionButtonList)
        }
    }

    private fun initButtonInfo() {

        viewModel.functionButtonList.add(MainButtonInfo(
            title = "Compose Basic Learning.",listener = object : Listener ,Serializable{

                override fun onClick() {
                    val intent = Intent(this@MainActivity,ComposeBaseActivity::class.java)
                    this@MainActivity.startActivity(intent)
                }
            }
        ))
    }
}



@Composable
private fun GuidePage(buttonList:List<MainButtonInfo>) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxWidth()) {
        item(buttonList) {
            buttonList.forEach {  buttonInfo ->
                FunctonButton(buttonInfo)
            }
        }
    }
}

@Composable
private fun FunctonButton(buttonInfo: MainButtonInfo) {
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
            buttonInfo.listener.onClick()
        }) {
        Text(text = buttonInfo.title)  // button text
    }
}

interface Listener : Serializable {
    fun onClick()
}