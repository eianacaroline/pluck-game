package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.app.AlertDialog
import kotlinx.android.synthetic.main.activity_decima_primeira_pagina.*
import kotlinx.android.synthetic.main.activity_decima_segunda_pagina.*
import kotlinx.android.synthetic.main.decima_pagina.*
import java.lang.Exception

class DecimaPagina : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.decima_pagina)
        recebeNome.setText(intent.getStringExtra("nomeJogador"))
        //recebePersonagem.setImage(intent.getStringExtra("imagemPersonagem"))
        recebePersonagemTexto.setText(intent.getStringExtra("txtPersonagem"))


    }
    fun Click(view: View) {

        val ch = 'P'
        val bt = ch.toByte()
        //ESSA INSTRUÇÃO MANDA COMANDOS PARA O ARDUINO
        IniciaApp.comunicacaoBT!!.write(bt)



        var intent: Intent = Intent(this,SegundaPagina::class.java)
        startActivity(intent)
    }

    fun Click1(view: View) {

        var intent: Intent = Intent(this,OitavaPagina::class.java)
        startActivity(intent)
    }
    fun Click2(view: View) {

        var intent: Intent = Intent(this,DecimaSegundaPagina::class.java)
        intent.putExtra("nomeJogador",recebeNome.text.toString())
        startActivity(intent)
    }

    fun Click3 (view: View) {

        var intent: Intent = Intent(this, DecimaPrimeiraPagina::class.java)
        startActivity(intent)
    }

    //Caixa de diálogo.
    fun Click4 (view: View) {
        val dialogInfo = AlertDialog.Builder(this@DecimaPagina).create()
        dialogInfo.setTitle("Como jogar: ")
        dialogInfo.setMessage("• Antes de iniciar o jogo, afaste o máximo possível do seu adversário\n \n" +
                "• Aperte o botão para atirar\n \n" +
                "• Mire no colete para causar dano\n \n" +
                "• Vence quem sobreviver")
        dialogInfo.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialog, which -> Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show() }
        dialogInfo.show()
    }


}
