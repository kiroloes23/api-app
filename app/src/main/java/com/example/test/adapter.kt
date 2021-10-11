package com.example.test

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapter(val activity: MainActivity, val article: ArrayList<Article>?):
    RecyclerView.Adapter<adapter.newvh>() {
    class newvh(view: View):RecyclerView.ViewHolder(view) {

        val text :TextView=view.findViewById(R.id.tv)
        val image :ImageView= view.findViewById(R.id.iv)
        val view : CardView =view.findViewById(R.id.parent)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): newvh {
       val view = activity.layoutInflater
           .inflate(R.layout.listitem,parent,false)
           return newvh(view)
    }

    override fun onBindViewHolder(holder: newvh, position: Int) {
        holder.text.text=article?.get(position)?.title
        val imagel = article?.get(position)?.urlToImage
        Glide
            .with(activity)
            .load(imagel)
            .into(holder.image)
        holder.view.setOnClickListener {

            val link = Uri.parse(article?.get(position)?.urlToImage)
            val i = Intent(Intent(ACTION_VIEW,link))
            activity.startActivity(i)
        }

    }

    override fun getItemCount() = article?.size ?: 0
}


