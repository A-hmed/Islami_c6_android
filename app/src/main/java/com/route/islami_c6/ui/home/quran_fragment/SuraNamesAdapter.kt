package com.route.islami_c6.ui.home.quran_fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_c6.R

class SuraNamesAdapter(val items: Array<String>) :RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.suraNameTextView.setText(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val suraNameTextView = itemView.findViewById<TextView>(R.id.item_sura_name_title)
    }
}