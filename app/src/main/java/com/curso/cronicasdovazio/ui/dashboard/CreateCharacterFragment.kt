package com.curso.cronicasdovazio.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.curso.cronicasdovazio.databinding.FragmentCreateCharacterBinding

class CreateCharacterFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel
    private var _binding: FragmentCreateCharacterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)
        _binding = FragmentCreateCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val campos = listOf(
            binding.campoNome,
            binding.campoIdade,
            binding.campoRaca,
            binding.campoArquetipo,
            binding.campoSexo,
            binding.campoVantagem,
            binding.campoForca,
            binding.campoAgilidade,
            binding.campoVigor,
            binding.campoCarisma,
            binding.campoAutoConfianca,
            binding.campoCoragem,
            binding.campoDestreza,
            binding.campoVisao,
            binding.campoPercepcao,
            binding.campoFoco,
            binding.campoInteligencia,
            binding.campoSabedoria
        )
        var ficha: HashMap<String, Any> = hashMapOf()
        binding.buttonSaveCharacter.setOnClickListener {
            campos.forEach { campo ->
                if (campo.text.isNotEmpty()) {
                    ficha[campo.hint.toString()] = campo.text.toString()
                }
            }
            sharedViewModel.saveCharacter(ficha)
            ficha = hashMapOf()
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}