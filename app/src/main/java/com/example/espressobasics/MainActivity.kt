package com.example.espressobasics

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.espressobasics.databinding.ActivityMainBinding
import com.example.espressobasics.text.Formatter
import com.example.espressobasics.text.Formatter.Format

// Define constant key for the saved instance state
private const val DISPLAY_TEXT = "Display Text"

/**
 * This class represents the main activity of the application, which allows the user to input
 * text and select a text format option. The formatted text is then displayed on the screen.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // view binding instance
    private lateinit var format: Format // text format instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Restore display text from saved instance state, if available
        if (savedInstanceState != null) {
            binding.tvDisplay.text = savedInstanceState.getString(DISPLAY_TEXT)
        }

        // Initialize format to default
        format = Format.DEFAULT

        // Handle radio button changes for text format selection
        binding.rbDefault.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) format = Format.DEFAULT
        }

        binding.rbLowercase.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) format = Format.LOWER_CASE
        }

        binding.rbUppercase.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) format = Format.UPPER_CASE
        }

        // Handle button click for formatting and displaying text
        binding.btDisplay.setOnClickListener {
            // Hide soft keyboard and clear focus from EditText
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(it.windowToken, 0)
            binding.etText.clearFocus()

            // Get text from EditText and format it
            val text = binding.etText.text.toString()
            binding.tvDisplay.text = Formatter.format(text, format)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save display text to instance state
        outState.putString(DISPLAY_TEXT, binding.tvDisplay.text.toString())
    }
}