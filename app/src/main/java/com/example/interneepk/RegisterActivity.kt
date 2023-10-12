package com.example.interneepk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.interneepk.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            onBackPressed()
        }

        binding.btnRegister.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.etEmail.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this, "Please Enter Email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.etPassword.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this, "Please Enter Password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.etName.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this, "Please Enter Name.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.etCity.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this, "Please Enter City.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(binding.etInternship.text.toString().trim() { it <= ' ' }) -> {
                    Toast.makeText(
                        this, "Please Enter Internship.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = binding.etEmail.text.toString().trim() { it <= ' ' }
                    val password: String = binding.etPassword.text.toString().trim() { it <= ' ' }
                    val name: String = binding.etName.text.toString()
                    val city: String = binding.etCity.text.toString()
                    val internship: String = binding.etInternship.text.toString()

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this, "Registered Successfully.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent = Intent(this, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("email_id", email)
                                    intent.putExtra("name", name)
                                    intent.putExtra("city", city)
                                    intent.putExtra("internship", internship)
                                    startActivity(intent)
                                    finish()
                                } else {
                                    Toast.makeText(
                                        this, task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        )

                }

            }
        }

    }
}