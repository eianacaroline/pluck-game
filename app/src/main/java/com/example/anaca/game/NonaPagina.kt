package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class NonaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nonacopia_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this@NonaPagina, decima_pagina::class.java)
        intent.putExtra("jogador",editActivityMain.text.toString())
        startActivityForResult(intent,12)
    }
}
