package com.example.test


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var refresh: SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("news")

        refresh = findViewById(R.id.swip)
        refresh.setOnRefreshListener {
            news()
        }
        news()

        val mAdView: AdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
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
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val call = retrofit.create(callinterface::class.java)

    when(id){

        R.id.egypt->
            call.getnews().enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter

                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })
        R.id.spain-> call.getnewss().enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter
                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })
        R.id.fance-> call.getnewws().enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter
                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })
        R.id.germany-> call.getneww().enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter
                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })

        R.id.italia->call.getnewow().enqueue(object : Callback<ipmodel> {
            override fun onResponse(call: Call<ipmodel>, response: Response<ipmodel>) {
                val news = response.body()
                val articles = news?.articles
                val adapter = adapter(this@MainActivity, articles)
                val rv: RecyclerView = findViewById(R.id.rv)
                rv.adapter = adapter
                refresh.isRefreshing = false
            }

            override fun onFailure(call: Call<ipmodel>, t: Throwable) {
                Log.d("trace", "error:${t.localizedMessage}")
            }
        })
    }
        return super.onOptionsItemSelected(item)
    }

}







































