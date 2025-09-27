package com.example.signup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // connect to XML layout

        val usernameField = findViewById<EditText>(R.id.editTextUsername)
        val emailField = findViewById<EditText>(R.id.editTextEmail)
        val passwordField = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordField = findViewById<EditText>(R.id.editTextConfirmPassword)
        val birthdateField = findViewById<TextInputEditText>(R.id.editTextBirthdate)
        val genderGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)

        birthdateField.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select birthdate")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {
                birthdateField.setText(datePicker.headerText)
            }

            datePicker.show(supportFragmentManager, "birthdate_picker")
        }

        // On sign up button tap
        signUpButton.setOnClickListener {
            val username = usernameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val confirmPassword = confirmPasswordField.text.toString()

            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                val radioButton = findViewById<RadioButton>(selectedGenderId)
                radioButton.text.toString()
            } else {
                "Not Selected"
            }

            if (password != confirmPassword) {
                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                // Show all input values in a Toast
                Toast.makeText(
                    this,
                    "Signing in, welcome $username",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
