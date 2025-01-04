package com.nibm.bristrohotelandrestaurantbookingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.CollectionReference

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    private lateinit var signInTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Find the views by ID
        nameEditText = findViewById(R.id.editTextName)
        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)
        confirmPasswordEditText = findViewById(R.id.editTextConfirmPassword)

        signInTextView = findViewById(R.id.textViewSignIn)

        // Set up the Sign In click listener
        signInTextView.setOnClickListener {
            // Navigate to Sign In Activity
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        // Set up the Sign Up button click listener
        findViewById<View>(R.id.buttonSignUp).setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (password == confirmPassword) {
                // Call the signUp function
                signUpUser(name, email, password)
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUpUser(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // User signed up successfully, store user data in Firestore
                    val user = hashMapOf(
                        "name" to name,
                        "email" to email
                    )

                    // Store the user data in Firestore
                    val userRef: CollectionReference = db.collection("users")
                    userRef.document(auth.currentUser!!.uid).set(user)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                            // Navigate to the next activity (e.g., com.nibm.bristrohotelandrestaurantbookingapp.MainActivity)
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    // If sign up fails, display a message to the user
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
