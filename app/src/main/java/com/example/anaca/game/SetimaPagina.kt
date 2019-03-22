package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SetimaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setima_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,NonaPagina::class.java)
        startActivity(intent)
    }
}
