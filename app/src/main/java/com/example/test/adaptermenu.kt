package com.example.test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adaptermenu(val activity: Activity,val menu :ArrayList<menu>):
    RecyclerView.Adapter<adaptermenu.menuvh>() {
    class menuvh(view: View):RecyclerView.ViewHolder(view) {
        val text :TextView=view.findViewById(R.id.tv2)
        val image :ImageView=view.findViewById(R.id.iv2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuvh {
       val inflater= activity.layoutInflater
        val view = inflater.inflate(R.layout.listitemmenu,parent,false)
        return menuvh(view)
    }

    override fun onBindViewHolder(holder: menuvh, position: Int) {
       holder.text.text=menu.get(position).name
        holder.image.setImageResource(menu.get(position).pic)

holder.text.setOnClickListener {

    val i = Intent(activity,MainActivity::class.java)
    activity.startActivity(i)}


    }

    override fun getItemCount()= menu.size
}

