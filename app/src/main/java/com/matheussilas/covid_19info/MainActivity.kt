package com.matheussilas.covid_19info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: BrazilViewModel = ViewModelProvider(this).get(BrazilViewModel::class.java)
        viewModel.brazilInfo().observe(this, Observer { data ->
                recycler.adapter = StateAdapter(data)
                recycler.layoutManager = LinearLayoutManager(this)

        })
    }

    fun alert(view: View) {
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.drawable.ic_info)
        alert.setTitle("Créditos")
        alert.setMessage("Aplicativo desenvolvido para estudo \n" +
                "Os dados apresentados são da API: covid19-brazil-api \n" +
                "Desenvolvedor: Matheus Silas")
        alert.setPositiveButton("Ok", null)
        val dialog: AlertDialog = alert.create()
        dialog.show()
    }


}
