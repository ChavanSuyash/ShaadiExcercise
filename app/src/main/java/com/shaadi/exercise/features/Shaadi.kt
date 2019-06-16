package com.shaadi.exercise.features

import android.app.Application
import android.content.Context
import com.shaadi.exercise.core.dagger.component.CoreDataComponent
import com.shaadi.exercise.core.dagger.component.DaggerCoreDataComponent

/**
 * Created by Suyash Chavan.
 */
class Shaadi : Application() {

    private val coreDataComponent: CoreDataComponent by lazy {
        DaggerCoreDataComponent
            .builder()
            .applicationContext(this)
            .build()
    }

    companion object {
        @JvmStatic
        fun coreDataComponent(context: Context) =
            (context.applicationContext as Shaadi).coreDataComponent
    }
}