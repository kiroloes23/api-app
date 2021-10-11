package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class menuActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)
        val array = ArrayList<menu>()
        title="countries"
        array.add(menu("france", R.drawable.france))
        array.add(menu("egypt",R.drawable.images))
        array.add(menu("germany",R.drawable.germany))
        array.add(menu("spain",R.drawable.spain))

        val adapter= adaptermenu(this,array)
        val rv :RecyclerView=findViewById(R.id.rv)
        rv.adapter=adapter
        Toast.makeText(this, "choose country", Toast.LENGTH_SHORT).show()
    }
}