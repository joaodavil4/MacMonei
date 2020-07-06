package com.example.heros.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.macmonei.R
import com.example.macmonei.model.Despesa


class DespesaAdapter(context: Context, val objects: List<Despesa>) : ArrayAdapter<Despesa>(context, 0) {

    private lateinit var arDespesas : List<Despesa>
    var inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    init {
        arDespesas = objects
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view : View
        val holder : ViewHolder

        val despesaObj = arDespesas[position]

        if (convertView == null){
            view = inflater.inflate(R.layout.lista_despesas_adapter,parent,false)
            holder = ViewHolder(view = view)
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        holder.tvPriceDespesa.text = despesaObj.priceDesc.toString()
        holder.tvDescDespesa.text = despesaObj.descDespesa
        holder.tvCategoriaDespesa.text = despesaObj.categoryDespesa

        return view
    }


    class ViewHolder(view: View){
        var tvPriceDespesa : TextView = view.findViewById(R.id.ListaDespesas_Price)
        var tvDescDespesa : TextView = view.findViewById(R.id.ListaDespesas_Desc)
        var tvCategoriaDespesa : TextView = view.findViewById(R.id.ListaDespesas_Categoria)
    }

    fun refreshList(arDespesas : List<Despesa>){

    }

}