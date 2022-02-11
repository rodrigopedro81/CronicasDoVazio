package com.curso.cronicasdovazio.views.characterSheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curso.cronicasdovazio.databinding.FragmentCharacterListBinding
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.views.SharedViewModel

class CharacterListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var _binding: FragmentCharacterListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var listAdapter = FichasAdapter(arrayListOf(), this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)

        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        updateUI()
        return root
    }

    private fun updateUI() {
        viewModel.readCharacters {
            listAdapter = FichasAdapter(viewModel.characterSheetList, this)
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        binding.fichasRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }

    fun deleteCharacter(ficha: Ficha?) {
        viewModel.deleteCharacter(ficha)
        updateUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}