package com.example.mynotes.ui

import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.R
import com.example.mynotes.db.Note
import kotlinx.android.synthetic.main.fragment_add_note.view.*

class NotesAdapter(private  val notes:List<Note>):RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_layout,parent,false)
        )
    }

    override fun getItemCount()=notes.size
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)



    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        try {
            holder.view.edit_text_title.text = notes[position].title.toEditable()
        } catch (e: Exception) {
        }
        try {
            holder.view.edit_text_note.text=notes[position].note.toEditable()
        } catch (e: Exception) {
        }
        holder.view.setOnClickListener{
            val action=HomeFragmentDirections.actionAddNote()
            action.note=notes[position]
            Navigation.findNavController(it).navigate(action)
        }
    }

    class NoteViewHolder(val view:View):RecyclerView.ViewHolder(view)


}