package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val apiKey = "fb74549093da45ec8571c769076a047a" // Replace with your actual API key

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchNews()
    }

    private fun fetchNews() {
        val apiService = RetrofitClient.instance
        apiService.getTopHeadlines("us", apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val articles = response.body()?.articles ?: emptyList()
                    recyclerView.adapter = NewsAdapter(articles)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to retrieve news.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
