package com.matheussilas.covid_19info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_states.view.*

class StateAdapter (val brazil: List<BrazilResponse>) : RecyclerView.Adapter<StateAdapter.BrazilViewHolder>(){



    class BrazilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val states = itemView.state
        private val cases = itemView.cases
        private val suspects = itemView.suspects
        private val deaths = itemView.deaths


        fun bindView(brazil: BrazilResponse) {
            states.text = brazil.state
            cases.text = brazil.cases.toString()
            suspects.text = brazil.suspects.toString()
            deaths.text = brazil.deaths.toString()
        }

    }

    //onde é criado a lista com item de layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrazilViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_states, parent, false)
        return BrazilViewHolder(itemView)
    }

    //retorna a quantidade de itens da lista
    override fun getItemCount() = brazil.count()

    //ligação dos itens da lista com componentes do recycleview
    override fun onBindViewHolder(holder: BrazilViewHolder, position: Int) {
        holder.bindView(brazil[position])

    }
}