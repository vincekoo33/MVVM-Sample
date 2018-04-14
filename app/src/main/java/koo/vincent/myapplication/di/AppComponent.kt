package koo.vincent.myapplication.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import koo.vincent.myapplication.MainApplication
import koo.vincent.myapplication.ui.main.di.MainModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (MainModule::class), (AppModule::class)])
interface AppComponent : AndroidInjector<MainApplication> {
    override fun inject(instance: MainApplication?)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MainApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}