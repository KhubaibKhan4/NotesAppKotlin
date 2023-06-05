package com.codespacepro.notesapp.adapter

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.codespacepro.notesapp.R
import com.codespacepro.notesapp.data.Notes
import com.codespacepro.notesapp.fragments.list.ListFragment
import com.codespacepro.notesapp.fragments.list.ListFragmentDirections

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var noteList = emptyList<Notes>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textView_title)
        val desc: TextView = itemView.findViewById(R.id.textView_notes)
        val cardView: CardView = itemView.findViewById(R.id.notes_container)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.notes_sample_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.title.text = currentNote.title.toString()
        holder.desc.text = currentNote.description.toString()
        holder.cardView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentNote)
            holder.itemView.findNavController().navigate(action)
        }


    }

    fun setData(newList: List<Notes>) {
        this.noteList = newList
        notifyDataSetChanged()
    }
}