package koo.vincent.myapplication.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import dagger.android.AndroidInjection
import koo.vincent.myapplication.R
import koo.vincent.myapplication.base.BaseActivity
import koo.vincent.myapplication.databinding.ActivityMainBinding
import koo.vincent.myapplication.di.ViewModelFactory
import koo.vincent.myapplication.models.User
import koo.vincent.myapplication.ui.main.MainAdapter.DiffCallback
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

        binding.recyclerView.adapter = MainAdapter(generateListOfRandomName(), viewModel, DiffCallback())
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.liveDataForOnClick.observe(this, Observer { name -> Toast.makeText(applicationContext, "$name onClick", Toast.LENGTH_SHORT).show() })
        viewModel.liveDataForOnLongClick.observe(this, Observer { name -> Toast.makeText(applicationContext, "$name onLongClick", Toast.LENGTH_SHORT).show() })
    }

    private fun generateListOfRandomName(): MutableList<User> {
        var listOfNames = mutableListOf<User>()
        listOfNames.add(User("Ash"))
        listOfNames.add(User("Misty"))
        listOfNames.add(User("Brock"))
        listOfNames.add(User("Pikachu"))
        return listOfNames
    }
}
