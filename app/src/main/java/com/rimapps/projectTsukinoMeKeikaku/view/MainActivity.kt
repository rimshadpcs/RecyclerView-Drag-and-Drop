package com.rimapps.projectTsukinoMeKeikaku.view

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rimapps.projectTsukinoMeKeikaku.adapter.SpeciesAdapter
import com.rimapps.projectTsukinoMeKeikaku.databinding.ActivityMainBinding
import com.rimapps.projectTsukinoMeKeikaku.model.Species
import com.rimapps.projectTsukinoMeKeikaku.viewmodel.SpeciesViewModel

class MainActivity : AppCompatActivity(), SpeciesAdapter.OnItemLongClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var speciesAdapter: SpeciesAdapter? =null

    private lateinit var draggingItem: View
    private lateinit var selectedItemModel: Species
    private val dragMessage = "Added"

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
            speciesAdapter?.setOnItemLongClickListener(this)
        }

        activityMainBinding.tvBirds.setOnDragListener(speciesDragListener)
        activityMainBinding.tvAnimals.setOnDragListener(speciesDragListener)
    }

    @SuppressLint("NotifyDataSetChanged")
    private val speciesDragListener = View.OnDragListener { v, dragEvent ->
        draggingItem
        val dropArea = v as TextView
        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED->{
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {

                if (dropArea.text==activityMainBinding.tvAnimals.text){
                    activityMainBinding.tvAnimals.alpha = 0.3F
                }
                else{
                    activityMainBinding.tvBirds.alpha = 0.3f
                }
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

                speciesAdapter?.getItemList()?.remove(selectedItemModel)
                speciesAdapter?.notifyDataSetChanged()

                if (dropArea.text == selectedItemModel.type) {

                    Toast.makeText(this@MainActivity, "Right answer",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Wrong answer",Toast.LENGTH_SHORT).show()
                }
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {

                if(speciesAdapter?.getItemList()?.size == 0){
                    Toast.makeText(this@MainActivity, "Finished!", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else ->{
                false
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onItemLongClick(view: View, species: Species) {
        selectedItemModel = species;
        val item = ClipData.Item(dragMessage)
        val dragData = ClipData(
            dragMessage,
            arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
            item
        )
        val myShadow = MyDragShadowBuilder(view)
        view.startDragAndDrop(dragData, myShadow, null, 0)
        draggingItem = view
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