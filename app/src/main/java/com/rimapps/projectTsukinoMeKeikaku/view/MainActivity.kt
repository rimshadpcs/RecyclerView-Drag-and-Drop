package com.rimapps.projectTsukinoMeKeikaku.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rimapps.projectTsukinoMeKeikaku.adapter.SpeciesAdapter
import com.rimapps.projectTsukinoMeKeikaku.databinding.ActivityMainBinding
import com.rimapps.projectTsukinoMeKeikaku.viewmodel.SpeciesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var rvSpecies: RecyclerView? =null
    private var speciesAdapter: SpeciesAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val speciesViewModel = ViewModelProvider(this)[SpeciesViewModel::class.java]
        speciesViewModel.generateNames()


        speciesViewModel.speciesList.observe(this){
            speciesAdapter = SpeciesAdapter(this@MainActivity,it)
            activityMainBinding.rvSpecies.layoutManager = GridLayoutManager(this@MainActivity,2)
            activityMainBinding.rvSpecies.adapter = speciesAdapter


        }
    }
}