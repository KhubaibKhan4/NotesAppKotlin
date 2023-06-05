package com.codespacepro.notesapp.data

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Notes>>
    val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getData(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllData = repository.readAllData

    }

    fun addNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(notes)
        }
    }

    fun deleteNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(notes)
        }
    }

    fun updateNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(notes)
        }
    }

}