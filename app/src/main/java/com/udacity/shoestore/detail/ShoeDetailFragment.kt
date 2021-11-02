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
import com.udacity.shoestore.SharedShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private var _shoe = Shoe("", 0.0, "", "")
    lateinit var shoeViewModel : SharedShoeViewModel
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

        shoeViewModel = ViewModelProvider(requireActivity()).get(SharedShoeViewModel::class.java)

        binding.shoe = _shoe

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

        var shoe = binding.shoe
        shoeViewModel.setShoe(shoe!!)
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}