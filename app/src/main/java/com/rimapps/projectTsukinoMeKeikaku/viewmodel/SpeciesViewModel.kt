package com.rimapps.projectTsukinoMeKeikaku.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rimapps.projectTsukinoMeKeikaku.model.Species

class SpeciesViewModel: ViewModel {

    constructor(): super()

    var speciesList = MutableLiveData<ArrayList<Species>>()

    fun generateNames(){

        val speciesList = ArrayList<Species>()

        val species1 = Species("Dog","Animal")
        val species3 = Species("Cat","Animal")
        val species5 = Species("Lion","Animal")
        val species7 = Species("Tiger","Animal")
        val species9 = Species("Bear","Animal")
        val species10 = Species("Monkey","Animal")

        val species2 = Species("Sparrow","Bird")
        val species4 = Species("Dove","Bird")
        val species6 = Species("Goose","Bird")
        val species8 = Species("Parrot","Bird")
        val species11 = Species("Hen","Bird")
        val species12 = Species("Eagle","Bird")

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