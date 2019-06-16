package com.shaadi.exercise.core.dagger.component

import android.content.Context
import com.shaadi.exercise.core.dagger.module.CoreDataModule
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Suyash Chavan.
 */
@Singleton
@Component( modules = [
    CoreDataModule::class
]
)
interface CoreDataComponent{

    @Component.Builder interface Builder {
        fun build(): CoreDataComponent

        @BindsInstance
        fun applicationContext(context: Context): Builder
    }

    fun providesRetrofit(): Retrofit
}