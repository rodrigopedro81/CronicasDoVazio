package com.curso.cronicasdovazio.views

import androidx.lifecycle.ViewModel
import com.curso.cronicasdovazio.data.FirebaseAuthRepository
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.data.FirestoreRepository

class SharedViewModel : ViewModel() {

    private val repository = FirestoreRepository()

    private val firebaseAuthRepository = FirebaseAuthRepository()

    val fichaList : ArrayList<Ficha> = arrayListOf()

    fun saveCharacter(ficha: HashMap<String, Any>) = repository.saveCharacterOntoDatabase(ficha)

    fun signOut(function: () -> Unit) = firebaseAuthRepository.logout{
        function()
    }

    fun signInWithEmailAndPassword(email: String, password: String, function : () -> Unit) =
        firebaseAuthRepository.signInWithEmailAndPassword(email, password, function)


    fun currentUser() = firebaseAuthRepository.currentUser()

//    fun readCharacters() {
//        repository.readCharactersFromDatabase().addSnapshotListener { collection, _ ->
//            if (collection != null) {
//                for (document in collection.documents) {
//                    document.toObject(Ficha::class.java)?.let {
//                        fichaList.add(it)
//                    }
//                }
//            }
//        }
//    }


}

