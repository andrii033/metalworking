package com.ta.metalworking.ui.keyway

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ta.metalworking.R

class KeywayDimensionsFragment : Fragment() {

    companion object {
        fun newInstance() = KeywayDimensionsFragment()
    }

    private lateinit var viewModel: KeywayDimensionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_keyway_dimensions, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KeywayDimensionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}