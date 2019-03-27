package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DecimaSegundaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_segunda_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,decima_pagina::class.java)
        startActivity(intent)
    }
}
