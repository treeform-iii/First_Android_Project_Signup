package com.example.signup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // connect to XML layout

        val usernameField = findViewById<EditText>(R.id.editTextUsername)
        val emailField = findViewById<EditText>(R.id.editTextEmail)
        val passwordField = findViewById<EditText>(R.id.editTextPassword)
        val signUpButton = findViewById<Button>(R.id.buttonSignUp)
        val birthdateField = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextBirthdate)

        birthdateField.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select birthdate")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener { selection ->
                // selection is a timestamp (milliseconds since epoch)
                birthdateField.setText(datePicker.headerText) // headerText = nice formatted date
            }

            datePicker.show(supportFragmentManager, "birthdate_picker")
        }


        signUpButton.setOnClickListener {
            val username = usernameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // For now, just show a Toast
            Toast.makeText(
                this,
                "Signing up with:\n$username\n$email\n$password",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
