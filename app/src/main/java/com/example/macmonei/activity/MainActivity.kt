package com.example.macmonei.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.heros.activity.adapter.DespesaAdapter
import com.example.macmonei.R
import com.example.macmonei.database.AppDatabase
import com.example.macmonei.database.dao.DespesaDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val ACTIVITY_ADD_DESPESA: Int = 1
    private lateinit var rvListDespesas : ListView
    private lateinit var despesaAdapter : DespesaAdapter
    private lateinit var despesaDao: DespesaDao
    private lateinit var fabAddDespesa : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setWidgets()
        setFields()
        setEvents()
    }

    private fun setWidgets(){
        val database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "macmonei-database")
            .allowMainThreadQueries()
            .build()
        despesaDao = database.despesaDao()
        rvListDespesas = findViewById(R.id.ListaDespesas_RecyclerList)
        fabAddDespesa = findViewById(R.id.fab)
    }

    private fun setFields(){
        despesaAdapter = DespesaAdapter(this, despesaDao.all())
        rvListDespesas.adapter = despesaAdapter
    }

    private fun setEvents(){
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, DespesaAddActivity::class.java)
            startActivityForResult(intent, ACTIVITY_ADD_DESPESA)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val bundle = Bundle()
//        bundle.putSerializable("hero", HerosArray[position])
//
//        val intent = Intent(this, HeroDetailsActivity::class.java)
//        intent.putExtras(bundle)
//        startActivity(intent)
    }
}
