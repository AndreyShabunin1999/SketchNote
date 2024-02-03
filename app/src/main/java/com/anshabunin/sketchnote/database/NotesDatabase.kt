package com.anshabunin.sketchnote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anshabunin.sketchnote.dao.NoteDao
import com.anshabunin.sketchnote.entities.Note
import dagger.hilt.android.AndroidEntryPoint

@Database(entities = [Note::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}