package com.example.machinetesting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.machinetesting.R
import com.example.machinetesting.model.ResponseModel
import com.squareup.picasso.Picasso

class DataAdapter : RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    var arrayList: ArrayList<ResponseModel>? = null

    constructor(arrayList: ArrayList<ResponseModel>) {
        this.arrayList = arrayList
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(
        itemView
    ) {
        var tv_name: TextView = itemView.findViewById(R.id.tv_name)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(arrayList!![position].downloadUrl).into(holder.imageView)
        holder.tv_name.text = arrayList!![position].author
    }
}