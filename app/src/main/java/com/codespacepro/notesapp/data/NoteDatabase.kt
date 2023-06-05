package com.codespacepro.notesapp.data

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: NoteDatabase? = null

        fun getData(context: Context): NoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, NoteDatabase::class.java, "notes_database")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}