package com.rimapps.projectTsukinoMeKeikaku.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rimapps.projectTsukinoMeKeikaku.model.Species

class SpeciesViewModel: ViewModel {

    constructor(): super()

    var speciesList = MutableLiveData<ArrayList<Species>>()

    fun generateNames(){

        val speciesList = ArrayList<Species>()

        val species1 = Species("Dog","Animals")
        val species3 = Species("Cat","Animals")
        val species5 = Species("Lion","Animals")
        val species7 = Species("Tiger","Animals")
        val species9 = Species("Bear","Animals")
        val species10 = Species("Monkey","Animals")

        val species2 = Species("Sparrow","Birds")
        val species4 = Species("Dove","Birds")
        val species6 = Species("Goose","Birds")
        val species8 = Species("Parrot","Birds")
        val species11 = Species("Hen","Birds")
        val species12 = Species("Eagle","Birds")

        speciesList.add(species1)
        speciesList.add(species2)
        speciesList.add(species3)
        speciesList.add(species4)
        speciesList.add(species5)
        speciesList.add(species6)
        speciesList.add(species7)
        speciesList.add(species8)
        speciesList.add(species9)
        speciesList.add(species10)
        speciesList.add(species11)
        speciesList.add(species12)

        this.speciesList.value = speciesList

    }


}