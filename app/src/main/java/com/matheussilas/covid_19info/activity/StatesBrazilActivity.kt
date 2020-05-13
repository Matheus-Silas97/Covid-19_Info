package com.matheussilas.covid_19info.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.matheussilas.covid_19info.viewmodel.StatesBrViewModel
import com.matheussilas.covid_19info.R
import com.matheussilas.covid_19info.adapter.StateBrAdapter
import kotlinx.android.synthetic.main.activity_states_brazil.*

class StatesBrazilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_states_brazil)

        supportActionBar!!.title = "Estados do Brasil";

        val viewModel: StatesBrViewModel = ViewModelProvider(this).get(
            StatesBrViewModel::class.java
        )
        viewModel.brazilInfo().observe(this, Observer { data ->
            recycler.adapter = StateBrAdapter(data)
            recycler.layoutManager = LinearLayoutManager(this)

        })

    }
}
