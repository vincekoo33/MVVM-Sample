package koo.vincent.myapplication.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity<out ViewModel : BaseViewModel, Binding : ViewDataBinding> : AppCompatActivity() {
    abstract val viewModel: ViewModel
    lateinit var binding: Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
    }

    abstract fun getLayout(): Int
}