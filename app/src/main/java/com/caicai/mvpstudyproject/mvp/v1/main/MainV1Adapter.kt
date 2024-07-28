package com.caicai.mvpstudyproject.mvp.v1.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.caicai.mvpstudyproject.R

class MainV1Adapter(private val items: List<String>, private val listener: ((String) -> Unit)?):
    RecyclerView.Adapter<MainV1Adapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val textView = LayoutInflater.from(parent.context).
        inflate(R.layout.view_main_v1_item, null, false) as TextView
        return MainViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item
        holder.textView.setOnClickListener {
            listener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {}
}