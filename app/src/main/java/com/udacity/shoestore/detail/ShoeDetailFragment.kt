package com.udacity.shoestore.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.btSave.setOnClickListener { saveClick() }
        binding.btCancel.setOnClickListener { cancelClick() }

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel

        return binding.root;
    }

    fun cancelClick() {
        findNavController().popBackStack();
    }

    fun saveClick(){
        if (binding.etShoeName.text.length == 0)
        {
            Toast.makeText(context, R.string.validate_shoe_name, Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.etCompany.text.length == 0)
        {
            Toast.makeText(context, R.string.validate_company, Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.etSize.text.length == 0)
        {
            Toast.makeText(context, R.string.validate_shoe_size, Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.etDescription.text.length == 0)
        {
            Toast.makeText(context, R.string.validate_description, Toast.LENGTH_SHORT).show()
            return
        }

        var shoe = binding.shoeDetailViewModel?.shoe?.value
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment(shoe))
    }
}