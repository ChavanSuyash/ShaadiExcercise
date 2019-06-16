package com.shaadi.exercise.features.shaadimatches.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaadi.exercise.core.network.Outcome
import com.shaadi.exercise.features.shaadimatches.data.response.GetShaadiMatchesResponse
import com.shaadi.exercise.features.shaadimatches.data.source.ShaadiMatchesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Suyash Chavan.
 */
class ShaadiMatchesViewModel @Inject constructor(
    private val shaadiMatchesRepository: ShaadiMatchesRepository
): ViewModel() {

    fun getShaadiMatches(
        onResult: (onResult: GetShaadiMatchesResponse) -> Unit,
        onError: (onError: String) -> Unit
    ){
        viewModelScope.launch(Dispatchers.IO) {
            val outcome = shaadiMatchesRepository.OnGetShaadiMatches(10)
            withContext(Dispatchers.Main) {
                when (outcome) {
                    is Outcome.Success -> {
                       onResult(outcome.data)
                    }
                    is Outcome.Error ->{
                        onError(outcome.exception.toString())
                    }
                }
            }
        }
    }

}