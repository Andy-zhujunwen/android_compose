package com.ugc.andorid.mycompose.ViewModel

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ugc.andorid.mycompose.Listener

import java.io.Serializable

class MainViewModel(activity: FragmentActivity): AndroidViewModel(activity.application),Serializable {
    val functionButtonList = mutableListOf<MainButtonInfo>()
}

data class MainButtonInfo(val title:String,val listener: Listener): Serializable