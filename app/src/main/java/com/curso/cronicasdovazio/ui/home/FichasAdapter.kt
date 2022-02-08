package com.curso.cronicasdovazio.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.curso.cronicasdovazio.databinding.FichaItemBinding
import com.curso.cronicasdovazio.model.Ficha

class FichasAdapter(private val fichas:ArrayList<Ficha>?):
    RecyclerView.Adapter<FichasAdapter.FichaViewHolder>() {

    class FichaViewHolder(val binding: FichaItemBinding): RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FichaViewHolder {
        val binding = FichaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FichaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FichaViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = fichas?.size ?: 0


}