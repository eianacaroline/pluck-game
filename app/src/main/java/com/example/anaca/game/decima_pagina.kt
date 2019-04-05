package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class decima_pagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_pagina)}
        mensagemRecebida.setText(intent.getStringExtra("jogador"))

        fun Click(view: View) {

            var intent: Intent = Intent(this,TerceiraPagina::class.java)
            startActivity(intent)
        }
        fun Click1(view: View) {

            var intent: Intent = Intent(this,OitavaPagina::class.java)
            startActivity(intent)
    }
    fun Click2(view: View) {

        var intent: Intent = Intent(this,DecimaSegundaPagina::class.java)
        startActivity(intent)
    }
    fun Click3 (view: View) {

        var intent: Intent = Intent(this, DecimaPrimeiraPagina::class.java)
        startActivity(intent)
    }

}
