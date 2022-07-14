package com.task.ui.components.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.task.R
import com.task.databinding.ActivityHomeBinding
import com.task.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    var binding: ActivityHomeBinding? = null
    private var mNavController: NavController? = null
    private var mNavHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NavigationUI.setupWithNavController(binding!!.appBarMain.bottomNavigation, mNavController!!)
        val ids: MutableList<Int> = ArrayList()
        ids.add(R.id.homeFragment)
        ids.add(R.id.notesFragment)
        ids.add(R.id.videoFragment)
        binding!!.appBarMain.bottomNavigation.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                if (item.itemId == mNavController!!.currentBackStackEntry!!.destination.id) return@OnNavigationItemSelectedListener false
                for (`val` in ids) {
                    if (`val` == item.itemId) {
                        mNavController!!.navigate(
                            `val`, null, NavOptions.Builder()
                                .setLaunchSingleTop(true)
                                .setPopUpTo(mNavController!!.currentDestination!!.id, true)
                                .build()
                        )
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
        mNavController!!.addOnDestinationChangedListener { controller: NavController?, destination: NavDestination, arguments: Bundle? ->
            if (ids.indexOf(destination.id) != -1) {
                mNavController!!.graph.startDestination = destination.id
            }
        }
    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = DataBindingUtil.setContentView(this@HomeActivity, R.layout.activity_home)
        binding?.lifecycleOwner = this
        mNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        mNavController = mNavHostFragment!!.navController
    }

    override fun init() {

    }

}