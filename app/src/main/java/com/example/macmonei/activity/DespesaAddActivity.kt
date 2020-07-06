package com.example.macmonei.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.heros.activity.adapter.DespesaAdapter
import com.example.macmonei.R
import com.example.macmonei.database.AppDatabase
import com.example.macmonei.database.dao.DespesaDao
import com.example.macmonei.model.Despesa
import com.google.android.material.floatingactionbutton.FloatingActionButton

import kotlinx.android.synthetic.main.activity_main.*

class DespesaAddActivity : AppCompatActivity() {
    private lateinit var despesaDao: DespesaDao
    private lateinit var fabAddDespesa : FloatingActionButton
    private lateinit var tvDesc : TextView
    private lateinit var tvPrice : TextView
    private lateinit var tvCategory : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setWidgets()
        setFields()
        setEvents()
    }

    private fun setWidgets(){
        fabAddDespesa = findViewById(R.id.fab_done_add_despesa)
        tvCategory = findViewById(R.id.input_categoria_despesa)
        tvDesc = findViewById(R.id.input_descricao_despesa)
        tvPrice = findViewById(R.id.input_price_despesa)

        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "macmonei-database")
            .allowMainThreadQueries()
            .build()
        despesaDao = database.despesaDao()

    }

    private fun setFields(){

    }

    private fun setEvents(){
        fabAddDespesa.setOnClickListener {
            val desc = tvDesc.text.toString()
            val category = tvCategory.text.toString()
            val price = 2.5

            despesaDao.add(Despesa("", desc, price, category))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
