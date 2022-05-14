package com.demo.paging3withroom.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.demo.paging3withroom.db.AppDao
import com.demo.paging3withroom.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


/**
 * RetroRepository injets constructor with retroServiceInterface and appDao.
 * This class helps in fetching the records from REST API and inserts all records into room database
 */
class RetroRepository @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface,
    private val appDao: AppDao
) {


    /**
     * getAllRecords returns the list of UserData from Room database
     */
    fun getAllRecords(): LiveData<List<UserData>> {
        return appDao.getAllRecords()
    }

    /**
     * insertRecord inserts a record into Room database
     */
    fun insertRecord(repositoryData: UserData) {
        appDao.insertRecords(repositoryData)
    }

    /**
     * makeApiCall passes the desired request with api_key and count and stores the response in Room database
     */
    fun makeApiCall(api_call: String?, count: String?) {

        val callreq: Call<List<UserData?>?>? = retroServiceInterface.getContacts(api_call!!, count)

        callreq?.enqueue(object : Callback<List<UserData?>?> {
            override fun onResponse(
                call: Call<List<UserData?>?>,
                response: Response<List<UserData?>?>
            ) {


                if (response.isSuccessful) {

                    appDao.deleteAllRecords()

                    response.body()?.forEach {
                        if (it != null) {
                            insertRecord(it)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<UserData?>?>, t: Throwable) {


            }
        })
    }
}