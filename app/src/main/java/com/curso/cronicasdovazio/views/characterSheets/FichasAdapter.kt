package com.curso.cronicasdovazio.views.characterSheets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curso.cronicasdovazio.databinding.FichaItemBinding
import com.curso.cronicasdovazio.model.Ficha

class FichasAdapter(
    private val fichas: ArrayList<Ficha>?,
    private val fragment: CharacterListFragment?
) :
    RecyclerView.Adapter<FichasAdapter.FichaViewHolder>() {

    class FichaViewHolder(val binding: FichaItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FichaViewHolder {
        val binding = FichaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FichaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FichaViewHolder, position: Int) {
        holder.binding.textViewCharacterName.text = fichas?.get(position)?.nome
        holder.binding.buttonDelete.setOnClickListener {
            fragment?.deleteCharacter(fichas?.get(position))
        }
    }

    override fun getItemCount(): Int = fichas?.size ?: 0


}