package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_nonacopia_pagina.*
import java.lang.Exception


class NonaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nonacopia_pagina)
    }

    fun Click(view: View) {

        var intent: Intent = Intent(this@NonaPagina, DecimaPagina::class.java)
        intent.putExtra("nomeJogador",nome.text.toString())
        startActivity(intent)

        /*var intent: Intent = Intent(this@NonaPagina, DecimaSegundaPagina::class.java)
        intent.putExtra("nomeJogador",nome.text.toString())
        startActivity(intent)*/
    }
}
