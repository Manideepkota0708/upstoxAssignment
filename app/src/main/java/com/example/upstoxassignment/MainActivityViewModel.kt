package com.example.upstoxassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upstoxassignment.datalayer.networklayer.NetworkService
import com.example.upstoxassignment.datalayer.uilayer.HomePage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    private val networkService: NetworkService = NetworkService()

    private val homePageMutableStateFlow = MutableStateFlow(HomePage())

    val homePageStateFlow = homePageMutableStateFlow as StateFlow<HomePage>



    init {
        viewModelScope.launch {

            networkService.getCustomerInfo().also {
                println(it)
                homePageMutableStateFlow.emit(
                    homePageStateFlow.value.copy(stockInfoList = it.data)
                )
            }
        }
    }

}