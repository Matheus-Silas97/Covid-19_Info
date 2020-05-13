package com.matheussilas.covid_19info.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheussilas.covid_19info.R
import com.matheussilas.covid_19info.response.CountryResponse
import com.matheussilas.covid_19info.response.StatesBrResponse
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val country: List<CountryResponse>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val country = itemView.country_c
        private val cases = itemView.cases_c
        private val confirmed = itemView.confirmed_c
        private val deaths = itemView.deaths_c
        private val recovered = itemView.recovered_c


        fun bindView(countryInfo: CountryResponse) {

            country.text = countryInfo.country
            cases.text = countryInfo.cases.toString()
            confirmed.text = countryInfo.confirmed.toString()
            deaths.text = countryInfo.deaths.toString()
            recovered.text = countryInfo.recovered.toString()
        }


    }

    //onde é criado a lista com item de layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(
            itemView
        )
    }

    //retorna a quantidade de itens da lista
    override fun getItemCount() = country.count()

    //ligação dos itens da lista com componentes do recycleview
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindView(country[position])

    }
}