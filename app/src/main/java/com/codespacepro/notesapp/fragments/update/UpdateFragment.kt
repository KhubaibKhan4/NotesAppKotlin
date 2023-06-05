package com.codespacepro.notesapp.fragments.update

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.codespacepro.notesapp.R
import com.codespacepro.notesapp.data.NoteViewModel
import com.codespacepro.notesapp.data.Notes
import com.google.android.material.textfield.TextInputEditText


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: NoteViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        val title: TextInputEditText = view.findViewById(R.id.update_title)
        val desc: TextInputEditText = view.findViewById(R.id.update_desc)
        val updateBtn: Button = view.findViewById(R.id.updateBtn)

        title.setText(args.data.title.toString())
        desc.setText(args.data.description.toString())
        mUserViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        val title_update: String = title.text.toString()
        val desc_update: String = desc.text.toString()
        val id : Int = args.data.id

        updateBtn.setOnClickListener {
            if (inputCheck(title_update, desc_update)) {
                val notes = Notes(id, title_update, desc_update)
                mUserViewModel.updateNote(notes)
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
                Toast.makeText(context, "Data Updated SuccessFully", Toast.LENGTH_LONG).show()
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