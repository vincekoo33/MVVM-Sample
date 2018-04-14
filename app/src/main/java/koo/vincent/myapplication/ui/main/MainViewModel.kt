package koo.vincent.myapplication.ui.main

import android.arch.lifecycle.MutableLiveData
import koo.vincent.myapplication.base.BaseViewModel
import koo.vincent.myapplication.network.RetrofitService
import java.util.*
import javax.inject.Inject


class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var service: RetrofitService

    var liveDataForOnClick = MutableLiveData<String>()

    var liveDataForOnLongClick = MutableLiveData<String>()

    fun pushOnClickToast(name:String) {
        liveDataForOnClick.postValue(name)
    }

    fun pushOnLongClickToast(name:String) {
        liveDataForOnLongClick.postValue(name)
    }

}