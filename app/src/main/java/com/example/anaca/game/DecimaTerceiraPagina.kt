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
        /*btnInimigo1.setOnClickListener {
            val ch = 'f'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
        btnInimigo2.setOnClickListener {
            val ch = 'g'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
        btnInimigo3.setOnClickListener {
            val ch = 'h'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
        btnInimigo4.setOnClickListener {
            val ch = 'i'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
        btnInimigo5.setOnClickListener {
            val ch = 'j'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
        btnConfirma.setOnClickListener {
            val ch = 'm'
            val bt = ch.toByte()
            comunicacaoBT!!.write(bt)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onBackPressed() {
        //roda as finalizações necessárias, como fechar o socket de comunicação com o bluetooth
        comunicacaoBT.destruir()
        supportFragmentManager.beginTransaction().remove(comunicacaoBT).commitAllowingStateLoss();
        finish()
    }

/* fun btnLigarClick(view: View)
{
  val ch = 'L'
  val bt = ch.toByte()
  mConnectedThread!!.write(bt)
}
fun btnDesligarClick(view: View)
{
  val ch = 'D'
  val bt = ch.toByte()
  mConnectedThread!!.write(bt)
}
fun btnPiscarClick(view: View)
{
  val ch = 'P'
  val bt = ch.toByte()
  mConnectedThread!!.write(bt)
}
fun btnLerDadosClick(view: View)
{
  val ch = 'Z'
  val bt = ch.toByte()
  mConnectedThread!!.write(bt)
}*/





*/
    fun Click(view: View) {
        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }


    fun ClickDetonador(view: View) {
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickMago(view: View) {
        val intent: Intent = Intent(this@DecimaTerceiraPagina,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickNebulosa(view: View) {
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickSniper(view: View) {
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickValente(view: View) {
        val intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
        }
}
