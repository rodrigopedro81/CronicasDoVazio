package com.curso.cronicasdovazio.views.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.curso.cronicasdovazio.databinding.FragmentCreateCharacterBinding
import com.curso.cronicasdovazio.utils.*
import com.curso.cronicasdovazio.views.SharedViewModel

class CreateCharacterFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel
    private var _binding: FragmentCreateCharacterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val dialogBuilder = DialogBuilder()

    lateinit var expertisePlusButtons : List<ImageView>
    lateinit var expertiseMinusButtons : List<ImageView>
    lateinit var expertiseValueTextViews : List<TextView>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel =
            ViewModelProvider(this).get(SharedViewModel::class.java)
        _binding = FragmentCreateCharacterBinding.inflate(inflater, container, false)
        val root: View = binding.root
        expertisePlusButtons = mapPlusButtons()
        expertiseMinusButtons = mapMinusButtons()
        expertiseValueTextViews = mapTextViews()

        binding.buttonSaveCharacter.setOnClickListener {
            mapCharacterSheet()
        }

        expertisePlusButtons.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val textViewText = expertiseValueTextViews.get(index).text.toString()
                expertiseValueTextViews.get(index).text = textViewText.plusOne()
            }
        }

        expertiseMinusButtons.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val textViewText = expertiseValueTextViews.get(index).text.toString()
                expertiseValueTextViews.get(index).text = textViewText.minusOne()
            }
        }

        return root
    }

    private fun mapCharacterSheet() {
        var characterSheet: MutableMap<String, Any> = mutableMapOf()
        val fieldsArray = mapFields()

        if (testAnyFieldEmpty(fieldsArray).not()) {
            fieldsArray.forEach { field ->
                characterSheet[field.hint.toString()] = field.text.toString()
            }
            expertiseValueTextViews.forEachIndexed { index, textView ->
                characterSheet[Constants.listOfExpertises[index]] = textView.text.toString()
            }
            characterSheet["accessibleBy"] = sharedViewModel.currentUser()?.email.toString()
            sharedViewModel.saveCharacter(characterSheet)
            characterSheet = mutableMapOf()
        } else {
            dialogBuilder.showSimpleWarningDialog(requireActivity(), "Aviso", "Preencha todos os campos!")
        }
    }

    private fun testAnyFieldEmpty(campos: List<EditText>): Boolean {
        var result = false
        campos.forEach { campo ->
            if (campo.text.isNullOrEmpty()) {
                result = true
                return@forEach
            }
        }
        return result
    }

    private fun mapTextViews(): List<TextView> {
        return listOf(
            binding.textViewArremessoValue,
            binding.textViewArqueariaValue,
            binding.textViewBloqueioValue,
            binding.textViewMontariaValue,
            binding.textViewLutaValue,
            binding.textViewArmaleveValue,
            binding.textViewArmapesadaValue,
            binding.textViewAcrobaciaValue,
            binding.textViewEsportesValue
//            binding.textViewArcanoValue,
//            binding.textViewMedicinaValue,
//            binding.textViewHistoriaValue,
//            binding.textViewSentidosValue,
//            binding.textViewSegurancaValue,
//            binding.textViewSobrevivenciaValue,
//            binding.textViewConscienciaValue,
//            binding.textViewFurtividadeValue,
//            binding.textViewPlanejamentoValue,
//            binding.textViewIntimidarValue,
//            binding.textViewEnganarValue,
//            binding.textViewEmpatiaValue,
//            binding.textViewPerformanceValue,
//            binding.textViewLiderancaValue,
//            binding.textViewAtuacaoValue,
//            binding.textViewInterrogatorioValue,
//            binding.textViewJogoValue,
//            binding.textViewBarganhaValue
        )
    }

    private fun mapMinusButtons(): List<ImageView> {
        return listOf(
            binding.imageViewArremessoMinus,
            binding.imageViewArqueariaMinus,
            binding.imageViewBloqueioMinus,
            binding.imageViewMontariaMinus,
            binding.imageViewLutaMinus,
            binding.imageViewArmaleveMinus,
            binding.imageViewArmapesadaMinus,
            binding.imageViewAcrobaciaMinus,
            binding.imageViewEsportesMinus
//            binding.imageViewArcanoMinus,
//            binding.imageViewMedicinaMinus,
//            binding.imageViewHistoriaMinus,
//            binding.imageViewSentidosMinus,
//            binding.imageViewSegurancaMinus,
//            binding.imageViewSobrevivenciaMinus,
//            binding.imageViewConscienciaMinus,
//            binding.imageViewFurtividadeMinus,
//            binding.imageViewPlanejamentoMinus,
//            binding.imageViewIntimidarMinus,
//            binding.imageViewEnganarMinus,
//            binding.imageViewEmpatiaMinus,
//            binding.imageViewPerformanceMinus,
//            binding.imageViewLiderancaMinus,
//            binding.imageViewAtuacaoMinus,
//            binding.imageViewInterrogatorioMinus,
//            binding.imageViewJogoMinus,
//            binding.imageViewBarganhaMinus
        )
    }

    private fun mapPlusButtons(): List<ImageView> {
        return listOf(
            binding.imageViewArremessoPlus,
            binding.imageViewArqueariaPlus,
            binding.imageViewBloqueioPlus,
            binding.imageViewMontariaPlus,
            binding.imageViewLutaPlus,
            binding.imageViewArmalevePlus,
            binding.imageViewArmapesadaPlus,
            binding.imageViewAcrobaciaPlus,
            binding.imageViewEsportesPlus
//            binding.imageViewArcanoPlus,
//            binding.imageViewMedicinaPlus,
//            binding.imageViewHistoriaPlus,
//            binding.imageViewSentidosPlus,
//            binding.imageViewSegurancaPlus,
//            binding.imageViewSobrevivenciaPlus,
//            binding.imageViewConscienciaPlus,
//            binding.imageViewFurtividadePlus,
//            binding.imageViewPlanejamentoPlus,
//            binding.imageViewIntimidarPlus,
//            binding.imageViewEnganarPlus,
//            binding.imageViewEmpatiaPlus,
//            binding.imageViewPerformancePlus,
//            binding.imageViewLiderancaPlus,
//            binding.imageViewAtuacaoPlus,
//            binding.imageViewInterrogatorioPlus,
//            binding.imageViewJogoPlus,
//            binding.imageViewBarganhaPlus
        )
    }

    private fun mapFields(): List<EditText> {
        return listOf(
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapCharacterSheet()
        _binding = null
    }
}
