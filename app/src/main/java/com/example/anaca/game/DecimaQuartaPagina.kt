package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_decima_primeira_pagina.*
import kotlinx.android.synthetic.main.activity_nonacopia_pagina.*
import kotlinx.android.synthetic.main.activity_quinta_pagina.*

class DecimaQuartaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decima_quarta_pagina)
    }
    fun Click(view: View) {

        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }


    fun ClickDetonador(view: View) {

        val intent: Intent = Intent(this,DecimaPagina::class.java)
        intent.putExtra("txtPersonagem",heroi1.text.toString())
        startActivity(intent)
        //intent.putExtra("imagemPersonagem"!; R.drawable.detonador)

    }
    fun ClickMago(view: View) {

        val intent: Intent = Intent(this,DecimaPagina::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.mago)
        intent.putExtra("txtPersonagem",heroi2.text.toString())
        startActivity(intent)
    }
    fun ClickNebulosa(view: View) {

        val intent: Intent = Intent(this,DecimaPagina::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.nebulosa)
        intent.putExtra("txtPersonagem",heroi3.text.toString())
        startActivity(intent)
        //val imageView=findViewById<ImageView>(R.id.recebePersonagem)
       // imageView.setImageResource(R.drawable.personagem_nebulosa);
    }
    fun ClickSniper(view: View) {

        val intent: Intent = Intent(this,DecimaPagina::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.sniper)
        intent.putExtra("txtPersonagem",heroi4.text.toString())
        startActivity(intent)
    }
    fun ClickValente(view: View) {

        val intent: Intent = Intent(this,DecimaPagina::class.java)
        //intent.putExtra("imagemPersonagem"!; R.drawable.valente)
        intent.putExtra("txtPersonagem",heroi5.text.toString())
        startActivity(intent)
    }
    fun ClickNext(view: View) {

        var intent: Intent = Intent(this,DecimaTerceiraPagina::class.java)
        startActivity(intent)
    }
}


