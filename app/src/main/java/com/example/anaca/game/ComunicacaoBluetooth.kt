package com.designinteracao.conexaocomarduino001

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_aplcacao_arduino.*
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception
import java.lang.ref.WeakReference
import java.nio.charset.Charset


class ComunicacaoBluetooth: Fragment() {
    private var mConnectThread: ConnectThread? = null
    private var executandoThread=true
    internal var mConnectedThread: ConnectedThread? = null
    private var mHandler: MHandler? = null
    lateinit var medicoes:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        Log.d("mer","criando fragment")
        setRetainInstance(true);
        mHandler=MHandler()
        mConnectThread = ConnectThread(SelecionarDispositivo.mDevice)
        mConnectThread!!.start()

    }


    inner class MHandler:Handler()
    {
        override fun handleMessage(msg: Message) {
            val writeBuf = msg.obj as ByteArray
            val writeMessage = String(writeBuf, Charset.forName("UTF-8"))
            Log.d("mer","O que veio"+writeMessage)
            try{
                val lista=writeMessage.split(";")
                val n=lista[0].toDouble()+10
                Log.d("mer","valor:"+n)
                medicoes.text=writeMessage
            }catch (e:Exception)
            {
                Log.d("mer","erro"+e)
            }



        }
    }
    fun write(bt:Byte)
    {
        mConnectedThread!!.write(bt)
    }
    fun start()
    {
        mConnectThread!!.start()
    }
    fun destruir()
    {
        //Destroi as threads
        executandoThread=false
        if(mConnectedThread!=null){
            mConnectedThread!!.cancel()
            mConnectedThread!!.interrupt()
            mConnectedThread=null
        }
        if(mConnectThread!=null)
        {
            mConnectThread!!.cancel()
            mConnectThread!!.interrupt()
            mConnectThread=null
        }



    }

    fun SetTxtReceber(txtview:TextView)
    {
        medicoes=txtview
    }

    inner class ConnectThread : Thread {
        var mmSocket: BluetoothSocket?;
        var mmDevice: BluetoothDevice?;
        //val HC05_UUID: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

        constructor (device: BluetoothDevice) {
            var tmp: BluetoothSocket? = null;
            mmDevice = device;
            try {
                tmp = device.createRfcommSocketToServiceRecord(SelecionarDispositivo.HC05_UUID);
            } catch (e: IOException) {
                Log.d("mer","erro para criar o socket")

            }
            mmSocket = tmp;
        }

        override fun run() {
            mConnectedThread = null;
            SelecionarDispositivo.mBluetoothAdapter!!.cancelDiscovery()
            try {
                Log.d("mer","Estado do socket antes da conexao "+mmSocket)

                mmSocket!!.connect();


                Log.d("mer","Estado do socket "+mmSocket)
                mConnectedThread =ConnectedThread (mmSocket!!)
                Log.d("mer","Criação da Connected "+mConnectedThread)
                mConnectedThread!!.start()
            } catch (connectException: IOException) {
                Log.d("mer","deu ruim "+connectException)
                try {
                    mmSocket!!.close();
                } catch (closeException: IOException) {

                    Log.d("mer","erro ao iniciar o controle")
                    cancel()

                }
                return;
            }
        }

        public fun cancel() {
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
            while (executandoThread) {
                try {
                    bytes += mmInStream!!.read(buffer, bytes, buffer.size - bytes);
                    for (i in begin..bytes){
                        if(buffer[i] == '#'.toByte()) {
                            var subBuffer=buffer.copyOfRange(begin,i)
                            mHandler!!.obtainMessage(1, subBuffer).sendToTarget();
                            begin = i + 1;
                            if(i == bytes - 1) {
                                bytes = 0;
                                begin = 0;
                            }
                        }
                    }
                } catch (e: IOException) {
                    cancel()
                    break;
                }
            }
            cancel()


        }

         fun write(bytes: Byte) {
            try {
                mmOutStream!!.write(bytes.toInt())
            } catch (e: IOException) {
                cancel()

            }
        }
        public fun cancel() {
            try {
                Log.d("mer", "fechando")
                mmInStream!!.close()
                mmOutStream!!.close()
                // mmSocket.inputStream.close()
                // mmSocket.outputStream.close()
                mmSocket.close()

            } catch (e: IOException) {
                Log.d("mer","fechando "+e)
            }
        }
    }
}