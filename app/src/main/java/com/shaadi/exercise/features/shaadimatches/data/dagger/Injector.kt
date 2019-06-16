package com.shaadi.exercise.features.shaadimatches.data.dagger

import com.shaadi.exercise.features.Shaadi
import com.shaadi.exercise.features.shaadimatches.data.dagger.component.DaggerShaadiMatchesDataComponent
import com.shaadi.exercise.features.shaadimatches.ui.ShaadiMatchesFragment

/**
 * Created by Suyash Chavan.
 */
fun ShaadiMatchesFragment.inject() {
    DaggerShaadiMatchesDataComponent.builder()
        .coreDataComponent(Shaadi.coreDataComponent(activity!!))
        .build()
        .inject(this)
}