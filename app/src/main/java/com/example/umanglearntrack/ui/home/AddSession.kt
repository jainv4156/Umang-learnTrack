package com.example.umanglearntrack.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.umanglearntrack.R

import com.example.umanglearntrack.databinding.FragmentAddSessionBinding
import com.example.umanglearntrack.viewmodel.HomeViewModel
import com.example.umanglearntrack.viewmodel.ViewModelFactory


class AddSession : Fragment() {

    private var _binding: FragmentAddSessionBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: HomeViewModel
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as HomeActivity).binding.fab.visibility = View.GONE
        (activity as HomeActivity).binding.toolbar.menu.clear()
        _binding= FragmentAddSessionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context: Context = requireContext()
        navController =findNavController()
        val viewModelFactory = ViewModelFactory(context)
        viewModel= ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        binding.buttonSaveSession.setOnClickListener{
            viewModel.addSessionInDb(binding)
            navController.navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as HomeActivity).binding.fab.visibility = View.VISIBLE
        (activity as HomeActivity).invalidateMenu()

    }

}