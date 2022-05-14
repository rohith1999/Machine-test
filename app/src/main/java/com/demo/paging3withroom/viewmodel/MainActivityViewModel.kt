package com.demo.paging3withroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.demo.paging3withroom.model.UserData
import com.demo.paging3withroom.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Rohith S
 * MainActivityViewModel has a @constructor with @param repository
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository)
    : ViewModel(){

    /**
     * getAllRepositoryList returns the list of users
     * @return LiveData<List<UserData>>
     */
    fun getAllRepositoryList(): LiveData<List<UserData>> {
        return repository.getAllRecords()
    }

    /**
     * makeApiCall hits a GET API call using Retrofit
     */
    fun makeApiCall() {
        repository.makeApiCall("DEMO_KEY","10")
    }
}