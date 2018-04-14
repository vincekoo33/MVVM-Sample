package koo.vincent.myapplication.ui.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import koo.vincent.myapplication.ui.main.MainActivity

@Module
abstract class MainModule {

    @ContributesAndroidInjector()
    abstract fun mainActivityInjector(): MainActivity
}