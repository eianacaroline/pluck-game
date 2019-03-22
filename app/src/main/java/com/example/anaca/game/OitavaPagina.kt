package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OitavaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oitava_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
}
