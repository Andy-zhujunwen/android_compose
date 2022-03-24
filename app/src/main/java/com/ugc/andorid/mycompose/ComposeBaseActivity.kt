package com.ugc.andorid.mycompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ugc.andorid.mycompose.screen.TabDemoScreen.TabDemoScreenView
import com.ugc.andorid.mycompose.ViewModel.ComposeBaseViewModel
import com.ugc.andorid.mycompose.screen.RecyclerViewDemoScreen.RecyclerGridScreen.RecyclerGridScreenView
import com.ugc.andorid.mycompose.screen.RecyclerViewDemoScreen.RecyclerViewDemoScreenView
import com.ugc.andorid.mycompose.screen.ViewPagerDemoScreen.ViewPagerDemoScreenView
import com.ugc.andorid.mycompose.ui.common.ButtonFeedView
import com.ugc.andorid.mycompose.ui.common.Listener
import com.ugc.andorid.mycompose.ui.common.MainItemInfo
import java.io.Serializable


class ComposeBaseActivity:AppCompatActivity(),Serializable {


    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel:ComposeBaseViewModel = viewModel()
            val navController = rememberNavController()
            val backstackEntry = navController.currentBackStackEntryAsState() // 回退栈
            initButtonInfo(viewModel,navController)
            NavHost(navController = navController, startDestination = "GuidePage") {
                composable("GuidePage") { ButtonFeedView(buttonList = viewModel.baseFunctionButtonInfoList)}
                composable("TabPage") { TabDemoScreenView()}
                composable("recyclerView") { RecyclerViewDemoScreenView(navController)}
                composable("viewPager") { ViewPagerDemoScreenView() }
                composable("Grid") { RecyclerGridScreenView() }
            }


        }
    }

    private fun initButtonInfo(viewModel: ComposeBaseViewModel,navController: NavController) {
        viewModel.baseFunctionButtonInfoList.add(
            MainItemInfo(title = "tab page",
            object : Listener, Serializable {
                override fun onClick() {
                    navController.navigate("TabPage")
                }
            })
        )
        viewModel.baseFunctionButtonInfoList.add(
                MainItemInfo(title = "recyclerView",
                    object : Listener, Serializable {
                        override fun onClick() {
                            navController.navigate("recyclerView")
                        }
                    })
            )
        viewModel.baseFunctionButtonInfoList.add(
            MainItemInfo(title = "viewPager",
                object : Listener, Serializable {
                    override fun onClick() {
                        navController.navigate("viewPager")
                    }
                })
        )

    }
}

@Preview
@Composable
fun SText() {
    Row (){
        Text("ddd",color = Color.Blue)
    }
}

