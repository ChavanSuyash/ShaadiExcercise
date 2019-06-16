package com.shaadi.exercise.features.shaadimatches.data.dagger.module

import androidx.lifecycle.ViewModel
import com.shaadi.exercise.core.dagger.ViewModelKey
import com.shaadi.exercise.features.shaadimatches.data.ShaadiMatchesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Suyash Chavan.
 */
@Module
abstract class ShaadiMatchesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ShaadiMatchesViewModel::class)
    internal abstract fun authViewModel(viewModel: ShaadiMatchesViewModel): ViewModel

}