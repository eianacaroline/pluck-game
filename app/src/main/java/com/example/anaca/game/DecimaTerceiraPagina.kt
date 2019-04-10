package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_decima_primeira_pagina.*
import kotlinx.android.synthetic.main.activity_nonacopia_pagina.*
import kotlinx.android.synthetic.main.activity_quinta_pagina.*

class DecimaTerceiraPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_terceira_pagina)

    }
    fun Click(view: View) {
        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }

    fun ClickDetonador1(view: View) {
        val ch = 'f'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickMago1(view: View) {
        val ch = 'g'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickNebulosa1(view: View) {
        val ch = 'h'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickSniper1(view: View) {
        val ch = 'i'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickValente1(view: View) {
        val ch = 'j'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
        fun ClickJogar(view: View) {
            val ch = 'm'
            val bt = ch.toByte()
            //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
            IniciaApp.comunicacaoBT!!.write(bt)
            val intent: Intent = Intent(this,SegundaPagina::class.java)
            startActivity(intent)
        }
}
