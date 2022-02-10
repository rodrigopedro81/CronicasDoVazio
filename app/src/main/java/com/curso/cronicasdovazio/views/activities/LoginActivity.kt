package com.curso.cronicasdovazio.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.curso.cronicasdovazio.data.FirebaseAuthRepository
import com.curso.cronicasdovazio.databinding.ActivityLoginBinding
import com.curso.cronicasdovazio.utils.DialogBuilder
import com.curso.cronicasdovazio.views.SharedViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val dialogBuilder = DialogBuilder()

    private lateinit var sharedViewModel: SharedViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        sharedViewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)
        binding.loginButton.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            sharedViewModel.signInWithEmailAndPassword(email, password){
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        binding.registerButton.setOnClickListener {
            dialogBuilder.registerDialog(this) {
                Toast.makeText(
                    this,
                    "Cadastro feito com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
            }.show()
        }
    }

    override fun onStart() {
        super.onStart()
        if(sharedViewModel.currentUser() != null){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}