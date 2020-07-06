package com.example.macmonei.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Despesa (@PrimaryKey(autoGenerate = true) var despesaId : String, var descDespesa : String, var priceDesc : Double, var categoryDespesa : String) : Serializable{


}