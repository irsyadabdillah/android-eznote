package com.irzstudio.eznote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irzstudio.eznote.R
import com.irzstudio.eznote.data.Note
import kotlinx.android.synthetic.main.item_list_note.view.*

interface OnNoteListener{
    fun onDelete(note: Note)
    fun onClick(note: Note)
}

class ListNoteAdapter (val listNote : ArrayList<Note> ) : RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder>() {

    var onClickListener: OnNoteListener? = null


    inner class ListNoteViewHolder (itemview: View) : RecyclerView.ViewHolder (itemview){
        fun bind(note: Note){
            itemView.txt_tittle.text =note.tittle
            itemView.txt_content.text = note.content
            if (adapterPosition % 2 == 0){
                itemView.setBackgroundColor(itemView.context.resources.getColor(R.color.white))

            }else{
                itemView.setBackgroundColor(itemView.context.resources.getColor(R.color.grey))
            }
            itemView.img_delete.setOnClickListener {
                onClickListener?.onDelete(note)
            }
            itemView.setOnClickListener {
                onClickListener?.onClick(note)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNoteAdapter.ListNoteViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_note, parent, false)
        return ListNoteViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listNote.size
    }

    override fun onBindViewHolder(holder: ListNoteAdapter.ListNoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }
}