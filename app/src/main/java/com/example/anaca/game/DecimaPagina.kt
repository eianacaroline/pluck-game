package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_decima_primeira_pagina.*
import kotlinx.android.synthetic.main.activity_decima_segunda_pagina.*
import kotlinx.android.synthetic.main.decima_pagina.*
import kotlinx.android.synthetic.main.segunda_pagina.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread
import java.lang.Exception
import java.net.URL

class DecimaPagina : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.decima_pagina)
        recebeNome.setText(intent.getStringExtra("nomeJogador"))
        recebePersonagemTexto.setText(intent.getStringExtra("txtPersonagem"))
        //imageView.setImageResource(R.drawable.personagem_nebulosa)
        //recebePersonagem.setImageResource(R.drawable.personagem_nebulosa);



    }
    fun StartGame(view: View) {
        startGameServer()

        var intent: Intent = Intent(this,TelaSala::class.java)
        startActivity(intent)
    }

    private fun startGameServer() = doAsync {
        val result = URL("http://3.17.91.69:4567/start_game?nome=lucas+dano=11+vida=30+cura=5").readText()

        uiThread{
                Log.d("Request", result)
                longToast("Request performed: " + result)
//                Params.setVidaAdv(result.toInt())
//                var showValue = findViewById(R.id.textView1) as TextView
//                showValue.setText(result)
        }
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

        var intent: Intent = Intent(this, DecimaQuartaPagina::class.java)
        startActivity(intent)
    }

    //Caixa de diálogo.
    fun Click4 (view: View) {
        val dialogInfo = AlertDialog.Builder(this).create()
        dialogInfo.setTitle("Como jogar: ")
        dialogInfo.setMessage("• Antes de iniciar o jogo, afaste o máximo possível do seu adversário\n \n" +
                "• Aperte o botão para atirar\n \n" +
                "• Mire no colete para causar dano\n \n" +
                "• Vence quem sobreviver")

        dialogInfo.setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialog, which -> Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show() }
        dialogInfo.show()
    }

}

