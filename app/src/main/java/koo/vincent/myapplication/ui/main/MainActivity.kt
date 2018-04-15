package koo.vincent.myapplication.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.AndroidInjection
import koo.vincent.myapplication.R
import koo.vincent.myapplication.base.BaseActivity
import koo.vincent.myapplication.databinding.ActivityMainBinding
import koo.vincent.myapplication.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }
}
