package com.example.mynotes.ui


import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.mynotes.R
import com.example.mynotes.db.Notedatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Basefragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
   // fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_notes.setHasFixedSize(true)
        recycler_view_notes.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        launch {
            context?.let {
                val notes=Notedatabase(it).getNoteDao().getAllNotes()
                recycler_view_notes.adapter=NotesAdapter(notes )
            }

        }

        button_add.setOnClickListener{
            val action=HomeFragmentDirections.actionAddNote()
            Navigation.findNavController(it).navigate(action)

        }
    }


}