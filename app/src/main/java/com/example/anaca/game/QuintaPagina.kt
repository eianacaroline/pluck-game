package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class QuintaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quinta_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,SextaPagina::class.java)
        startActivity(intent)
    }
    fun Click1(view: View) {

        var intent: Intent = Intent(this,QuartaPagina::class.java)
        startActivity(intent)
    }
    fun Click2(view: View) {

        var intent: Intent = Intent(this,SetimaPagina::class.java)
        startActivity(intent)
    }
}
