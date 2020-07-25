package com.example.android_mvvm_koin_retrofit_room_junit_starter

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val retroService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        val resLiveData: LiveData<Response<Albums>> = liveData {
            val response = retroService.getAlbums()
            emit(response)
        }
        resLiveData.observe(this, Observer { val albumList = it.body()?.listIterator()
            if(albumList !=null){
                while(albumList.hasNext()){
                    val albumItem = albumList.next()
                    Log.d("MY_TAG", albumItem.title)
                }
            }
        })
    }
}