package com.nibm.bristrohotelandrestaurantbookingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val backButton: ImageView = findViewById(R.id.backButton)
        val profileImage: ImageView = findViewById(R.id.profileImage)
        val changeProfilePicture: ImageView = findViewById(R.id.changeProfilePicture)
        val nameField: EditText = findViewById(R.id.nameField)
        val emailField: EditText = findViewById(R.id.emailField)
        val passwordField: EditText = findViewById(R.id.passwordField)
        val contactField: EditText = findViewById(R.id.contactField)
        val countryField: EditText = findViewById(R.id.countryField)
        val saveChangesButton: Button = findViewById(R.id.saveChangesButton)


        backButton.setOnClickListener {
            finish()
        }

        changeProfilePicture.setOnClickListener {
            Toast.makeText(this, "Change profile picture functionality coming soon!", Toast.LENGTH_SHORT).show()
        }


        saveChangesButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val contact = contactField.text.toString().trim()
            val country = countryField.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || contact.isEmpty() || country.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields!", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email format!", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
