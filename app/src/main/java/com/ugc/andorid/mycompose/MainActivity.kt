package com.ugc.andorid.mycompose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.ugc.andorid.mycompose.ViewModel.MainViewModel
import com.ugc.andorid.mycompose.ui.common.ButtonFeedView
import com.ugc.andorid.mycompose.ui.common.Listener
import com.ugc.andorid.mycompose.ui.common.MainItemInfo
import java.io.Serializable


class MainActivity : AppCompatActivity(),Serializable {
    val viewModel: MainViewModel = MainViewModel(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initButtonInfo()
        setContent {
            ButtonFeedView(viewModel.functionButtonList)
        }
    }

    private fun initButtonInfo() {
        viewModel.functionButtonList.add(MainItemInfo(
            title = "Compose Basic Learning.",listener = object : Listener,Serializable{
                override fun onClick() {
                    val intent = Intent(this@MainActivity,ComposeBaseActivity::class.java)
                    this@MainActivity.startActivity(intent)
                }
            }
        ))

        viewModel.functionButtonList.add(MainItemInfo(
            title = "Compose Basic Learning.",listener = object : Listener,Serializable{
                override fun onClick() {
                    val intent = Intent(this@MainActivity,ComposeBaseActivity::class.java)
                    this@MainActivity.startActivity(intent)
                }
            }
        ))
    }
}

