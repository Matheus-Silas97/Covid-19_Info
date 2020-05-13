package com.matheussilas.covid_19info.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.matheussilas.covid_19info.R
import com.matheussilas.covid_19info.adapter.CountryAdapter
import com.matheussilas.covid_19info.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.activity_country.*

class CountryActivity : AppCompatActivity() {

    lateinit var viewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        supportActionBar!!.title= "Mundo"

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.countryInfo().observe(this, Observer { data ->

            recycler.adapter = CountryAdapter(data)
            recycler.layoutManager = LinearLayoutManager(this)

        })
    }
}
