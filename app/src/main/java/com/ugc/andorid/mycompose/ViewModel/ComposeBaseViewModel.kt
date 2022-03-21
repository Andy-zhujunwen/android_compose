package com.ugc.andorid.mycompose.ViewModel

import androidx.lifecycle.ViewModel
import com.ugc.andorid.mycompose.ui.common.MainItemInfo
import java.io.Serializable

class ComposeBaseViewModel: ViewModel(),Serializable {
    val baseFunctionButtonInfoList = mutableListOf<MainItemInfo>()
}
