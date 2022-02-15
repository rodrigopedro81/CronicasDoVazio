package com.curso.cronicasdovazio.data

import android.util.Log
import com.curso.cronicasdovazio.model.Ficha
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirestoreRepository {

    private val db = Firebase.firestore

    fun saveCharacterOntoDatabase(ficha: MutableMap<String, Any>, function: () -> Unit) {
        db.collection("Fichas")
            .document("Ficha de ${ficha["nome"]}")
            .set(ficha)
            .addOnSuccessListener { function() }
            .addOnFailureListener { Log.d("TAG", "Deu ruim!") }
    }

    fun readCharactersFromDatabase(): CollectionReference = db.collection("Fichas")

    fun deleteCharacter(ficha: Ficha?, function: () -> Unit) {
        db.collection("Fichas").document("Ficha de ${ficha?.nome}")
            .delete().addOnSuccessListener {
                function()
            }
    }
}