package com.example.one_rw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.one_rw.databinding.RcItemBinding

class RcAdapter():RecyclerView.Adapter<RcAdapter.RcHolder>() {
    val pudgeList= ArrayList<Pudge>()
    class RcHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding =RcItemBinding.bind(item)
        fun bind(pudge: Pudge)= with(binding){
            im.setImageResource(pudge.imageId)
            te.text = pudge.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_item,parent,false)
        return RcHolder(view)
    }

    override fun onBindViewHolder(holder: RcHolder, position: Int) {
        holder.bind(pudgeList[position])

    }

    override fun getItemCount(): Int {
        return pudgeList.size
    }
    fun addPudge(pudge: Pudge){
        pudgeList.add(pudge)
        notifyDataSetChanged()
    }
}