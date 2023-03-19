package com.example.recycleviewaddoperations

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(
    private val userNameList: List<UserNameModel>
) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uiTvUserName: TextView = itemView.findViewById(R.id.uiTvUserName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.customlayout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userNameItem = userNameList[position]
        holder.uiTvUserName.text = userNameItem.userName
    }

    override fun getItemCount(): Int {
        return userNameList.size
    }
}