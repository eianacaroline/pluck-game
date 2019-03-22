package com.example.anaca.game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.anaca.game.R.id.sample_text
import kotlinx.android.synthetic.main.activity_main_game.*

class MainActivity_game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)

    }

    fun Click(view: View) {

        var intent: Intent = Intent(this,DecimaPagina::class.java)
        startActivity(intent)
        }
    }

