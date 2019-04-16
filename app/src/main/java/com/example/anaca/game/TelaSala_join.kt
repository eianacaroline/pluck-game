package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class TelaSala_join : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sala_join)
    }


    fun ClickVolta(view: View) {

        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
    }
    fun ClickPronto (view: View) {

        var intent: Intent = Intent(this,DecimaPrimeiraPagina::class.java)
        startActivity(intent)

    }
    fun ClickCodigo(view: View) {

        getCode()
        var intent: Intent = Intent(this,DecimaPrimeiraPagina::class.java)
        startActivity(intent)

    }
    private fun getCode() = doAsync {

        val result = URL("3.17.91.69:4567/get_code").readText()

        uiThread{
            Log.d("Request", result)
            
        }
    }
}
