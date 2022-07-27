package com.rimapps.projectTsukinoMeKeikaku.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rimapps.projectTsukinoMeKeikaku.adapter.SpeciesAdapter
import com.rimapps.projectTsukinoMeKeikaku.databinding.ActivityMainBinding
import com.rimapps.projectTsukinoMeKeikaku.viewmodel.SpeciesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var speciesAdapter: SpeciesAdapter? =null

    private lateinit var draggingItem: View

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

            activityMainBinding.tvBirds.setOnDragListener(speciesDragListener)
            activityMainBinding.tvAnimals.setOnDragListener(speciesDragListener)

        }
    }


    private val speciesDragListener = View.OnDragListener { v, drageEvent ->
        draggingItem
        when(drageEvent.action){
            DragEvent.ACTION_DRAG_STARTED->{

                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                activityMainBinding.tvAnimals.alpha = 0.3F
                activityMainBinding.tvBirds.alpha = 0.3f

                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                activityMainBinding.tvAnimals.alpha = 0.5F
                activityMainBinding.tvBirds.alpha = 0.5f
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                activityMainBinding.tvAnimals.alpha = 1.0F
                activityMainBinding.tvBirds.alpha = 1.0f

            true
        }
            DragEvent.ACTION_DROP -> {

                activityMainBinding.tvAnimals.alpha = 1.0F
                activityMainBinding.tvBirds.alpha = 1.0f
                true

            }
            else -> {
                false
            }
        }
    }
    private class MyDragShadowBuilder(v: View): View.DragShadowBuilder(v){

        private val shadow  = ColorDrawable(Color.CYAN)
        override fun onProvideShadowMetrics(outShadowSize: Point?, outShadowTouchPoint: Point?) {
            val width: Int = view.width
            val height: Int = view.height
            shadow.setBounds(0, 0, width, height)
            outShadowSize?.set(width, height)
            outShadowTouchPoint?.set(width, height)

        }

        override fun onDrawShadow(canvas: Canvas?) {
            super.onDrawShadow(canvas)
        }
    }
}