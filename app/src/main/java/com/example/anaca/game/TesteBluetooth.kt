package com.example.anaca.game

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset
import java.util.*

class TesteBluetooth : AppCompatActivity() {
    var mBluetoothAdapter: BluetoothAdapter? = null
    var mDevice: BluetoothDevice? = null
    private var mConnectThread: ConnectThread? = null
    internal var mConnectedThread: ConnectedThread? = null
    lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste_bluetooth)
        mHandler=MHandler()
        //Verifica a existencia de adaptadores blueTooth
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        if (mBluetoothAdapter == null) {
            //semBlueThooth()
        } else if (!mBluetoothAdapter!!.isEnabled()) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, 1)
        }
        //Configura os devices
        val pairedDevices = mBluetoothAdapter!!.getBondedDevices()
        if (pairedDevices.size > 0) {
            for (device in pairedDevices) {
                mDevice = device
            }
        }
        //Cria a thread de conexão
        mConnectThread = ConnectThread(mDevice!!)
        mConnectThread!!.start()
    }
    fun btnPersonagemA(view: View)
    {
        val ch = 'a'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemB(view: View)
    {
        val ch = 'b'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemC(view: View)
    {
        val ch = 'c'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemD(view: View)
    {
        val ch = 'd'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemE(view: View)
    {
        val ch = 'e'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemF(view: View)
    {
        val ch = 'f'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemG(view: View)
    {
        val ch = 'g'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemH(view: View)
    {
        val ch = 'h'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemI(view: View)
    {
        val ch = 'i'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnPersonagemJ(view: View)
    {
        val ch = 'j'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }
    fun btnOk(view: View)
    {
        val ch = 'm'
        val bt = ch.toByte()
        mConnectedThread!!.write(bt)
    }


    inner class MHandler: Handler()
    {
        override fun handleMessage(msg: Message) {
            val writeBuf = msg.obj as ByteArray
            val writeMessage = String(writeBuf, Charset.forName("UTF-8"))
            txtRecebe.text=writeMessage
            Log.d("MP",writeMessage)
        }
    }

    //Classe para criar a conexão com o bluetooth
    inner class ConnectThread : Thread {
        var mmSocket: BluetoothSocket?;
        var mmDevice: BluetoothDevice?;
        val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

        constructor (device: BluetoothDevice) {
            var tmp: BluetoothSocket? = null;
            mmDevice = device;
            try {
                tmp = device.createRfcommSocketToServiceRecord(HC05_UUID);
            } catch (e: IOException) {
            }
            mmSocket = tmp;
        }

        override fun run() {
            mConnectedThread = null;
            mBluetoothAdapter!!.cancelDiscovery()
            try {
                mmSocket!!.connect();
                mConnectedThread =ConnectedThread (mmSocket!!);
                mConnectedThread!!.start()
            } catch (connectException: IOException) {
                try {
                    mmSocket!!.close();
                } catch (closeException: IOException) {
                }
                return;
            }
        }

        fun cancel() {
            try {
                mmSocket!!.close()
            } catch (e: IOException) {
            }

        }
    }
    //classe para gerenciar a conexão com o bluetooth
    inner  class ConnectedThread(private val mmSocket: BluetoothSocket) : Thread() {
        private val mmInStream: InputStream?
        private val mmOutStream: OutputStream?

        init {
            var tmpIn: InputStream? = null
            var tmpOut: OutputStream? = null
            try {
                tmpIn = mmSocket.inputStream
                tmpOut = mmSocket.outputStream
            } catch (e: IOException) {
            }

            mmInStream = tmpIn
            mmOutStream = tmpOut
        }
        //roda indefinidamente
        override fun run() {
            var buffer:ByteArray =  ByteArray(1024);
            var begin:Int = 0;
            var bytes:Int = 0;
            while (true) {
                try {
                    bytes += mmInStream!!.read(buffer, bytes, buffer.size - bytes);
                    for (i in begin..bytes){
                        if(buffer[i] == '#'.toByte()) {
                            var subBuffer=buffer.copyOfRange(begin,i)
                            mHandler.obtainMessage(1, subBuffer).sendToTarget();
                            begin = i + 1;
                            if(i == bytes - 1) {
                                bytes = 0;
                                begin = 0;
                            }
                        }
                    }
                } catch (e: IOException) {
                    break;
                }
            }
        }

        fun write(bytes: Byte) {
            try {
                mmOutStream!!.write(bytes.toInt())
            } catch (e: IOException) {
            }
        }
        fun cancel() {
            try {
                mmSocket.close()
            } catch (e: IOException) {
            }
        }
    }
}
