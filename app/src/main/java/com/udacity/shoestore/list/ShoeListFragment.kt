package com.udacity.shoestore.list

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        binding.fabAdd.setOnClickListener { goShoeDetailScreen() }

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        var shoe = ShoeListFragmentArgs.fromBundle(arguments!!).shoeDetail
        if (shoe != null)
        {
            (activity as MainActivity).addShoe(shoe)
        }

        setHasOptionsMenu(true)

        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuLogOut -> onLogOut()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onLogOut()
    {
        findNavController().popBackStack(R.id.logInFragment, false)
    }

    fun goShoeDetailScreen() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }

    fun createShoeCardView(shoe: Shoe) : View
    {
        lateinit var shoeCardBinding: ShoeCardBinding
        shoeCardBinding  = DataBindingUtil.inflate(layoutInflater,
            R.layout.shoe_card, null, false)

        shoeCardBinding.tvShoeName.text = shoe.name
        shoeCardBinding.tvSize.text = String.format("%.0f", shoe.size)
        shoeCardBinding.tvCompany.text = shoe.company
        shoeCardBinding.tvDescription.text = shoe.description

        return shoeCardBinding.root;
    }

    fun showShoeList(shoeList : List<Shoe>)
    {
        for(shoe in shoeList)
        {
            //var shoeRowView = createShoeView(shoe)
            var shoeRowView = createShoeCardView(shoe)
            binding.llListShoe.addView(shoeRowView)
        }

    }

}