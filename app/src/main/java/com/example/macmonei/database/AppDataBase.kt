package com.example.macmonei.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.macmonei.model.Despesa
import com.example.macmonei.database.dao.DespesaDao

@Database(entities = [Despesa::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun despesaDao(): DespesaDao
}


