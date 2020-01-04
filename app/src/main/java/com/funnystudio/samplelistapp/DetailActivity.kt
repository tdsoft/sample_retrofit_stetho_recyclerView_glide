package com.funnystudio.samplelistapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var myPhoto: MyPhoto? = null

    companion object{
        fun startActivity(context: Context, myPhoto: MyPhoto){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("myPhoto", myPhoto)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        myPhoto = intent.getParcelableExtra("myPhoto")
        textView3.text = myPhoto!!.title
        Glide.with(this).load(myPhoto!!.url).into(imageView3)
    }
}
