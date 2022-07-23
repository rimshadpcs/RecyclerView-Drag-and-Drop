package com.rimapps.projectTsukinoMeKeikaku.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rimapps.projectTsukinoMeKeikaku.R
import com.rimapps.projectTsukinoMeKeikaku.databinding.SpeciesBinding
import com.rimapps.projectTsukinoMeKeikaku.model.Species

class SpeciesAdapter(
    private val context: Context,
    private val speciesList: ArrayList<Species>
): RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val speciesBinding: SpeciesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.species_list,parent,false)
        return SpeciesViewHolder(speciesBinding)
    }

    override fun getItemCount(): Int {
        return speciesList.size
    }
    fun getItemList() : ArrayList<Species>{
        return speciesList;
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        val animalOrdBirdViewModel = speciesList[position]
        holder.bind(animalOrdBirdViewModel)
    }

    class SpeciesViewHolder(
        private val speciesBinding: SpeciesBinding,
    ): RecyclerView.ViewHolder(speciesBinding.root){
        fun bind(speciesViewModel: Species){
            this.speciesBinding.speciesModel = speciesViewModel

            speciesBinding.executePendingBindings()
        }
    }
}