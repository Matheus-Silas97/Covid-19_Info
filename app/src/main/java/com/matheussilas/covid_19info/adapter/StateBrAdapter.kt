package com.matheussilas.covid_19info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheussilas.covid_19info.response.StatesBrResponse
import com.matheussilas.covid_19info.R
import kotlinx.android.synthetic.main.item_states.view.*

class StateBrAdapter (val statesBr: List<StatesBrResponse>) : RecyclerView.Adapter<StateBrAdapter.BrazilViewHolder>(){



    class BrazilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val states = itemView.state
        private val cases = itemView.cases
        private val suspects = itemView.suspects
        private val deaths = itemView.deaths
        private val refuses = itemView.refuses


        fun bindView(statesBr: StatesBrResponse) {
            states.text = statesBr.state
            cases.text = statesBr.cases.toString()
            suspects.text = statesBr.suspects.toString()
            deaths.text = statesBr.deaths.toString()
            refuses.text = statesBr.refuses.toString()
        }

    }

    //onde é criado a lista com item de layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrazilViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_states, parent, false)
        return BrazilViewHolder(
            itemView
        )
    }

    //retorna a quantidade de itens da lista
    override fun getItemCount() = statesBr.count()

    //ligação dos itens da lista com componentes do recycleview
    override fun onBindViewHolder(holder: BrazilViewHolder, position: Int) {
        holder.bindView(statesBr[position])

    }
}