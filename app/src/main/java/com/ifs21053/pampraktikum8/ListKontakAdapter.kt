package com.ifs21053.pampraktikum8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifs21053.pampraktikum8.Kontak

class ListKontakAdapter (
    private val context : Context,
    private val kontak : MutableList<Kontak>,
    val listener:(Kontak) -> Unit
) :  RecyclerView.Adapter<ListKontakAdapter.KontakViewHolder>(){

    class KontakViewHolder(view: View): RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.ivItemKontak)
        val name = view.findViewById<TextView>(R.id.tvItemKontak)
        val description = view.findViewById<TextView>(R.id.tvItemDeskripsi)


        fun bindView(destination: Kontak, listener: (Kontak) -> Unit) {
            img.setImageResource(destination.icon)
            name.text = destination.name
            description.text = destination.description
            itemView.setOnClickListener {
                listener(destination)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row_kontak, parent, false)
        return KontakViewHolder(view)
    }
    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        val currentDestination = kontak[position]
        holder.bindView(currentDestination, listener)
    }
    override fun getItemCount(): Int {
        return kontak.size
    }

}



