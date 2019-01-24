package com.example.casekry.modules

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException


abstract class NetworkCallback(private val loader: MutableLiveData<Boolean>? = null) : Callback {
    override fun onFailure(call: Call, e: IOException) {
        onUnsuccessful()
        onComplete()
    }

    override fun onResponse(call: Call, response: Response) {
        if (response.isSuccessful) {
            onSuccess()
        } else {
            onUnsuccessful()
        }

        onComplete()
    }

    abstract fun onSuccess()

    abstract fun onUnsuccessful()

    @CallSuper
    open fun onComplete() {
        loader?.postValue(false)
    }
}