package com.example.exo2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter


        val apiInterface = ApiInterface.create().getTodos()


        apiInterface.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>?, response: Response<List<Todo>>?) {

                if (response?.body() != null)
                    recyclerAdapter.setTodosItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Todo>>?, t: Throwable?) {

            }
        })
    }
}