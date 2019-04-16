package com.example.anaca.game

import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception
import java.util.*

class IniciaApp : AppCompatActivity() {
    companion object {
        lateinit var mDevice: BluetoothDevice
        lateinit var mBluetoothAdapter: BluetoothAdapter
        lateinit var comunicacaoBT:ComunicacaoBluetooth
        val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
        val DISPOSITIVO_NOME="HC-05"
        val DISPOSITIVO_MAC="00:18:E4:35:F7:26"
        val VOLTA_E_FECHA=2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicia_app)
        Log.d("mer","chegou no IniciaApp")

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        //obtem os dispositivos pareados
        val pairedDevices = mBluetoothAdapter!!.getBondedDevices()
        var dispositivo_encontrado:BluetoothDevice?=null
        if (pairedDevices.size > 0) {
            //dispositivo_encontrado=verificaNome(pairedDevices)//procura por nome
            if(dispositivo_encontrado==null)
                dispositivo_encontrado=verificaMAC(pairedDevices)//procura por id
        }
        if(dispositivo_encontrado!=null) {
            mDevice=dispositivo_encontrado

            try {
                //verifica se o fragmento já existe
                comunicacaoBT =    supportFragmentManager
                        .findFragmentByTag("comunicacao_BT") as ComunicacaoBluetooth
            }catch (e: Exception)
            {
                //cria o fragment caso ele não exista
                comunicacaoBT = ComunicacaoBluetooth();
                supportFragmentManager.beginTransaction()
                        .add(comunicacaoBT, "comunicacao_BT").commit();
            }




            val novaIntent = Intent(this, MainActivity_game::class.java)
            startActivity(novaIntent)
        }
        else
            semDevice()


    }
    fun verificaNome( pd:Set<BluetoothDevice>):BluetoothDevice?{
        for(device in pd)
            if(device.name== DISPOSITIVO_NOME)
                return device

        return null
    }
    fun verificaMAC( pd:Set<BluetoothDevice>):BluetoothDevice?{
        for(device in pd) {
            Log.d("mer",device.address.toString())
            if (device.address.toString() == DISPOSITIVO_MAC)
                return device

        }

        return null
    }
    fun semDevice()
    {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Atenção")
        dialog.setMessage("Você deve primeiro parear o dispositivo $DISPOSITIVO_NOME!")
        dialog.setPositiveButton("OK") { dialog, which ->
            var retornaIntent:Intent=Intent()
            finish();
        }
        dialog.show()
    }

}
