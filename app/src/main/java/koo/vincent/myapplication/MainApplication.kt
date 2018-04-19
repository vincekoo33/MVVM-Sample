package koo.vincent.myapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import koo.vincent.myapplication.di.component.AppComponent
import koo.vincent.myapplication.di.component.DaggerAppComponent

class MainApplication : DaggerApplication() {
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
}