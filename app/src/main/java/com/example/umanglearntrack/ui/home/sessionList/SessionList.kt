package com.example.umanglearntrack.ui.home.sessionList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umanglearntrack.databinding.SessionListBinding
import com.example.umanglearntrack.ui.sessionDashBoard.SessionDashboardActivity
import com.example.umanglearntrack.viewmodel.HomeViewModel
import com.example.umanglearntrack.viewmodel.ViewModelFactory

/**
     * A simple [Fragment] subclass as the default destination in the navigation.
     */
    class SessionList : Fragment(),RecyclerViewClick {
        private var _binding: SessionListBinding? = null
        private val binding get() = _binding!!

        private lateinit var sessionAdapter: SessionListItemAdapter
        private lateinit var viewModel: HomeViewModel
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = SessionListBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val recyclerView = binding.recyclerViewSessions
            sessionAdapter = SessionListItemAdapter(this)
            recyclerView.adapter = sessionAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())

            val viewModelFactory = ViewModelFactory(requireContext())
            viewModel= ViewModelProvider(this,viewModelFactory)[HomeViewModel::class.java]

            Log.d("mess","mess")
        // Observe LiveData from ViewModel'

            viewModel.allSessions.observe(viewLifecycleOwner) { sessions ->
                Log.d("mess",sessions.toString())
                sessionAdapter.setSessions(sessions)
            }
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(sessionId: String) {
        val intent = Intent(context, SessionDashboardActivity::class.java).apply {
            putExtra("SESSION_ID", sessionId)
        }
        startActivity(intent)
    }
}
