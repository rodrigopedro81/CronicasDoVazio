package com.curso.cronicasdovazio.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuthRepository {

    private var auth: FirebaseAuth = Firebase.auth

    fun currentUser() = auth.currentUser

    fun signInWithEmailAndPassword(email: String, password: String, function : () -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            function()
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String, function: () -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            function()
        }
    }

    fun logout(function: () -> Unit) {
        auth.signOut()
        function()
    }

}