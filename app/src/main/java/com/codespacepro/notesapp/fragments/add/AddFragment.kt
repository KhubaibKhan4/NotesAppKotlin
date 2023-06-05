package com.codespacepro.notesapp.fragments.add

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.codespacepro.notesapp.R
import com.codespacepro.notesapp.data.NoteViewModel
import com.codespacepro.notesapp.data.Notes
import com.google.android.material.textfield.TextInputEditText


class AddFragment : Fragment() {

    private lateinit var mNoteViewModel: NoteViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val title: TextInputEditText = view.findViewById(R.id.add_title)
        val desc: TextInputEditText = view.findViewById(R.id.add_desc)
        val addBtn: Button = view.findViewById(R.id.addBtn)


        mNoteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        addBtn.setOnClickListener {

            val sample_title: String = title.text.toString()
            val sample_desc: String = desc.text.toString()

            if (inputCheck(sample_title, sample_desc)) {
                val notes = Notes(0, sample_title,sample_desc)
                mNoteViewModel.addNote(notes)
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
                Toast.makeText(context, "Data Added SuccessFully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

    private fun inputCheck(title: String, desc: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(desc))
    }
}