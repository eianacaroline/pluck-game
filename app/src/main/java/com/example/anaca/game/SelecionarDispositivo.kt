package com.example.anaca.game

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.designinteracao.conexaocomarduino001.AplcacaoArduino
import kotlinx.android.synthetic.main.activity_selecionar_dispositivo.*
import java.util.*

class SelecionarDispositivo : AppCompatActivity() {
    companion object {
       lateinit var mDevice:BluetoothDevice
       lateinit var mBluetoothAdapter: BluetoothAdapter
       val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecionar_dispositivo)

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        //obtem os dispositivos pareados
        val pairedDevices = mBluetoothAdapter!!.getBondedDevices()
        val pairedDevicesArrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        //preenche o array para poder exibir na lista
        if (pairedDevices.size > 0) {
            for (device in pairedDevices) {
                pairedDevicesArrayAdapter.add(device.name + "\n" + device.address)
            }
        }
        lstDevices.adapter = pairedDevicesArrayAdapter
        //Seta a ação para o click nos itens individuais da lista
        lstDevices.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            )
            {
                if(pairedDevices.elementAt(position).getUuids()[0].toString()!=
                    HC05_UUID.toString())
                {
                    Toast.makeText(
                        applicationContext,
                        "Dispositivo Incorreto!!!!", Toast.LENGTH_LONG
                    ).show()
                }
                else {
                    mDevice = pairedDevices.elementAt(position)
                    Log.d("mer", mDevice.getUuids()[0].toString())
                    val novaIntent = Intent(this@SelecionarDispositivo, AplcacaoArduino::class.java)
                    startActivity(novaIntent);
                }
            }
        }
    }
}
