package com.curso.cronicasdovazio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.curso.cronicasdovazio.databinding.FragmentCharacterListBinding
import com.curso.cronicasdovazio.model.Ficha
import com.curso.cronicasdovazio.ui.dashboard.SharedViewModel

class CharacterListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var _binding: FragmentCharacterListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)

        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel.readCharacters()
        val fichas = viewModel.fichaList
        val listAdapter = FichasAdapter(fichas as ArrayList<Ficha>)
        binding.fichasRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}