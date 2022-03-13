package com.example.antontestapp.mainscreen.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.antontestapp.databinding.FragmentMainBinding
import com.medisafe.pillshapetest.base.BaseViewBindingFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : BaseViewBindingFragment<FragmentMainBinding>() {

    companion object {
        const val MAIN_FRAGMENT_KEY = "MAIN_FRAGMENT_KEY"

        fun newInstance(): MainFragment = MainFragment()
    }

    @Inject
    lateinit var ui: MainUi

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachedToRoot: Boolean,
        savedInstanceState: Bundle?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, attachedToRoot)
    }

    override fun onStart() {
        super.onStart()
//        ui.testGetVm()
    }
}