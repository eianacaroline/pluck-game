package com.designinteracao.conexaocomarduino001

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.anaca.game.R

class MainActivity : AppCompatActivity() {
    var mBluetoothAdapter: BluetoothAdapter? = null
    val BLUETOOTH_CONECTADO:Int=1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (mBluetoothAdapter != null && mBluetoothAdapter!!.isEnabled())
        {

            //para o caso do bluetooth já estar ligado
            val novaIntent=Intent(this,SelecionarDispositivo::class.java)
            startActivity(novaIntent);
        }
    }

    fun btnLigarBluetoothClick(view: View)
    {

        if (mBluetoothAdapter == null) {
            //semBlueThooth()
        } else if (!mBluetoothAdapter!!.isEnabled()) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, BLUETOOTH_CONECTADO)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==BLUETOOTH_CONECTADO)
        {
            if(RESULT_OK==resultCode)
            {
               val novaIntent=Intent(this,SelecionarDispositivo::class.java)
               startActivity(novaIntent);
            }
            else
            {
                Toast.makeText(
                    applicationContext,
                    "É necessário ligar o Bluetooth para continuar", Toast.LENGTH_LONG
                ).show()
            }
        }
}
}
