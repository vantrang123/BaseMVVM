package com.example.basemvvm.service

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.basemvvm.event.Event
import com.example.basemvvm.event.RxEvent
import dagger.android.DaggerService
import timber.log.Timber
import java.lang.ref.WeakReference

class ListenBluetoothService :DaggerService() {

    private val bluetoothStatusReceiver = BluetoothReceiver()

    override fun onBind(intent: Intent?): Binder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_NOT_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate() {
        super.onCreate()

        setBluetoothReceiver()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    private fun setBluetoothReceiver() {
        if (!isBluetoothSupport(applicationContext)) {
            return
        }


        try {
            unregisterReceiver(bluetoothStatusReceiver)
        } catch (e: Throwable) {
            Timber.d("bluetoothStatusReceiver is not registered?")
        }

        registerReceiver(
            bluetoothStatusReceiver,
            IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        )
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    fun isBluetoothSupport(context: Context): Boolean {
        val bluetoothAdapter: BluetoothAdapter? by lazy(LazyThreadSafetyMode.NONE) {
            val bluetoothManager =
                context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
            bluetoothManager.adapter
        }
        return bluetoothAdapter?.isEnabled ?: false
    }

    inner class BluetoothReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.let {
                when (intent.action) {
                    BluetoothAdapter.ACTION_STATE_CHANGED -> {
                        when (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1)) {
                            BluetoothAdapter.STATE_OFF -> {
                                Log.d("","BluetoothAdapter.STATE_OFF")
                                RxEvent.send(Event.ChangePermissionStatus(true))
                            }
                            BluetoothAdapter.STATE_ON -> {
                                Timber.d("BluetoothAdapter.STATE_ON")
                            }
                        }
                    }
                }
            }
        }
    }
}