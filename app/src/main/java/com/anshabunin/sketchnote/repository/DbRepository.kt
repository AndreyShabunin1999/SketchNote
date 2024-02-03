package com.anshabunin.sketchnote.repository

import com.anshabunin.sketchnote.dao.NoteDao
import com.anshabunin.sketchnote.entities.Note
import javax.inject.Inject


class DbRepository @Inject constructor(
    private val dao: NoteDao
){
    fun getAllNotes() = dao.getAllNotes()
    fun insertNote(note: Note) = dao.insertNote(note)
    fun deleteNote(note: Note) = dao.deleteNote(note)
}
