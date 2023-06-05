package com.codespacepro.notesapp.data

import androidx.lifecycle.LiveData

class NoteRepository(val noteDao: NoteDao) {

    val readAllData: LiveData<List<Notes>> = noteDao.readAllData()

    suspend fun addNote(notes: Notes) {
        noteDao.addNote(notes)
    }

    suspend fun deleteNote(notes: Notes) {
        noteDao.addNote(notes)
    }

    suspend fun updateNote(notes: Notes) {
        noteDao.addNote(notes)
    }

}