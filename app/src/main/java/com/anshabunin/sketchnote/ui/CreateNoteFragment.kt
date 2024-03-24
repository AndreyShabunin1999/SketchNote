package com.anshabunin.sketchnote.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.anshabunin.sketchnote.R
import com.anshabunin.sketchnote.databinding.FragmentCreateNoteBinding
import com.anshabunin.sketchnote.entities.Note
import com.anshabunin.sketchnote.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {

    @Inject
    lateinit var dbRepository: DbRepository

    private val viewModel: CreateNoteViewModel by viewModels {
        CreateNoteViewModel.factory(dbRepository)
    }

    private lateinit var binding: FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)

        with(binding) {
            imageBack.setOnClickListener {
                view?.findNavController()?.navigateUp()
            }
            textDateTime.text = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault())
                .format(Date())
            imageSave.setOnClickListener {
                saveNote()
            }
        }

        return binding.root
    }

    private fun saveNote() {
        if (binding.inputNoteTitle.text.trim().isEmpty()) {
            Toast.makeText(
                requireContext(),
                resources.getString(R.string.warning_empty_note_title),
                Toast.LENGTH_SHORT
            ).show()
            return
        } else if (binding.inputNoteSubtitle.text.trim().isEmpty()
            || binding.inputNoteText.text.trim().isEmpty()
        ) {
            Toast.makeText(
                requireContext(),
                resources.getString(R.string.warning_empty_note_text),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val note = Note()
        note.title = binding.inputNoteTitle.text.toString()
        note.subtitle = binding.inputNoteSubtitle.text.toString()
        note.noteText = binding.inputNoteText.text.toString()
        note.dateTime = binding.textDateTime.text.toString()
        Log.e("NOTE", "${note}")
        viewModel.insertNote(note)
    }

}