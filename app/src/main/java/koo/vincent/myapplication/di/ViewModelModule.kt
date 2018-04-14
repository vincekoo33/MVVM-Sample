package koo.vincent.myapplication.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.IntoMap
import koo.vincent.myapplication.ui.main.MainViewModel

//Module for all my ViewModels
@Module
internal abstract class ViewModelModule {

    /**
     * Bind the view model into a map using the MainViewModel.class as a key and MainViewModel as the value.
     * MainViewModel will be created via the get() method in the Provider class
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindUserViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}