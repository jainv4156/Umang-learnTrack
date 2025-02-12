package com.example.umanglearntrack.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.umanglearntrack.R
import com.example.umanglearntrack.databinding.LoginviewBinding
import com.example.umanglearntrack.ui.home.HomeActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginView : Fragment() {

    private var _binding: LoginviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LoginviewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignup.setOnClickListener {
            findNavController().navigate(R.id.SignupView)
        }
        binding.btnLogin.setOnClickListener{
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}