package com.route.islami_c6.ui.sura_details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami_c6.R
import java.util.*

class SuraVerseAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<SuraVerseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //holder.suraNameTextView.setText(items.get(position))
        holder.suraNameTextView.text = items.get(position)
        holder.suraNameTextView.setOnClickListener {
            onSuraNameClicked?.onItemClickListener(items.get(position), position)
        }
    }
    var onSuraNameClicked: OnItemClickListener? = null
    interface OnItemClickListener{
        fun onItemClickListener(item: String, index: Int)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val suraNameTextView = itemView.findViewById<TextView>(R.id.item_sura_name_title)
    }
}