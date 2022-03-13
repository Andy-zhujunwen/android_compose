package com.ugc.andorid.mycompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            GuidePage()
        }
    }
}


@Composable
private fun GuidePage() {
    Column {
        Text(text = "Compose 示例", color = Color.Yellow)
        Text(text = "an.rustfisher.com", color = Color.Yellow)
        ShowHello(name = "小明")
        ShowHello(name = "小强")
    }
}

@Composable
private fun ShowHello(name: String) {
    Text(text = "Hi $name", color = Color.Cyan)
}