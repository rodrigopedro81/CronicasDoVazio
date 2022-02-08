package com.curso.cronicasdovazio.ui.dashboard

import androidx.lifecycle.ViewModel
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.model.Repository

class SharedViewModel : ViewModel() {


    val fichaList : ArrayList<Ficha> = arrayListOf()

    fun saveCharacter(ficha: HashMap<String, Any>) {
        Repository.saveCharacterOntoDatabase(ficha)
    }

    fun readCharacters() {
        Repository.readCharactersFromDatabase().addSnapshotListener { collection, _ ->
            if (collection != null) {
                for (document in collection.documents) {
                    document.toObject(Ficha::class.java)?.let {
                        fichaList.add(it)
                    }
                }
            }
        }


    }


}

