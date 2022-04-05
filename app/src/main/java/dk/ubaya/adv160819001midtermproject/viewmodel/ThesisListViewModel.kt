package dk.ubaya.adv160819001midtermproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dk.ubaya.adv160819001midtermproject.model.Thesis

class ThesisListViewModel(application: Application): AndroidViewModel(application) {
    val thesisLD = MutableLiveData<List<Thesis>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh() {
        loadingErrorLD.value=false
        loadingLD.value=true

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/native/160819001/anmp/thesis.php"

        val stringRequest = StringRequest(Request.Method.GET, url, {
                response->
            val sType = object : TypeToken<List<Thesis>>(){}.type
            val result = Gson().fromJson<List<Thesis>>(response,sType)
            thesisLD.value = result

            loadingLD.value=false
            Log.d("showvolley",response.toString())
        },{
            loadingErrorLD.value=true
            loadingLD.value=false
            Log.e("showvolley",it.toString())
        })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}