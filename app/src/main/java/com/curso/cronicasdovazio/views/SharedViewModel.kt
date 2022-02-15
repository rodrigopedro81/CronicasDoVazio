package com.curso.cronicasdovazio.views

import androidx.lifecycle.ViewModel
import com.curso.cronicasdovazio.data.FirebaseAuthRepository
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.data.FirestoreRepository


class SharedViewModel : ViewModel() {

    private val repository = FirestoreRepository()

    private val firebaseAuthRepository = FirebaseAuthRepository()

    var characterSheetList : ArrayList<Ficha>? = ArrayList<Ficha>()

    var selectedCharacterSheet : Ficha = Ficha()

    fun saveCharacter(ficha: MutableMap<String, Any>, function: () -> Unit) {
        repository.saveCharacterOntoDatabase(ficha){
            function()
        }
    }

    fun signOut(function: () -> Unit) = firebaseAuthRepository.logout {
        function()
    }

    fun signInWithEmailAndPassword(email: String, password: String, function: () -> Unit) =
        firebaseAuthRepository.signInWithEmailAndPassword(email, password, function)

    fun currentUser() = firebaseAuthRepository.currentUser()

    fun readCharacters(function: () -> Unit) {
        characterSheetList= arrayListOf()
        repository.readCharactersFromDatabase().get().addOnSuccessListener {
            for (characterSheet in it.documents) {
                if (characterSheet.data?.get("accessibleBy") == firebaseAuthRepository.currentUser()?.email) {
                    characterSheetList?.add(characterSheet.toObject(Ficha::class.java)!!)
                    function()
                }
            }
        }
    }

    fun deleteCharacter(ficha: Ficha?, function: () -> Unit) {
        repository.deleteCharacter(ficha){
            function()
        }
    }

}

