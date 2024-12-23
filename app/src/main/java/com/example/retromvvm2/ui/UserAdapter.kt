package com.example.retromvvm2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retromvvm2.R
import com.example.retromvvm2.model.AlbumListItem
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter(private val context: Context,val userList: List<AlbumListItem>): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.user_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.tvId.text= user.id.toString()
        Glide.with(holder.image.context).load(user.thumbnailUrl/*"https://picsum.photos/400/300"*/).into(holder.image.imageView)
        holder.tvTitle.text=user.title
    }

    override fun getItemCount(): Int = userList.size
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val tvId = itemView.findViewById<TextView>(R.id.tvId)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val image = itemView.findViewById<ImageView>(R.id.imageView)
    }
}