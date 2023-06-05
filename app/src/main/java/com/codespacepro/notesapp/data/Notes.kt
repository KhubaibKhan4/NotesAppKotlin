package com.codespacepro.notesapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
) : Parcelable