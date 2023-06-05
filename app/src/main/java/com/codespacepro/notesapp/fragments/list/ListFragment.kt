package com.codespacepro.notesapp.fragments.list

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.codespacepro.notesapp.R
import com.codespacepro.notesapp.adapter.MyAdapter
import com.codespacepro.notesapp.data.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private val adapter by lazy { MyAdapter() }
    private lateinit var mNoteViewModel: NoteViewModel

    @SuppressLint("MissingInflatedId")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        mNoteViewModel.readAllData.observe(viewLifecycleOwner, Observer { notes ->
            if (!notes.isEmpty()) {
                adapter.setData(notes)
            } else {

            }
        })

        val addBtn: FloatingActionButton = view.findViewById(R.id.floatingActionButton)

        addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }



        return view
    }


}