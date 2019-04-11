package com.example.anaca.game

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.anaca.game.R.id.sample_text
import kotlinx.android.synthetic.main.activity_main_game.*
import kotlinx.android.synthetic.main.decima_pagina.*

class MainActivity_game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)
        val handle = Handler()
        handle.postDelayed(Runnable { mostrarMain() }, 3000)
    }

    private fun mostrarMain() {
        val intent = Intent(
                this@MainActivity_game,
                NonaPagina::class.java
        )
        startActivity(intent)
        finish()
    }

    fun Click(view: View) {

        var intent: Intent = Intent(this, NonaPagina::class.java)
        startActivity(intent)
    }
}





