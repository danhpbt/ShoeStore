package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LogInFragment : Fragment() {

    private lateinit var viewModel: LogInViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)
        binding.logInViewModel = viewModel

        binding.btSignin.setOnClickListener { goWelcomeScreen ()}
        binding.btExistingAcc.setOnClickListener { goWelcomeScreen()  }

        return binding.root;
    }

    fun goWelcomeScreen() {
        findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToWelcomeFragment())
    }
}