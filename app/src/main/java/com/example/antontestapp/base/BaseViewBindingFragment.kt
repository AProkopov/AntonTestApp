package com.medisafe.pillshapetest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerFragment

abstract class BaseViewBindingFragment<Binding : ViewBinding> : DaggerFragment() {
    val viewBinding: Binding get() = binding ?: throw IllegalStateException("Binding cannot be null")
    private var binding: Binding? = null

    abstract fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachedToRoot: Boolean,
        savedInstanceState: Bundle? = null
    ): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = createViewBinding(inflater, container, false, savedInstanceState).also { binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}