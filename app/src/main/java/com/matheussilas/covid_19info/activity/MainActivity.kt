package com.matheussilas.covid_19info.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.matheussilas.covid_19info.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun statesBr(view: View) {
        val intent = Intent(this, StatesBrazilActivity::class.java)
        startActivity(intent)
    }

    fun country(view: View){
        val intent = Intent(this, CountryActivity::class.java)
        startActivity(intent)
    }

    fun alertDialog(view: View) {
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.drawable.ic_info)
        alert.setTitle("Créditos")
        alert.setMessage(
            "Aplicativo desenvolvido para estudo \n" +
                    "Os dados apresentados são da API: covid19-brazil-api \n" +
                    "Desenvolvedor: Matheus Silas"
        )
        alert.setPositiveButton("Ok", null)
        val dialog: AlertDialog = alert.create()
        dialog.show()
    }


}
