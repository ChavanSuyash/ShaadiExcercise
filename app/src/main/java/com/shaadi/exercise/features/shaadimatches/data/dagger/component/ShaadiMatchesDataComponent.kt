package com.shaadi.exercise.features.shaadimatches.data.dagger.component

import com.shaadi.exercise.core.dagger.component.CoreDataComponent
import com.shaadi.exercise.core.dagger.scope.ActivityScope
import com.shaadi.exercise.features.shaadimatches.data.dagger.module.ShaadiMatchesDataModule
import com.shaadi.exercise.features.shaadimatches.data.dagger.module.ShaadiMatchesViewModelModule
import com.shaadi.exercise.features.shaadimatches.ui.ShaadiMatchesFragment
import dagger.Component

/**
 * Created by Suyash Chavan.
 */
@Component(
    modules = [
        ShaadiMatchesDataModule::class,
        ShaadiMatchesViewModelModule::class
    ],
    dependencies = [
        CoreDataComponent::class
    ]
)
@ActivityScope
interface ShaadiMatchesDataComponent {

    @Component.Builder interface Builder {
        fun build() : ShaadiMatchesDataComponent

        fun coreDataComponent(coreDataComponent: CoreDataComponent) : Builder
    }

    fun inject(shaadiMatchesFragment: ShaadiMatchesFragment)
}