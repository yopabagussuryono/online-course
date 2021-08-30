package com.example.homepage.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.homepage.Activity.FragmentOnMainActivity.AqdFragment
import com.example.homepage.Activity.FragmentOnMainActivity.HomeFragment
import com.example.homepage.Activity.FragmentOnMainActivity.ProfilClassFragment
import com.example.homepage.R
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var toogle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        getFragment(HomeFragment())

       val drawer : DrawerLayout = findViewById(R.id.mainactivity)
       val navigation : NavigationView = findViewById(R.id.nav_menu)


        toogle = ActionBarDrawerToggle(this,drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigation.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> getFragment(HomeFragment())
                R.id.profile -> getFragment(ProfilClassFragment())
                R.id.clas -> getFragment(AqdFragment())

            }
            true
        }

    }

    public fun getFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container,fragment)
        fragmentTransaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}