package com.anshabunin.sketchnote.database

import androidx.room.Database
import androidx.room.DatabaseView
import androidx.room.RoomDatabase
import com.anshabunin.sketchnote.dao.NoteDao
import com.anshabunin.sketchnote.entities.Note

@Database(entities = [Note::class], version = 1)
@DatabaseView
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}