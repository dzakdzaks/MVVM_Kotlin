package com.dzakdzaks.mvvmkotlina.view

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dzakdzaks.mvvmkotlina.R
import com.dzakdzaks.mvvmkotlina.model.MuseumEntity


/**
 * ==================================//==================================
 * ==================================//==================================
 * Created by Dzakdzaks on Thursday, 16 January 2020 at 16:13.
 * Project Name => MVVM Kotlina
 * Package Name => com.dzakdzaks.mvvmkotlina.view
 * ==================================//==================================
 * ==================================//==================================
 */

class MuseumAdapter(private var museums: List<MuseumEntity>) :
    RecyclerView.Adapter<MuseumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_museum, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val museum = museums[position]

        holder.tvName.text = museum.name

//        val requestOptions = RequestOptions()
//        requestOptions.apply {
//            centerCrop()
//            placeholder(R.drawable.ic_launcher_background)
//            error(R.drawable.ic_launcher_foreground)
//            diskCacheStrategy(DiskCacheStrategy.ALL)
//            priority(Priority.HIGH)
//        }
//                    .apply(requestOptions)

        Glide.with(holder.imageView.context)
            .load(museum.photo)
            .into(holder.imageView)

        holder.tvLink.setOnClickListener {
            try {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.data = Uri.parse(museum.photo)
                holder.itemView.context.startActivity(intent)
            } catch (e: Exception) {
                Log.e("loglog", "onClick: Image url is not correct")
            }
        }

    }

    fun update(data: List<MuseumEntity>) {
        museums = data
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.textViewName)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val tvLink: TextView = itemView.findViewById(R.id.textViewLink)
    }
}