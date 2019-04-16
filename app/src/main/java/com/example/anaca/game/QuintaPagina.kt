package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quinta_pagina.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class QuintaPagina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quinta_pagina)

        IniciaApp.comunicacaoBT.SetTxtReceber(txtVida)




        var vida:String=txtVida.text.toString()
        if (vida == "999"){
            Toast.makeText(applicationContext, "morreu", Toast.LENGTH_LONG).show()

        }
    }


    fun Click(view: View) {

        var intent: Intent = Intent(this,SextaPagina::class.java)
        startActivity(intent)


    }
    /*private fun resetGame() = doAsync {

        val result = URL("3.17.91.69:4567/reset_game").readText()

        uiThread{
            Log.d("Request", result)
        }
    }*/

    fun Click1(view: View) {

        var intent: Intent = Intent(this,QuartaPagina::class.java)
        startActivity(intent)
    }
    fun Click2(view: View) {

        var intent: Intent = Intent(this,SetimaPagina::class.java)
        startActivity(intent)
    }
}