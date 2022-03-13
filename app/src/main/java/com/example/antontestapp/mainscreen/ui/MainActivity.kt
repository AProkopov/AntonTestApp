package com.example.antontestapp.mainscreen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.antontestapp.R
import com.example.antontestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setStatusAndAppBar()

        initFragment()
    }

    private fun setStatusAndAppBar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        window.setStatusBarColor(getResources().getColor(R.color.blue1))

        with(viewBinding.toolbar) {
//            setTitle(R.string.app_name)
//            setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
//            setNavigationOnClickListener { onBackPressed() }
        }
    }

    private fun initFragment() {
        if (supportFragmentManager.findFragmentByTag(MainFragment.MAIN_FRAGMENT_KEY) == null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(
                R.id.mainContainer, MainFragment.newInstance(),
                MainFragment.MAIN_FRAGMENT_KEY
            )
            ft.commit()
        }
    }

    override fun onBackPressed() {
        //do stuff in necessary
    }
}