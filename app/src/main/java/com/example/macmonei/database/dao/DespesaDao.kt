package com.example.macmonei.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.macmonei.model.Despesa

@Dao
interface DespesaDao {
    @Query("SELECT * FROM despesa")
    fun all(): List<Despesa>

    @Insert
    fun add(vararg despesa : Despesa)
}