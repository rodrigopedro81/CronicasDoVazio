package com.curso.cronicasdovazio.ui.dashboard

import androidx.lifecycle.ViewModel
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.model.Repository

class SharedViewModel : ViewModel() {


    val fichaList : ArrayList<Ficha> = arrayListOf()

    private val repository = Repository()

    fun saveCharacter(ficha: HashMap<String, Any>) {
        repository.saveCharacterOntoDatabase(ficha)
    }

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

