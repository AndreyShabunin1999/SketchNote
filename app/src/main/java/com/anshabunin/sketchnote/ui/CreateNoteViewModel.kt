package com.anshabunin.sketchnote.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshabunin.sketchnote.entities.Note
import com.anshabunin.sketchnote.repository.DbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateNoteViewModel(
    private val dbRepository: DbRepository
) : ViewModel() {

    fun insertNote(note: Note) {
        dbRepository.insertNote(note)
    }

    companion object {
        fun factory(
            dbRepository: DbRepository
        ) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CreateNoteViewModel(dbRepository) as T
            }
        }
    }
}
