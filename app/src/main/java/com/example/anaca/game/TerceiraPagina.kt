package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TerceiraPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,SegundaPagina::class.java)
        startActivity(intent)
    }
}
