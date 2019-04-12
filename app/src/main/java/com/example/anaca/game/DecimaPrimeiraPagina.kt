package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_decima_primeira_pagina.*
import kotlinx.android.synthetic.main.activity_nonacopia_pagina.*
import kotlinx.android.synthetic.main.activity_quinta_pagina.*

class DecimaPrimeiraPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_primeira_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,TelaSala::class.java)
        startActivity(intent)
    }


    fun ClickDetonador(view: View) {
        val ch = 'c'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)

    }
    fun ClickMago(view: View) {
        val ch = 'e'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickNebulosa(view: View) {
        val ch = 'd'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUÍNO
        IniciaApp.comunicacaoBT!!.write(bt)
        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)
    }
    fun ClickSniper(view: View) {
        val ch = 'b'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)
    }
    fun ClickValente(view: View) {
        val ch = 'a'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)
    }
    fun ClickNext(view: View) {

        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)
    }
}


