package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import timber.log.Timber
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.list.ShoeListFragment
import com.udacity.shoestore.models.Shoe
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar);

        navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.mainViewModel = viewModel

        viewModel.shoeListLiveData.observe(this, Observer {
            updateShoeList(it)
        })

        Timber.plant(Timber.DebugTree())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuLogOut -> onLogOut()
        }
        return super.onOptionsItemSelected(item)
    }

    //Use back button on Toolbar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp();
    }

    override fun onBackPressed() {
        var navHostFragment = supportFragmentManager.primaryNavigationFragment
        var f = navHostFragment!!.childFragmentManager.fragments[0];
        if (f is ShoeListFragment) {
            //the fragment on which you want to handle your back press
            Timber.d("BACK PRESSED");
            finish();
        }
        else{
            super.onBackPressed();
        }
    }

    private fun onLogOut()
    {
        navController.popBackStack(R.id.logInFragment, false)
    }

    fun addShoe(shoe : Shoe)
    {
        viewModel.addShoe(shoe)
    }

    private fun updateShoeList(shoeList : List<Shoe>)
    {
        if (shoeList.size > 0) {
            var navHostFragment = supportFragmentManager.primaryNavigationFragment
            var f = navHostFragment!!.childFragmentManager.fragments[0];
            if (f is ShoeListFragment) {
                f.showShoeList(shoeList)
            }
        }
    }
}
