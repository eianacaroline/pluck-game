package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_decima_segunda_pagina.*

class DecimaSegundaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_segunda_pagina)
        nomeJogador.setText(intent.getStringExtra("nomeJogador"))
    }

    fun Click(view: View) {
        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
}
