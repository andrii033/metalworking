package com.ta.metalworking.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat.getSystemService
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.ta.metalworking.R
import com.ta.metalworking.databinding.FragmentHomeBinding
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.sin

class HomeFragment : Fragment(),View.OnClickListener {

    private lateinit var resTextView: TextView
    private lateinit var diametrTextView: EditText
    private lateinit var numberOfHolesTextView: EditText
    private lateinit var button: Button

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle



    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using the binding object
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access the views from the binding object
        diametrTextView = binding.editTextDiametr
        numberOfHolesTextView = binding.editTextNumberHoles
        resTextView = binding.textViewRes
        button = binding.button
        button.setOnClickListener(this)

        numberOfHolesTextView.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // This block will be executed when the "Done" or "OK" button is pressed on the keyboard
                // Place the code you want to execute here
                // For example, trigger a button click
                button.performClick() // Assuming 'button' is the Button you want to click
                return@setOnEditorActionListener true
            }
            false
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        val diametrText = diametrTextView.text.toString()
        val diametr: Double? = diametrText.toDoubleOrNull()

        val numberHoles = numberOfHolesTextView.text.toString()
        val quantity: Double? = numberHoles.toDoubleOrNull()

        if (diametr == null) {
            // Diametr is null (empty), focus on diametrText EditText
            diametrTextView.requestFocus()

            // Show the soft keyboard
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(diametrTextView, InputMethodManager.SHOW_IMPLICIT)
            return
        }
        if (numberHoles == null) {
            // Diametr is null (empty), focus on diametrText EditText
            numberOfHolesTextView.requestFocus()

            // Show the soft keyboard
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(numberOfHolesTextView, InputMethodManager.SHOW_IMPLICIT)
            return
        }

        val r = diametr?.times(sin(360 / quantity!! / 2 * PI / 180))
        val decimalFormat = DecimalFormat("#.###")
        resTextView.text = decimalFormat.format(r)
    }

}