package com.funnystudio.samplelistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<MyPhoto>>, MyAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.layoutManager = LinearLayoutManager(this)
        list.hasFixedSize()

        progressBar.visibility = View.VISIBLE
        APIManager.getPhotos(this)
    }

    override fun onFailure(call: Call<List<MyPhoto>>, t: Throwable) {
        progressBar.visibility = View.GONE
        Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<MyPhoto>>, response: Response<List<MyPhoto>>) {
        progressBar.visibility = View.GONE
        if(response.isSuccessful){
            if(!response.body().isNullOrEmpty()){
                val adapter = MyAdapter(response.body()!!)
                adapter.onItemClickListener = this@MainActivity
                list.adapter = adapter
            }
        }else{
            Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemClicked(myPhoto: MyPhoto) {
        DetailActivity.startActivity(this ,myPhoto)
    }

}
