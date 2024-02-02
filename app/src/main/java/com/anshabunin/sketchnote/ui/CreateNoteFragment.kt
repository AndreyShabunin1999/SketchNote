package com.anshabunin.sketchnote.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.anshabunin.sketchnote.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)

        binding.imageBack.setOnClickListener {
            view?.findNavController()?.navigateUp()
        }

        return binding.root
    }

}