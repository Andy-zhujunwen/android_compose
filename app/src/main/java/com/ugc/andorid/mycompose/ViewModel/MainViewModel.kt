package com.ugc.andorid.mycompose.ViewModel

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import com.ugc.andorid.mycompose.ui.common.MainItemInfo

import java.io.Serializable

class MainViewModel(activity: FragmentActivity): AndroidViewModel(activity.application),Serializable {
    val functionButtonList = mutableListOf<MainItemInfo>()
}
