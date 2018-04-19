package koo.vincent.myapplication.di.module

import dagger.Module
import koo.vincent.myapplication.di.ViewModelModule

@Module(includes = [(ViewModelModule::class)])
internal class AppModule