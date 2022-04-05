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
import dk.ubaya.adv160819001midtermproject.model.Book

class BookDetailViewModel (application: Application): AndroidViewModel(application) {
    val bookLD = MutableLiveData<Book>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(isbn:String) {

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/native/160819001/anmp/book.php?isbn=$isbn"

        val stringRequest = StringRequest(Request.Method.GET, url, {
                response->
            val result = Gson().fromJson<Book>(response,Book::class.java)
            bookLD.value = result

            Log.d("showvolley",response.toString())
        },{
            Log.e("showvolley",it.toString())
        })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}