package com.curso.cronicasdovazio.model

import android.util.Log
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object Repository {

    private val db = Firebase.firestore


    fun saveCharacterOntoDatabase(ficha: HashMap<String, Any>) {
        db.collection("Fichas")
            .document("Ficha de ${ficha["nome"]}")
            .set(ficha)
            .addOnSuccessListener { Log.d("TAG", "Deu certo!") }
            .addOnFailureListener { Log.d("TAG", "Deu ruim!") }
    }

    fun readCharactersFromDatabase(): CollectionReference = db.collection("Fichas")

}