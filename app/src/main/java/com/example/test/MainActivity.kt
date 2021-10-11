package com.example.test


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
 lateinit var refresh : SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("news")
refresh=findViewById(R.id.swip)
        refresh.setOnRefreshListener {
            news()
        }
        news()
    }
    fun news() {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val call = retrofit.create(callinterface::class.java)
        val newscall = call.getnews()
        newscall.enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter
                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
               Log.d("trace","error:${t.localizedMessage}")
            }
        })
        }
    }
































