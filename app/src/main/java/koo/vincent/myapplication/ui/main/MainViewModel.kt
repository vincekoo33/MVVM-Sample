package koo.vincent.myapplication.ui.main

import koo.vincent.myapplication.base.BaseViewModel
import koo.vincent.myapplication.network.RetrofitService
import javax.inject.Inject


class MainViewModel @Inject constructor() : BaseViewModel() {
    @Inject
    lateinit var service: RetrofitService
}