package com.anshabunin.sketchnote.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.anshabunin.sketchnote.databinding.FragmentMainBinding
import com.anshabunin.sketchnote.repository.DbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.imageAddNoteMain.setOnClickListener {
            view?.findNavController()?.navigate(MainFragmentDirections.openCreateNoteFragment())
        }

        return binding.root
    }
}